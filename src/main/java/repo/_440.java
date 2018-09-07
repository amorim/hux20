package repo;

import model.graph.Grafo;
import model.node.BasicNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _440 extends BaseProblem {

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        while (true) {
            int alunos = scanner.nextInt(), grupos = scanner.nextInt();
            scanner.nextLine();
            if (alunos == 0 && grupos == 0)
                break;
            Grafo g = new Grafo(alunos);
            IntStream.range(0, grupos).forEach(i -> {
                List<Integer> grupo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                grupo.remove(0);
                IntStream.range(0, grupo.size()).forEach(j -> {
                    List<Integer> adj = new ArrayList<>(grupo);
                    adj.remove(j);
                    adj.forEach(k -> {
                        BasicNode n1 = new BasicNode(), n2 = new BasicNode();
                        n1.number = grupo.get(j);
                        n2.number = k;
                        g.addEdge(n1, n2);
                    });
                });
            });
            out.println(g.dfs(0) + 1);
        }
    }
}
