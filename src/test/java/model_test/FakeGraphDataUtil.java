package model_test;

import model.graph.Aresta;
import model.graph.Grafo;
import model.node.BasicNode;
import model.node.INode;

import java.util.ArrayList;

class GrafoNoProtection extends Grafo {

    public GrafoNoProtection(int vertices) {
        super(vertices);
    }

    public ArrayList<Boolean> getVisited() {
        return visited;
    }

    public ArrayList<Integer> getMinDistance() {
        return minDistance;
    }

    public ArrayList<ArrayList<Aresta>> getAdjacencia() {
        return adjacencia;
    }

    public ArrayList<Integer> getInEdges() {
        return inEdges;
    }

    public void setAdjacenciaImmediate(ArrayList<ArrayList<Aresta>> adj) {
        adjacencia = adj;
    }

    public void setInEdgesImmediate(ArrayList<Integer> inEdges) {
        this.inEdges = inEdges;
    }

    public INode getNodeByNumberPublic(int i) {
        return getNodeByNumber(i);
    }
}


public class FakeGraphDataUtil {

    // grafo: https://i.imgur.com/6FrbkHk.png
    static ArrayList<ArrayList<Aresta>> getExampleAdj() {
        ArrayList<Aresta> a1 = new ArrayList<>();
        a1.add(new Aresta(new BasicNode(1, 1), new BasicNode(4,1)));
        ArrayList<Aresta> a2 = new ArrayList<>();
        a2.add(new Aresta(new BasicNode(2, 1), new BasicNode(1, 1)));
        a2.add(new Aresta(new BasicNode(2, 5), new BasicNode(3, 5)));
        a2.add(new Aresta(new BasicNode(2,2), new BasicNode(4, 2)));
        ArrayList<Aresta> a3 = new ArrayList<>();
        a3.add(new Aresta(new BasicNode(3, 1), new BasicNode(1, 1)));
        a3.add(new Aresta(new BasicNode(3, 5), new BasicNode(5,     5)));
        ArrayList<Aresta> a4 = new ArrayList<>();
        a4.add(new Aresta(new BasicNode(4, 2), new BasicNode(5, 2)));
        ArrayList<Aresta> a5 = new ArrayList<>();
        a5.add(new Aresta(new BasicNode(5, 3), new BasicNode(3, 3)));
        ArrayList<ArrayList<Aresta>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);
        arr.add(a4);
        arr.add(a5);
        return arr;
    }

    // grafo: https://www.geeksforgeeks.org/wp-content/uploads/graph.png
    static ArrayList<ArrayList<Aresta>> getExampleAdjDAG() {
        ArrayList<Aresta> a2 = new ArrayList<>();
        a2.add(new Aresta(new BasicNode(2, 0), new BasicNode(3, 0)));
        ArrayList<Aresta> a3 = new ArrayList<>();
        a3.add(new Aresta(new BasicNode(3, 0), new BasicNode(1, 0)));
        ArrayList<Aresta> a4 = new ArrayList<>();
        a4.add(new Aresta(new BasicNode(4, 0), new BasicNode(1, 0)));
        a4.add(new Aresta(new BasicNode(4, 0), new BasicNode(0, 0)));
        ArrayList<Aresta> a5 = new ArrayList<>();
        a5.add(new Aresta(new BasicNode(5, 0), new BasicNode(2, 0)));
        a5.add(new Aresta(new BasicNode(5, 0), new BasicNode(0, 0)));
        ArrayList<ArrayList<Aresta>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        arr.add(new ArrayList<>());
        arr.add(a2);
        arr.add(a3);
        arr.add(a4);
        arr.add(a5);
        return arr;
    }

    // grafo: https://i.imgur.com/TQbo9n4.png
    static ArrayList<ArrayList<Aresta>> getExampleAdjUndirected() {
        ArrayList<Aresta> a1 = new ArrayList<>();
        a1.add(new Aresta(new BasicNode(1, 2), new BasicNode(2,2)));
        a1.add(new Aresta(new BasicNode(1, 1), new BasicNode(4, 1)));
        a1.add(new Aresta(new BasicNode(1, 2), new BasicNode(5, 2)));
        ArrayList<Aresta> a2 = new ArrayList<>();
        a2.add(new Aresta(new BasicNode(2, 2), new BasicNode(1, 2)));
        a2.add(new Aresta(new BasicNode(2, 1), new BasicNode(3, 1)));
        a2.add(new Aresta(new BasicNode(2,2), new BasicNode(4, 2)));
        ArrayList<Aresta> a3 = new ArrayList<>();
        a3.add(new Aresta(new BasicNode(3, 1), new BasicNode(2, 1)));
        a3.add(new Aresta(new BasicNode(3, 2), new BasicNode(4, 2)));
        ArrayList<Aresta> a4 = new ArrayList<>();
        a4.add(new Aresta(new BasicNode(4, 1), new BasicNode(1, 1)));
        a4.add(new Aresta(new BasicNode(4, 2), new BasicNode(2, 2)));
        a4.add(new Aresta(new BasicNode(4, 2), new BasicNode(3, 2)));
        a4.add(new Aresta(new BasicNode(4, 1), new BasicNode(5, 1)));
        ArrayList<Aresta> a5 = new ArrayList<>();
        a5.add(new Aresta(new BasicNode(5, 2), new BasicNode(1, 2)));
        a5.add(new Aresta(new BasicNode(5, 1), new BasicNode(4, 1)));
        ArrayList<ArrayList<Aresta>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);
        arr.add(a4);
        arr.add(a5);
        return arr;
    }

}
