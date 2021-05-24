package zad1.onTrees;

public class Node_Tree {
    private int value;
    private Node_Tree parent;
    private int rank = 0;

    public Node_Tree(int value) {
        this.value = value;
        parent = this;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node_Tree getParent() {
        return parent;
    }

    public void setParent(Node_Tree parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
