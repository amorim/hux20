package model.bridge;

import model.graph.Grafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Bridge {

    private int npontes = 0, cont = 0;
    private ArrayList<Integer> pre, low;
    private Set<Integer> pontes;
    private Grafo g;

    public Bridge(Grafo g) {
        this.g = g;
        pontes = new HashSet<>();
        pre = new ArrayList<>();
        low = new ArrayList<>();
        IntStream.range(0, g.getVerticesNumber() + 1).forEach(i -> {
            low.add(-1);
            pre.add(-1);
        });

        IntStream.range(1, g.getVerticesNumber() + 1).forEach(i -> {
            if (pre.get(i) == -1)
                dfs(i, i);
        });
    }

    public Set<Integer> getPontes() {
        return pontes;
    }

    private void dfs(int u, int v) {
        pre.set(v, cont);
        cont++;
        low.set(v, pre.get(v));
        g.getAdjancencia(v).forEach(n -> {
            int w = n.getNodeDest().getNodeNumber();
            if (pre.get(w) == -1) {
                dfs(v, w);
                low.set(v, Math.min(low.get(v), low.get(w)));
                if (low.get(w).equals(pre.get(w))) {
                    npontes++;
                    pontes.add(v);
                    pontes.add(w);
                }
            } else if (w != u)
                low.set(v, Math.min(low.get(v), pre.get(w)));
        });
    }
}
