package model_test;

import model.graph.Aresta;
import model.graph.Grafo;
import model.node.BasicNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GrafoTest {

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

        public void setAdjacenciaImmediate(ArrayList<ArrayList<Aresta>> adj) {
            adjacencia = adj;
        }

        public void setInEdgesImmediate(ArrayList<Integer> inEdges) {
            this.inEdges = inEdges;
        }
    }

    // grafo: https://i.imgur.com/6FrbkHk.png
    ArrayList<ArrayList<Aresta>> getExampleAdj() {
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
    ArrayList<ArrayList<Aresta>> getExampleAdjTopSort() {
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
    ArrayList<ArrayList<Aresta>> getExampleAdjUndirected() {
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

    @Test
    void testCreate() {
        GrafoNoProtection g = new GrafoNoProtection(10);
        assertAll(() -> {
            assertEquals(11, g.getAdjacencia().size(), "O tamanho da adjacencia é diferente do tamanho configurado + 1");
        }, () -> {
            assertEquals(11, g.getMinDistance().size(), "O tamanho da lista de distancias é diferente do tamanho configurado + 1");
        }, () -> {
            assertEquals(11, g.getVisited().size(), "O tamanho da lista de visitados é diferente do tamanho configurado + 1");
        });
    }

    @Test
    void testAddUndirectedEdge() {
        GrafoNoProtection g = new GrafoNoProtection(10);
        g.addUndirectedEdge(new BasicNode(1, 0), new BasicNode(2, 0));
        ArrayList<ArrayList<Aresta>> adj = g.getAdjacencia();
        assertAll(() -> {
                    assertEquals(1, adj.get(1).size(), "Adjancencia do no 1 não contem somente um no");
                }, () -> {
                    assertEquals(1, adj.get(2).size(), "Adjancencia do no 2 não contem somente um no");
                }, () -> {
                    assertEquals(2, adj.get(1).get(0).getNodeDest().getNodeNumber(), "Adjancecia do no 1 nao contem o no 2");
                }, () -> {
                    assertEquals(1, adj.get(2).get(0).getNodeDest().getNodeNumber(), "Adjancecia do no 2 nao contem o no 1");
                }
        );
    }

    @Test
    void testAddDirectedEdge() {
        GrafoNoProtection g = new GrafoNoProtection(10);
        g.addEdge(new BasicNode(1, 0), new BasicNode(2, 0));
        ArrayList<ArrayList<Aresta>> adj = g.getAdjacencia();
        assertAll(() -> {
                    assertEquals(1, adj.get(1).size(), "Adjancencia do no 1 não contem somente um no");
                }, () -> {
                    assertEquals(0, adj.get(2).size(), "Adjancencia do no 2 contem nos");
                }, () -> {
                    assertEquals(2, adj.get(1).get(0).getNodeDest().getNodeNumber(), "Adjancecia do no 1 nao contem o no 2");
                }
        );
    }

    @Test
    void testDfs() {
        GrafoNoProtection g = new GrafoNoProtection(5);
        g.setAdjacenciaImmediate(getExampleAdj());
        assertEquals( 3, g.dfs(1), "A partir do vertice 1 é possível alcançar 3 outros vertices somente");
        g = new GrafoNoProtection(5);
        g.setAdjacenciaImmediate(getExampleAdj());
        assertEquals(4, g.dfs(2), "A partir do vertice 2 é possível alcançar todos os outros vertices");
    }

    @Test
    void testPrim() {
        GrafoNoProtection g = new GrafoNoProtection(5);
        g.setAdjacenciaImmediate(getExampleAdjUndirected());
        assertEquals(5, g.prim(1), "A soma dos custos da árvore geradora minima construida a partir do vertice 1 deve ser 5");
    }

    @Test
    void testDijkstra() {
        GrafoNoProtection g = new GrafoNoProtection(5);
        g.setAdjacenciaImmediate(getExampleAdj());
        g.dijkstra(1);
        int[] values = new int[6];
        for (int i = 0; i < 6; i++) {
            values[i] = g.getMinDistance(i);
        }
        assertArrayEquals(new int[]{Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 6, 1, 3}, values, "Alguma das distancias minimas calculadas esta errada");
    }

    @Test
    void testTopologicalSort() {
        ArrayList<Integer> inEdges = new ArrayList<>();
        inEdges.add(2);
        inEdges.add(2);
        inEdges.add(1);
        inEdges.add(1);
        inEdges.add(0);
        inEdges.add(0);
        GrafoNoProtection g = new GrafoNoProtection(6);
        g.setAdjacenciaImmediate(getExampleAdjTopSort());
        g.setInEdgesImmediate(inEdges);
        ArrayList<Integer> sortedVertices = g.topologicalSort();
        int[] values = new int[6];
        for (int i = 0; i < 6; i++) {
            values[i] = sortedVertices.get(i);
        }
        assertArrayEquals(new int[]{4,5,2,0,3,1}, values, "Os valores obtidos não são a ordenação topologica esperada");
    }
}
