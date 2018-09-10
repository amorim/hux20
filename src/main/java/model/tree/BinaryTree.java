package model.tree;

public class BinaryTree<T> {
    public T item;
    public BinaryTree left, right;

    public BinaryTree(T item, BinaryTree a, BinaryTree b) {
        this.item = item;
        left = a;
        right = b;
    }

    public String getInOrderString() {
        if (left == null && right == null)
            return "";
        String fromleft = left.getInOrderString();
        fromleft += item;
        fromleft += right.getInOrderString();
        return fromleft;
    }

    public String getDfsString(int level) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < level; i++)
            s.append(" ");
        s.append(item);
        s.append(System.lineSeparator());
        if (left != null)
            s.append(left.getDfsString(level + 1));
        if (right != null)
            s.append(right.getDfsString(level + 1));
        return s.toString();
    }
}
