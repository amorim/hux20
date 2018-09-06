package model.graph;

import model.node.INode;
import model.node.INodeComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Grafo {
    private ArrayList<ArrayList<Aresta>> adjacencia;
    private int vertices;
    private ArrayList<Boolean> visited;

    public Grafo(int vertices) {
        this.vertices = vertices;
        adjacencia = new ArrayList<>();
        visited = new ArrayList<>();
        IntStream.range(0, vertices + 1).forEach(i -> {
           adjacencia.add(new ArrayList<>());
           visited.add(false);
        });

    }

    public void addUndirectedEdge(INode source, INode destination) {
        adjacencia.get(destination.getNodeNumber()).add(new Aresta(destination, source));
        addEdge(source, destination);
    }

    public void addEdge(INode source, INode destination) {
        adjacencia.get(source.getNodeNumber()).add(new Aresta(source, destination));
    }

    private INode getNodeByNumber(int node) {
        return adjacencia.get(node).get(0).getNodeSource();
    }

    public int prim(int source) {
        PriorityQueue<INode> queue = new PriorityQueue<>(new INodeComparator());
        queue.add(getNodeByNumber(source).getFreshInstance(source, 0));
        int total = 0;
        while (!queue.isEmpty()) {
            INode current = queue.poll();
            if (!visited.get(current.getNodeNumber())) {
                visited.set(current.getNodeNumber(), true);
                total += current.getWeight();
                adjacencia.get(current.getNodeNumber()).forEach(n -> {
                    if (!visited.get(n.getNodeDest().getNodeNumber())) {
                        queue.add(n.getNodeDest());
                    }
                });
            }
        }
        return total;
    }


}
