package repo;

import model.graph.Grafo;
import model.node.BasicNode;
import model.node.INode;
import model.node.INodeComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _146 extends BaseProblem {

    private class _146Grafo extends Grafo {

        ArrayList<Integer> visitedN;

        _146Grafo(int vertices) {
            super(vertices);
            visitedN = new ArrayList<>();
            IntStream.range(0, vertices + 1).forEach(i -> {
                visitedN.add(0);
            });
        }

        @Override
        public void dijkstra(int source) {
            PriorityQueue<INode> queue = new PriorityQueue<>(new INodeComparator());
            queue.add(super.getNodeByNumber(source).getFreshInstance(source, 0));
            minDistance.set(source, 0);
            while (!queue.isEmpty()) {
                INode current = queue.poll();
                if (visitedN.get(current.getNodeNumber()) < 3) {
                    visitedN.set(current.getNodeNumber(), visitedN.get(current.getNodeNumber()) + 1);
                    adjacencia.get(current.getNodeNumber()).forEach(n -> {
                        _146Node node = (_146Node) n.getNodeDest();
                        int distance = current.getWeight() + node.getWeight();
                        if ((node.semaforo == 1 && (distance - 1) % 3 == 0) || ((node.semaforo) == 0 && (distance - 1) % 3 != 0)) {
                            if (distance < minDistance.get(node.getNodeNumber()))
                                minDistance.set(node.getNodeNumber(), distance);
                            prev.set(node.getNodeNumber(), current.getNodeNumber());
                            queue.add(node.getFreshInstance(node.getNodeNumber(), distance));
                        }
                    });
                }
            }
        }
    }

    private class _146Node extends BasicNode {
        int semaforo;
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt(), e = scanner.nextInt(), s = scanner.nextInt(), m = scanner.nextInt();
        Grafo g = new _146Grafo(n);
        IntStream.range(0, m).forEach(i -> {
            int a = scanner.nextInt(), b = scanner.nextInt(), t = scanner.nextInt();
            _146Node n1 = new _146Node(), n2 = new _146Node();
            n1.number = a;
            n1.semaforo = t;
            n2.number = b;
            n2.semaforo = t;
            n1.weight = 1;
            n2.weight = 1;
            g.addEdge(n1, n2);
        });
        g.dijkstra(e);
        if (g.getMinDistance(s) == Integer.MAX_VALUE)
            out.println('*');
        else
            out.println(g.getMinDistance(s));
    }
}
