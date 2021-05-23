package BST;

public interface IBST {
    void insert(int key);
    Node findKey(int key);

    void inorder();
    void preorder();
    void postorder();

    Node treeMinimum();
    Node treeMaximum();

    int height();
    int nodesCount();
    int leavesCount();
}
