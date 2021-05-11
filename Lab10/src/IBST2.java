public interface IBST2 {
    void displayLevels();
    Node successor(int key);
    Node ancestor(int key);
    void displayTree();
    Node delete(int key);

    void setHeightAndNodesCount();
}
