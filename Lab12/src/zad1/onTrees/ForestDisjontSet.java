package zad1.onTrees;

import org.w3c.dom.Node;

import java.util.ArrayList;

public abstract class ForestDisjontSet {
    protected ArrayList<Node_Tree> nodes;
    protected int n;

    public ForestDisjontSet(int n) {
        this.n = n;
        makeSet();
    }

    public void makeSet() {
        nodes = new ArrayList<Node_Tree>();
        for (int i=0; i<n; i++)
            nodes.add(new Node_Tree(i));
    }

    abstract Node_Tree find(int value);

    Node_Tree findNode(int value) {
        Node_Tree tmp = null;

        for (int i=0; i<nodes.size(); i++) {
            tmp = nodes.get(i);

            if (tmp.getValue() == value) {
                return tmp;
            }

            while (tmp.getParent() != tmp) {
                tmp = tmp.getParent();
                if (tmp.getValue() == value) {
                    return tmp;
                }
            }
        }

        return null;
    }

    public abstract void union(int x, int y);

    public void displaySets(){
        for(int i = 0; i < nodes.size(); i++)
        {
            System.out.print("\n[");
            Node_Tree temp = nodes.get(i);

            System.out.print(temp.getValue()+", ");
            while (temp.getParent() != temp) {
                temp = temp.getParent();
                System.out.print(temp.getValue()+", ");
            }
            System.out.print("]");
        }
    }
}
