package model.node;

public class BasicNode implements INode {

    public int weight;
    public int number;

    public BasicNode() {

    }

    public BasicNode(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

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
        BasicNode p = new BasicNode();
        p.weight = weight;
        p.number = nodenumber;
        return p;
    }
}
