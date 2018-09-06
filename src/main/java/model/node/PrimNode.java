package model.node;

public class PrimNode implements INode {

    public int weight;
    public int number;

    @Override
    public int getNodeNumber() {
        return number;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public INode getFreshInstance(int nodenumber, int weight) {
        PrimNode p = new PrimNode();
        p.weight = weight;
        p.number = nodenumber;
        return p;
    }
}
