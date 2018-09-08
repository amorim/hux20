package repo;

import model.tree.BinaryTree;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class _1217 extends BaseProblem {

    public BinaryTree<Character> convertPostFixToTree(String input) {
        Stack<BinaryTree<Character>> stack = new Stack<>();
        IntStream.range(0, input.length()).forEach(i -> {
            char k = input.charAt(i);
            if (k != '*') {
                BinaryTree a = stack.pop(), b = stack.pop();
                stack.push(new BinaryTree<>(k, b, a));
            }
            else
                stack.push(new BinaryTree<>(k, null, null));
        });
        return stack.pop();
    }

    @Override
    public void solve() {
        Scanner scanner = new Scanner(in);
        BinaryTree<Character> res = convertPostFixToTree(scanner.nextLine());
        out.println("Mensagem decodificada: " + res.getInOrderString());
        out.println("Arvore construida:");
        out.println(res.getDfsString(0));
    }
}
