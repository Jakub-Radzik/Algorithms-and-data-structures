package RBTree;

public class BlackRedTree implements BlackRedInterface{
    Node root = null;
    private static final boolean RED   = true;
    private static final boolean BLACK = false;
    @Override
    public void insert(int key) {
        root = add(root, key);
        root.setColor(BLACK);
    }
    private Node add(Node node, Integer key){
        if (node == null) {
            return new Node(key, RED);
        }

        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(add(node.getLeft(), key));
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRight(add(node.getRight(), key));
        }

        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }

        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }

        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }

        return node;
    }
    private void flipColors(Node node) {
        node.setColor(RED);
        node.getLeft().setColor(BLACK);
        node.getRight().setColor(BLACK);
    }
    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.getColor() == RED;
    }
    private Node rotateRight(Node node) {
        Node x = node.getLeft();
        node.setLeft(x.getRight());
        x.setRight(node);
        x.setColor(node.getColor());
        node.setColor(RED);
        return x;
    }
    private Node rotateLeft(Node node) {
        Node x = node.getRight();
        node.setRight(x.getLeft());
        x.setLeft(node);
        x.setColor(node.getColor());
        node.setColor(RED);
        return x;
    }
    @Override
    public Node find(int key) {
        return findHelper(this.root, key);
    }
    private Node findHelper(Node node, int key) {
        if (node == null || key == node.getKey()) {
            return node;
        }

        if (key < node.getKey()) {
            return findHelper(node.getLeft(), key);
        }
        return findHelper(node.getRight(), key);
    }
    @Override
    public void displayInOrder() {
        inorderRecursive(root);
    }
    private void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.getLeft());
            if(node.getColor()==RED){
                System.out.print("[" + node.getKey() +" Red], ");
            }else{
                System.out.print("[" + node.getKey() +" Black], ");
            }
            inorderRecursive(node.getRight());
        }
    }
    @Override
    public void displayLevels() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printLevel(root, i);
            System.out.println();
        }
    }
    private void printLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.getKey() + " ");
        } else if (level > 1) {
            printLevel(root.getLeft(), level - 1);
            printLevel(root.getRight(), level - 1);
        }
    }
    @Override
    public void showParameters() {
        System.out.println("Tree height: " + height(root));
        System.out.println("Left tree height: "+ height(root.getLeft()));
        System.out.println("Right tree height: "+ height(root.getRight()));
        System.out.println("Number of roots: "+ nodesCount(root));
        System.out.println("Number of roots (Left tree): "+ nodesCount(root.getLeft()));
        System.out.println("Number of roots (Right tree): "+ nodesCount(root.getRight()));
    }
    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
    private int nodesCount(Node node) {
        int count = 1;

        if (node.getLeft() != null) {
            count += nodesCount(node.getLeft());
        }

        if (node.getRight() != null) {
            count += nodesCount(node.getRight());
        }

        return count;
    }

}
