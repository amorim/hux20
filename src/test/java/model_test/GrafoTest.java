package model_test;

import model.graph.Aresta;
import model.graph.Grafo;
import model.node.BasicNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GrafoTest {


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
    void testGetVerticesNumbers() {
        Grafo g = new Grafo(5);
        assertEquals(5, g.getVerticesNumber());
    }

    @Test
    void testGetAdj() {
        GrafoNoProtection g = new GrafoNoProtection(5);
        ArrayList<ArrayList<Aresta>> adj = FakeGraphDataUtil.getExampleAdj();
        g.setAdjacenciaImmediate(adj);
        ArrayList<Aresta> copy = FakeGraphDataUtil.getExampleAdj().get(1);
        assertEquals(copy, g.getAdjancencia(1), "a adjacencia do grafo deveria ser igual a informada");
        copy.set(0, new Aresta(new BasicNode(0, 0), new BasicNode(1, 0)));
        assertThat("as adjacecias deveriam ser diferentes", g.getAdjancencia(1), is(not(copy)));
        copy.set(0, new Aresta(new BasicNode(1, 0), new BasicNode(3, 0)));
        assertThat("as adjacecias deveriam ser diferentes", g.getAdjancencia(1), is(not(copy)));
        ArrayList<Object> teste = new ArrayList<>();
        teste.add(new Object());
        assertThat("o objeto passado não é uma adjacencia", g.getAdjancencia(1), is(not(teste)));
    }

    @Test
    void testAddTopSortEdge() {
        GrafoNoProtection g = new GrafoNoProtection(2);
        g.addTopSortEdge(new BasicNode(1, 0), new BasicNode(2, 0));
        assertEquals(1, (int)g.getInEdges().get(2), "o vertice 2 tem uma aresta chegando apenas");
    }

    @Test
    void testGetNodeByNumber() {
        GrafoNoProtection g = new GrafoNoProtection(1);
        assertNull(g.getNodeByNumberPublic(1), "não deveria ser possível obter um no em uma adjacencia vazia");
    }

    @Test
    void testReset() {
        GrafoNoProtection g = new GrafoNoProtection(5);
        g.getVisited().set(0, true);
        g.getMinDistance().set(0, 0);
        g.reset();
        assertFalse(g.getVisited().get(0), "reset do grafo deveria ter restaurando o visited");
        assertEquals(Integer.MAX_VALUE, (int)g.getMinDistance().get(0), "reset do grafo deveria ter restaurando o min_distance");
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
        g.setAdjacenciaImmediate(FakeGraphDataUtil.getExampleAdj());
        assertEquals( 3, g.dfs(1), "A partir do vertice 1 é possível alcançar 3 outros vertices somente");
        g = new GrafoNoProtection(5);
        g.setAdjacenciaImmediate(FakeGraphDataUtil.getExampleAdj());
        assertEquals(4, g.dfs(2), "A partir do vertice 2 é possível alcançar todos os outros vertices");
    }

    @Test
    void testPrim() {
        GrafoNoProtection g = new GrafoNoProtection(5);
        g.setAdjacenciaImmediate(FakeGraphDataUtil.getExampleAdjUndirected());
        assertEquals(5, g.prim(1), "A soma dos custos da árvore geradora minima construida a partir do vertice 1 deve ser 5");
    }

    @Test
    void testDijkstra() {
        GrafoNoProtection g = new GrafoNoProtection(5);
        g.setAdjacenciaImmediate(FakeGraphDataUtil.getExampleAdj());
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
        g.setAdjacenciaImmediate(FakeGraphDataUtil.getExampleAdjDAG());
        g.setInEdgesImmediate(inEdges);
        ArrayList<Integer> sortedVertices = g.topologicalSort();
        int[] values = new int[6];
        for (int i = 0; i < 6; i++) {
            values[i] = sortedVertices.get(i);
        }
        assertArrayEquals(new int[]{4,5,2,0,3,1}, values, "Os valores obtidos não são a ordenação topologica esperada");
    }
}
