package model.node;

import java.util.Comparator;

public class INodeComparator implements Comparator<INode> {
    @Override
    public int compare(INode n1, INode n2) {
        if (n1.getWeight() < n2.getWeight())
            return -1;
        if (n2.getWeight() > n1.getWeight())
            return 1;
        return 0;
    }
}
