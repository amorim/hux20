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
}
