package repo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _1021 extends BaseProblem {

    public _1021(InputStream in, PrintStream out) {
        super(in, out);
    }

    int[][] memo;
    int[] cost, w;

    int mochila(int n, int i, int rc) {
        if (i == n)
            return 0;
        if (rc == 0)
            return 0;
        if (memo[i][rc] != -1)
            return memo[i][rc];
        if (w[i] > rc)
            return mochila(n, i + 1, rc);
        int put = cost[i] + mochila(n, i + 1, rc - w[i]);
        int ignore = mochila(n, i + 1, rc);
        if (put > ignore)
            memo[i][rc] = put;
        else
            memo[i][rc] = ignore;
        return memo[i][rc];
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int testes = scanner.nextInt();
        IntStream.range(0, testes).forEach(t -> {
            int itens = scanner.nextInt();
            cost = new int[itens];
            w = new int[itens];
            IntStream.range(0, itens).forEach(i -> {
                int a = scanner.nextInt(), b = scanner.nextInt();
                cost[i] = a;
                w[i] = b;
            });
            int npeople = scanner.nextInt();
            int total = 0;
            memo = new int[itens + 1][100];
            for (int i = 0; i < itens + 1; i++)
                for (int j = 0; j < 100; j++)
                    memo[i][j] = -1;
            for (int j = 0; j < npeople; j++) {
                int budget = scanner.nextInt();
                total += mochila(itens, 0, budget);
            }
            out.println(total);
        });
    }
}
