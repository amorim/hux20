package model.graph;

import model.node.INode;

public class Aresta {
    private INode n1, n2;

    public Aresta(INode n1, INode n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public INode getNodeSource() {
        return n1;
    }

    public INode getNodeDest() {
        return n2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Aresta) {
            Aresta a = (Aresta) obj;
            return this.n1.getNodeNumber() == a.n1.getNodeNumber() && this.n2.getNodeNumber() == a.n2.getNodeNumber();
        }
        return false;
    }
}
