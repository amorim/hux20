package repo;

import model.graph.Grafo;
import model.node.BasicNode;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class  _562 extends BaseProblem {

    public _562(InputStream in, PrintStream out) {
        super(in, out);
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int testes = scanner.nextInt();
        IntStream.range(0, testes).forEach(t -> {
            int n = scanner.nextInt(), m = scanner.nextInt();
            Grafo g = new Grafo(n);
            IntStream.range(0, m).forEach(i -> {
                int u = scanner.nextInt(), v = scanner.nextInt(), time = scanner.nextInt();
                BasicNode n1 = new BasicNode(), n2 = new BasicNode();
                n1.number = u;
                n2.number = v;
                n1.weight = time;
                n2.weight = time;
                g.addUndirectedEdge(n1, n2);
            });
            int k = scanner.nextInt();
            int tot = 0;
            ArrayList<Integer> casas = new ArrayList<>();
            IntStream.range(0, k).forEach(i -> {
                casas.add(scanner.nextInt());
            });
            g.dijkstra(1);
            for (int i = 0; i < k; i++)
                tot += g.getMinDistance(casas.get(i)) * 2;
            out.println("caso " + (t+1) + ": " + tot);
        });
    }
}
