package repo;

import model.graph.Grafo;
import model.node.BasicNode;
import model.node.INode;
import model.node.INodeComparator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _738 extends BaseProblem {

    public _738(InputStream in, PrintStream out) {
        super(in, out);
    }

    private class _738Grafo extends Grafo {

        private int y;

        public _738Grafo(int vertices, int y) {
            super(vertices);
            this.y = y;
        }

        private int calcula(int now, int time) {
            if (now == 0)
                return 0;
            int temp = time;
            while (temp < now)
                temp += time;
            return temp;
        }

        @Override
        public void dijkstra(int source) {
            PriorityQueue<INode> queue = new PriorityQueue<>(new INodeComparator());
            INode star = getNodeByNumber(source);
            if (star == null)
                return;
            queue.add(star.getFreshInstance(source, 0));
            minDistance.set(source, 0);
            while (!queue.isEmpty()) {
                INode current = queue.poll();
                adjacencia.get(current.getNodeNumber()).forEach(n -> {
                    _738Node node = (_738Node) n.getNodeDest();
                    int distance = calcula(current.getWeight(), node.intervalo) + y;
                    if (distance < minDistance.get(n.getNodeDest().getNodeNumber())) {
                        minDistance.set(node.getNodeNumber(), distance);
                        queue.add(node.getFreshInstance(node.getNodeNumber(), distance));
                    }
                });
            }
        }
    }

    private class _738Node extends BasicNode {
        int intervalo;
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int testes = scanner.nextInt();
        scanner.nextLine();
        IntStream.range(0, testes).forEach(t -> {
            HashMap<String, Integer> mapao = new HashMap<>();
            String[] line = scanner.nextLine().split(" ");
            String source = line[0], dest = line[1];
            mapao.put(source, 0);
            mapao.put(dest, 1);
            int y = Integer.parseInt(line[2]), m = Integer.parseInt(line[3]);
            Grafo g = new _738Grafo(1001, y);
            int count = 2;
            for (int i = 0; i < m; i++) {
                String[] linein = scanner.nextLine().split(" ");
                if (!mapao.containsKey(linein[0])) {
                    mapao.put(linein[0], count);
                    count++;
                }
                if (!mapao.containsKey(linein[1])) {
                    mapao.put(linein[1], count);
                    count++;
                }
                _738Node n1 = new _738Node(), n2 = new _738Node();
                n1.number = mapao.get(linein[0]);
                n2.number = mapao.get(linein[1]);
                n1.weight = y;
                n2.weight = y;
                int intvl = Integer.parseInt(linein[2]);
                n1.intervalo = intvl;
                n2.intervalo = intvl;
                g.addEdge(n1, n2);
            }
            g.dijkstra(mapao.get(source));
            if (g.getMinDistance(mapao.get(dest)) != Integer.MAX_VALUE)
                out.println("Caso #" + (t+1) + ": " + g.getMinDistance(mapao.get(dest)) + " anticalmas");
            else
                out.println("Caso #" + (t+1) + ": Destino inalcancavel");
        });
    }
}
