package model.graph;

import java.util.ArrayList;

public class Grafo<T> {
    private ArrayList<ArrayList<Aresta<T>>> adjacencia;
    private int vertices;
    private ArrayList<Boolean> visited;

    public Grafo(int vertices) {
        this.vertices = vertices;
        this.adjacencia = new ArrayList<>(vertices);
        this.visited = new ArrayList<>(vertices);
        T a = (T) new Object();
        a.dfd = 1;
    }

    public void addEdge(T source, T destination) {
        adjacencia.get(source.getNodeNumber()).add(new Aresta<>(source, destination));
    }


}
