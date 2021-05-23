package BST;

public class Node {
    private Node parent;
    private int key;
    private Node left;
    private Node right;

    private int height;
    private int nodesCount;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNodesCount() {
        return nodesCount;
    }

    public void setNodesCount(int nodesCount) {
        this.nodesCount = nodesCount;
    }

    public Node(Node parent, int key, Node left, Node right) {
        this.parent = parent;
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public Node(int item) {
        this.key = item;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
        this. nodesCount = 0;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=====================================\n");
        sb.append("[Node key: ");
        sb.append(this.getKey());
        if(this.getParent()!=null){
            sb.append(" || Parent key: ");
            sb.append(this.getParent().getKey());
        }else{
            sb.append(" ROOT");
        }


        sb.append("]\n");

        sb.append("[Height: ");
        sb.append(this.getHeight());
        sb.append(" || Nodes count: ");
        sb.append(this.getNodesCount());
        sb.append("]\n");

        if(this.getLeft()!=null){
            sb.append("[Left Key: ");
            sb.append(this.getLeft().getKey());
        }

        if(this.getRight()!=null){
            sb.append("|| Right Key: ");
            sb.append(this.getRight().getKey());
        }

        sb.append("]\n");
        sb.append("=====================================");



        return sb.toString();
    }
}
