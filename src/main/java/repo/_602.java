package repo;

import java.util.Arrays;
import java.util.Scanner;

public class _602 extends BaseProblem {

    private int[][] matriz;

    private int getMaxGain(int[] arr, int ano, int posStart, int posEnd) {
        if (posStart > posEnd)
            return 0;
        if (matriz[posStart][posEnd] == -1)
            matriz[posStart][posEnd] = Math.max(getMaxGain(arr, ano+1, posStart + 1, posEnd) + arr[posStart] * ano, getMaxGain(arr, ano+1, posStart, posEnd - 1) + arr[posEnd] * ano);
        return matriz[posStart][posEnd];
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        matriz = new int[n][n];
        for (int[] i : matriz)
            Arrays.fill(i, -1);
        int max = getMaxGain(arr, 1, 0, n - 1);
        out.println(max);
    }
}
