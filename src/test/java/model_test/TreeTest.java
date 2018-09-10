package model_test;

import model.tree.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeTest {

    private BinaryTree<Character> bin = new BinaryTree<>('A',
            new BinaryTree<>('B',
                    new BinaryTree<>('*', null, null),
                    new BinaryTree<>('*', null, null)),
            new BinaryTree<>('C',
                    new BinaryTree<>('*', null, null),
                    new BinaryTree<>('*', null, null)));

    @Test
    void testInOrderString() {
        assertEquals("BAC", bin.getInOrderString(), "a impressão em ordem da arvore está incorreta");
    }

    @Test
    void testDfsString() {
        assertEquals("A" + System.lineSeparator() +
                " B" + System.lineSeparator() +
                "  *" + System.lineSeparator() +
                "  *" + System.lineSeparator() +
                " C" + System.lineSeparator() +
                "  *" + System.lineSeparator() +
                "  *" + System.lineSeparator(), bin.getDfsString(0), "a string da exploração DFS está incorreta");
    }
}
