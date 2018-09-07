package model.node;

public interface  INode {
    public int getNodeNumber();

    public int getWeight();

    public INode getFreshInstance(int nodenumber, int weight);
}
