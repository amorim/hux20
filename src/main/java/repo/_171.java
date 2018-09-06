package repo;

import model.graph.Grafo;
import model.node.PrimNode;

import java.util.Scanner;
import java.util.stream.IntStream;

public class _171 extends BaseProblem {

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Grafo grafo = new Grafo(n);
        IntStream.range(0, m).forEach(i -> {
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
            PrimNode n1 = new PrimNode(), n2 = new PrimNode();
            n1.number = a;
            n2.number = b;
            n1.weight = c;
            n2.weight = c;
            grafo.addUndirectedEdge(n1, n2);
        });

        out.println(grafo.prim(1));
    }
}