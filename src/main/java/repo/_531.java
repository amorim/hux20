package repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _531 extends BaseProblem {

    @Override
    public void solve() {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextInt())
            lista.add(scanner.nextInt());
        for (int i = 0; i < lista.size() - 1; i++) {
            int menor = lista.get(i);
            int menorindice = i;
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(j) < menor) {
                    menor = lista.get(j);
                    menorindice = j;
                }
            }
            Collections.swap(lista,i, menorindice);
            out.println("Menor elemento neste passo: " + menor);
            out.print("Estado Atual: " + lista.get(0));
            for (int k = 1; k < lista.size(); k++) {
                out.print(" | " + lista.get(k));
            }
            out.println();
            out.println();
        }
        out.print("Resultado Final: " + lista.get(0));
        for (int k = 1; k < lista.size(); k++) {
            out.print(" | " + lista.get(k));
        }
    }
}
