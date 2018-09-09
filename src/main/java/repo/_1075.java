package repo;

import model.bridge.Bridge;
import model.graph.Grafo;
import model.node.BasicNode;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class _1075 extends BaseProblem {

    public _1075(InputStream in, PrintStream out) {
        super(in, out);
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Grafo g = new Grafo(n);
        IntStream.range(0, m).forEach(i -> {
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
            BasicNode n1 = new BasicNode(), n2 = new BasicNode();
            n1.number = a;
            n2.number = b;
            n1.weight = c;
            n2.weight = c;
            g.addUndirectedEdge(n1, n2);
        });
        g.dijkstra(1);
        Bridge b = new Bridge(g);
        Set<Integer> bridges = b.getPontes();
        int min = Integer.MAX_VALUE;
        for (Integer i : bridges)
            if (g.getMinDistance(i) < min)
                min = g.getMinDistance(i);
        if (min == Integer.MAX_VALUE)
            out.println("It's not possible");
        else
            out.println("It's possible with distance " + min);
    }
}
