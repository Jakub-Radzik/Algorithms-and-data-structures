package zad1.onTrees;

public class ForestDisjointSetCompression extends ForestDisjontSet{
    public ForestDisjointSetCompression(int n) {
        super(n);
    }

    @Override
    public void makeSet() {
        super.makeSet();
    }

    //COMPRESSION
    @Override
    Node_Tree find(int value) {
        Node_Tree node = findNode(value);
        Node_Tree tmp = node.getParent();

        while (tmp.getParent() != tmp) {
            tmp = tmp.getParent();
        }

        node.setParent(tmp);
        return tmp;
    }

    //NO STABILIZATION
    @Override
    public void union(int x, int y) {
        Node_Tree node1 = find(x);
        Node_Tree node2 = find(y);

        if (node1 == node2) {
            return;
        }

        node1.setParent(node2);
        nodes.remove(node2);
    }

}
