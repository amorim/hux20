package model.node;

import java.util.Comparator;

public class INodeComparator implements Comparator<INode> {
    @Override
    public int compare(INode n1, INode n2) {
        return Integer.compare(n1.getWeight(), n2.getWeight());
    }
}
