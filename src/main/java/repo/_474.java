package repo;

import model.graph.Grafo;
import model.node.BasicNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _474 extends BaseProblem {

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        out.println("SHIPPING ROUTES OUTPUT\n");
        int testes = scanner.nextInt();
        IntStream.range(0, testes).forEach(t -> {
            out.println("DATA SET " + (t + 1) + "\n");
            int m = scanner.nextInt(), n = scanner.nextInt(), p = scanner.nextInt();
            scanner.nextLine();
            HashMap<String, Integer> mapao = new HashMap<>();
            String[] portos = scanner.nextLine().split(" ");
            IntStream.range(0, portos.length).forEach(i -> {
                mapao.put(portos[i], i);
            });
            Grafo g = new Grafo(m);
            IntStream.range(0, n).forEach(i -> {
                String[] s = scanner.nextLine().split(" ");
                BasicNode n1 = new BasicNode(), n2 = new BasicNode();
                n1.number = mapao.get(s[0]);
                n2.number = mapao.get(s[1]);
                n1.weight = 1;
                n2.weight = 1;
                g.addUndirectedEdge(n1, n2);
            });
            IntStream.range(0, p).forEach(i -> {
                String[] q = scanner.nextLine().split(" ");
                q = Arrays.stream(q).filter(s -> !s.equals("")).collect(Collectors.toList()).toArray(q);
                g.dijkstra(mapao.get(q[1]));
                if (g.getMinDistance(mapao.get(q[2])) != Integer.MAX_VALUE)
                    out.println("$" + (100*Integer.parseInt(q[0])*g.getMinDistance(mapao.get(q[2]))));
                else
                    out.println("NO SHIPMENT POSSIBLE");
                g.reset();
            });
            out.println();
        });
        out.println("END OF OUTPUT");
    }
}
