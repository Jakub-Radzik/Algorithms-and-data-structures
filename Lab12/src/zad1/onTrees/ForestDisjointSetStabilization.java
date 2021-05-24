package zad1.onTrees;

public class ForestDisjointSetStabilization extends ForestDisjontSet{
    public ForestDisjointSetStabilization(int n) {
        super(n);
    }

    @Override
    public void makeSet() {
        super.makeSet();
    }

    //NO COMPRESSION
    @Override
    Node_Tree find(int value) {
        Node_Tree node = findNode(value);
        Node_Tree tmp = node.getParent();

        while (tmp.getParent() != tmp) {
            tmp = tmp.getParent();
        }

        return tmp;
    }

    @Override
    Node_Tree findNode(int value) {
        return super.findNode(value);
    }

    //STABILIZATION HEIGHT
    @Override
    public void union(int x, int y) {
        Node_Tree node1 = find(x);
        Node_Tree node2 = find(y);

        if (node1 == node2) {
            return;
        }

        nodes.remove(node2);

        if (node1.getRank() < node2.getRank()) {
            node2.setParent(node1);
        }
        else if (node2.getRank() < node1.getRank()) {
            node1.setParent(node2);
        }
        else {
            node1.setParent(node2);
            node2.setRank(node2.getRank() + 1);
        }
    }

}
