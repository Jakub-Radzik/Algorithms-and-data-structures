import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BST implements IBST, IBST2 {
    private Node root;

    public BST() {
        this.root = null;
    }

    /**
     * Insert Elements
     *
     * @param key
     */
    @Override
    public void insert(int key) {
        root = insertRecursive(root, key);
        setHeightAndNodesCount();
    }

    private Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.getKey()) {
            root.setLeft(insertRecursive(root.getLeft(), key));
            root.getLeft().setParent(root);
        } else if (key > root.getKey()) {
            root.setRight(insertRecursive(root.getRight(), key));
            root.getRight().setParent(root);
        }
        return root;
    }

    /**
     * Find key
     *
     * @param key
     */
    @Override
    public Node findKey(int key) {
        return findKeyRecursive(root, key);
    }

    private Node findKeyRecursive(Node root, int key) {
        if (root == null || root.getKey() == key) {
            return root;
        }

        if (root.getKey() < key) {
            return findKeyRecursive(root.getRight(), key);
        }

        return findKeyRecursive(root.getLeft(), key);
    }

    /**
     * INORDER DISPLAY
     */
    @Override
    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.getLeft());
            System.out.print(root.getKey() + ", ");
            inorderRecursive(root.getRight());
        }
    }

    /**
     * PREORDER DISPLAY
     */
    @Override
    public void preorder() {
        preorderRecursive(root);
    }

    private void preorderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.getKey() + ", ");
            inorderRecursive(root.getLeft());
            inorderRecursive(root.getRight());
        }
    }

    /**
     * POSTORDER DISPLAY
     */
    @Override
    public void postorder() {
        postorderRecursive(root);
    }

    private void postorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.getLeft());
            inorderRecursive(root.getRight());
            System.out.print(root.getKey() + ", ");
        }
    }

    /**
     * Find minimum key in BST
     *
     * @return key
     */
    @Override
    public Node treeMinimum() {
        return min(root);
    }

    private Node min(Node node) {
        Node current = node;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    /**
     * Find maximum key in BST
     *
     * @return key
     */
    @Override
    public Node treeMaximum() {
        return max(root);
    }

    private Node max(Node node) {
        Node current = node;

        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    /**
     * Height of BST
     *
     * @return
     */
    @Override
    public int height() {
        return h(root);
    }

    private int h(Node node) {
        if (node == null)
            return 0;
        else {
            int leftHeight = h(node.getLeft());
            int rightHeight = h(node.getRight());

            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else
                return (rightHeight + 1);
        }
    }

    @Override
    public int nodesCount() {
        return nodesCountRecursive(root);
    }

    private int nodesCountRecursive(Node node) {
        int count = 1;

        if (node.getLeft() != null) {
            count += nodesCountRecursive(node.getLeft());
        }

        if (node.getRight() != null) {
            count += nodesCountRecursive(node.getRight());
        }

        return count;
    }


    @Override
    public int leavesCount() {
        return leavesCountRecursive(root);
    }

    private int leavesCountRecursive(Node node) {
        int count = 0;
        if (node.getLeft() == null && node.getRight() == null) {
            count = 1;
        } else {
            if (node.getLeft() != null) {
                count += leavesCountRecursive(node.getLeft());
            }

            if (node.getRight() != null) {
                count += leavesCountRecursive(node.getRight());
            }
        }
        return count;
    }


    //1b

    @Override
    public void displayLevels() {
        int h = height();
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


    /**
     * SUCCESSOR INORDER
     *
     * @param key
     * @return
     */
    @Override
    public Node successor(int key) {
        Node successor = successorNode(root, key);

        if (successor != null) {
            return successor;
        }

        return null;
    }

    private Node successorNode(Node node, int key) {
        if (node == null) throw new NoSuchElementException();
        int cmp = Integer.compare(key, node.getKey()); //TODO: WARNING IDK
        if (cmp == 0) {
            if (node.getRight() != null)
                return min(node.getRight());
            else return null;
        } else if (cmp < 0) {
            Node retNode = successorNode(node.getLeft(), key);
            return retNode == null ? node : retNode;
        } else {
            return successorNode(node.getRight(), key);
        }
    }

    /**
     * ANCESTOR INORDER
     *
     * @param key
     * @return
     */
    @Override
    public Node ancestor(int key) {
        Node givenNode = findKey(key);
        Node rootCp = root;

        if (givenNode != null) {
            if (givenNode.getLeft() != null) {
                return max(givenNode.getLeft());
            } else {
                rootCp = givenNode.getParent();
                while (root != null && givenNode == rootCp.getLeft()) {
                    givenNode = rootCp;
                    rootCp = rootCp.getParent();
                }
                return rootCp;
            }
        }

        return givenNode;
    }


    @Override
    public Node delete(int key) {
        return TreeDelete(root, key);
    }

    private Node TreeDelete(Node root, int key) {
        Node z = findKey(key);
        Node y = null;
        Node x = null;

        if (z.getLeft() == null || z.getRight() == null) {
            y = z;
        } else {
            y = this.successor(key);
        }

        if (y.getLeft() != null) {
            x = y.getLeft();
        } else {
            x = y.getRight();
        }

        if (x != null) {
            x.setParent(y.getParent());
        }

        if (y.getParent() == null) {
            root = x;
        } else if (y == y.getParent().getLeft()) {
            y.getParent().setLeft(x);
        } else {
            y.getParent().setRight(x);
        }

        if (y != z) {
            int temp = z.getKey();
            z.setKey(y.getKey());
            y.setKey(temp);
        }

        setHeightAndNodesCount();
        return y;
    }


    @Override
    public void setHeightAndNodesCount() {
        root.setNodesCount(this.nodesCount());
        root.setHeight(this.height());

        if (root.getLeft() != null) {
            setHeightAndNodesCountRecursive(root.getLeft());
        }

        if (root.getRight() != null) {
            setHeightAndNodesCountRecursive(root.getRight());
        }
    }

    private void setHeightAndNodesCountRecursive(Node node) {
        node.setNodesCount(this.nodesCountRecursive(node));
        node.setHeight(this.h(node));

        if (node.getLeft() != null) {
            setHeightAndNodesCountRecursive(node.getLeft());
        }

        if (node.getRight() != null) {
            setHeightAndNodesCountRecursive(node.getRight());
        }

    }


    @Override
    public void displayTree() {
//        System.out.println(traversePreOrder(root));
        print(root);
    }

    private String traversePreOrder(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getKey());

        String pointerLeft = "└──";
        String pointerRight = (root.getLeft() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerRight, root.getRight(), root.getLeft() != null);
        traverseNodes(sb, "", pointerLeft, root.getLeft(), false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
                               boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getKey());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerLeft = "└──";
            String pointerRight = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), node.getLeft() != null);
            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), false);
        }
    }


    public void print(Node root) {

        List<List<String>> lines = new ArrayList<List<String>>();

        List<Node> level = new ArrayList<Node>();
        List<Node> next = new ArrayList<Node>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (Node n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = Integer.toString(n.getKey());
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }

}
