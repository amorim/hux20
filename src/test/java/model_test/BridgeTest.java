package model_test;

import model.bridge.Bridge;
import model.node.BasicNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeTest {
    @Test
    void testBridgeDetection() {
        GrafoNoProtection g = new GrafoNoProtection(4);
        g.addUndirectedEdge(new BasicNode(1, 0), new BasicNode(2, 0));
        g.addUndirectedEdge(new BasicNode(2, 0), new BasicNode(3, 0));
        g.addUndirectedEdge(new BasicNode(3, 0), new BasicNode(4, 0));
        g.addUndirectedEdge(new BasicNode(1, 0), new BasicNode(3, 0));
        Bridge b = new Bridge(g);
        Set<Integer> set = b.getPontes();
        assertEquals(2, set.size(), "o grafo de exemplo contem somente uma ponte");
        Integer[] bridges = set.toArray(new Integer[0]);
        Arrays.sort(bridges);
        assertArrayEquals(new Integer[]{3, 4}, bridges, "a aresta 3-4 é a ponte");
    }
}
