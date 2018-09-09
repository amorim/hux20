package repo;

import model.graph.Grafo;
import model.node.BasicNode;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _440 extends BaseProblem {

    public _440(InputStream in, PrintStream out) {
        super(in, out);
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        while (true) {
            int alunos = scanner.nextInt(), grupos = scanner.nextInt();
            if (alunos == 0 && grupos == 0)
                break;
            Grafo g = new Grafo(alunos);
            IntStream.range(0, grupos).forEach(i -> {
                int ngrupos = scanner.nextInt();
                int[] grupo = new int[ngrupos];
                for (int j = 0; j < ngrupos; j++)
                    grupo[j] = scanner.nextInt();
                int l = grupo[0];
                for (int k = 1; k < ngrupos; k++) {
                    BasicNode n1 = new BasicNode(), n2 = new BasicNode();
                    n1.number = l;
                    n2.number = grupo[k];
                    g.addUndirectedEdge(n1, n2);
                }
            });
            out.println(g.dfs(0) + 1);
        }
    }
}
