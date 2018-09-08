package repo;

import model.graph.Grafo;
import model.node.BasicNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _603 extends BaseProblem {

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int contador = 1;
        int n = scanner.nextInt();
        while (n != 0) {
            scanner.nextLine();
            HashMap<String, Integer> mapaIn = new HashMap<>();
            HashMap<Integer, String> mapaOut = new HashMap<>();
            int cont = 0;
            String[] amigos = scanner.nextLine().split(" ");
            Grafo g = new Grafo(n);
            for (String amigo : amigos) {
                mapaIn.put(amigo, cont);
                mapaOut.put(cont, amigo);
                cont += 1;
            }
            IntStream.range(0, n).forEach(i -> {
                String[] edges = scanner.nextLine().split(" ");
                int s = mapaIn.get(edges[0]);
                int qt = Integer.parseInt(edges[1]);
                for (int j = 2; j < qt + 2; j++) {
                    BasicNode n1 = new BasicNode(), n2 = new BasicNode();
                    n1.number = mapaIn.get(edges[j]);
                    n2.number = s;
                    g.addTopSortEdge(n1, n2);
                }
            });
            ArrayList<Integer> top = g.topologicalSort();
            out.println("Teste " + contador);
            contador++;
            if (top.size() < n)
                out.println("impossivel");
            else {
                for (int i = 0; i < top.size(); i++) {
                    if (i == top.size() - 1)
                        out.println(mapaOut.get(top.get(i)));
                    else
                        out.print(mapaOut.get(top.get(i)) + " ");
                }
            }
            out.println();
            n = scanner.nextInt();

        }
    }
}
