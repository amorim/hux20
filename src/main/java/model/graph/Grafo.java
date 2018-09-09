package model.graph;

import model.node.BasicNode;
import model.node.INode;
import model.node.INodeComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Grafo {
    protected ArrayList<ArrayList<Aresta>> adjacencia;
    protected int vertices;
    protected ArrayList<Boolean> visited;
    protected ArrayList<Integer> minDistance;
    protected ArrayList<Integer> prev;
    protected ArrayList<Integer> inEdges;

    public Grafo(int vertices) {
        this.vertices = vertices;
        adjacencia = new ArrayList<>();
        visited = new ArrayList<>();
        minDistance = new ArrayList<>();
        prev = new ArrayList<>();
        inEdges = new ArrayList<>();
        IntStream.range(0, vertices + 1).forEach(i -> {
            adjacencia.add(new ArrayList<>());
            visited.add(false);
            minDistance.add(Integer.MAX_VALUE);
            prev.add(-1);
            inEdges.add(0);
        });

    }

    public int getVerticesNumber() {
        return vertices;
    }

    public ArrayList<Aresta> getAdjancencia(int i) {
        return adjacencia.get(i);
    }

    public void addUndirectedEdge(INode source, INode destination) {
        adjacencia.get(destination.getNodeNumber()).add(new Aresta(destination, source));
        addEdge(source, destination);
    }

    public void addTopSortEdge(INode source, INode destination) {
        inEdges.set(destination.getNodeNumber(), inEdges.get(destination.getNodeNumber()) + 1);
        addEdge(source, destination);
    }

    public void addEdge(INode source, INode destination) {
        adjacencia.get(source.getNodeNumber()).add(new Aresta(source, destination));
    }

    protected INode getNodeByNumber(int node) {
        if (adjacencia.get(node).size() < 1)
            return null;
        return adjacencia.get(node).get(0).getNodeSource();
    }

    public void reset() {
        visited = new ArrayList<>();
        minDistance = new ArrayList<>();
        prev = new ArrayList<>();
        IntStream.range(0, vertices + 1).forEach(i -> {
            visited.add(false);
            minDistance.add(Integer.MAX_VALUE);
            prev.add(-1);
        });
    }

    public Integer getMinDistance(int i) {
        return minDistance.get(i);
    }

    public int dfs(int source) {
        visited.set(source, true);
        int sum = 0;
        for (Aresta n : adjacencia.get(source)) {
            if (!visited.get(n.getNodeDest().getNodeNumber())) {
                visited.set(n.getNodeDest().getNodeNumber(), true);
                sum++;
                sum += dfs(n.getNodeDest().getNodeNumber());
            }
        }
        return sum;
    }

    public int prim(int source) {
        PriorityQueue<INode> queue = new PriorityQueue<>(new INodeComparator());
        BasicNode bn = new BasicNode();
        bn.number = source;
        bn.weight = 0;
        queue.add(bn);
        int total = 0;
        while (!queue.isEmpty()) {
            INode current = queue.poll();
            if (!visited.get(current.getNodeNumber())) {
                visited.set(current.getNodeNumber(), true);
                total += current.getWeight();
                adjacencia.get(current.getNodeNumber()).forEach(n -> {
                    queue.add(n.getNodeDest());
                });
            }
        }
        return total;
    }

    public void dijkstra(int source) {
        PriorityQueue<INode> queue = new PriorityQueue<>(new INodeComparator());
        INode snode = getNodeByNumber(source);
        if (snode == null)
            return;
        queue.add(snode.getFreshInstance(source, 0));
        minDistance.set(source, 0);
        while (!queue.isEmpty()) {
            INode current = queue.poll();
            adjacencia.get(current.getNodeNumber()).forEach(n -> {
                int distance = current.getWeight() + n.getNodeDest().getWeight();
                if (distance < minDistance.get(n.getNodeDest().getNodeNumber())) {
                    minDistance.set(n.getNodeDest().getNodeNumber(), distance);
                    prev.set(n.getNodeDest().getNodeNumber(), current.getNodeNumber());
                    queue.add(n.getNodeDest().getFreshInstance(n.getNodeDest().getNodeNumber(), distance));
                }
            });
        }
    }

    public ArrayList<Integer> topologicalSort() {
        ArrayList<Integer> l = new ArrayList<>(), queue = new ArrayList<>();
        IntStream.range(0, vertices).forEach(i -> {
            if (inEdges.get(i) == 0)
                queue.add(0, i);
        });
        while (!queue.isEmpty()) {
            int n = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            l.add(n);
            adjacencia.get(n).forEach(a -> {
                int m = a.getNodeDest().getNodeNumber();
                inEdges.set(m, inEdges.get(m) - 1);
                if (inEdges.get(m) == 0)
                    queue.add(0, m);
            });
        }
        return l;
    }


}
