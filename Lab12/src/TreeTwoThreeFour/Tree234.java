package TreeTwoThreeFour;

import BST.BST;

import java.util.ArrayList;

public class Tree234 {
    private Node root = new Node();

    private static int findTry = 0;

    public static int getFindTry() {
        return findTry;
    }

    public static void setFindTry(int findTry) {
        Tree234.findTry = findTry;
    }

    ArrayList<Integer> inorder = new ArrayList<>();
    public Node find(int key) {
        Node curNode = root;
        int childNumber;
        while (true) {
            if ((childNumber = curNode.findItem(key)) != -1) {
                setFindTry(findTry+1);
                return curNode;
            } else if (curNode.isLeaf()) {
                setFindTry(findTry+1);
                return null;
            } else {
                setFindTry(findTry+1);
                curNode = getNextChild(curNode, key);
            }
        }
    }
    public void insert(int dValue) {
        Node curNode = root;
        int tempItem = dValue;

        while (true) {
            if (curNode.isFull()) {
                split(curNode);
                curNode = curNode.getParent();

                curNode = getNextChild(curNode, dValue);
            } else if (curNode.isLeaf()) {
                break;
            } else {
                curNode = getNextChild(curNode, dValue);
            }
        }
        curNode.insertItem(tempItem);
    }
    public void displayLevels() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printLevel(root, i);
            System.out.println();
        }
    }
    private void printLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            node.displayNode();
        } else if (level > 1) {
            for (int i = 0; i < node.getChildArray().length; i++) {
                printLevel(node.getChild(i), level - 1);
            }
        }
    }
    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getChild(0)), Math.max(height(node.getChild(1)),height(node.getChild(2))));
    }

    public int minimum(){
        return min(root);
    }
    private int min(Node node){
        if(node.isLeaf()){
            return node.getItem(0);
        }else{
            return min(node.getChild(0));
        }
    }
    public int maximum(){
        return max(root);
    }
    private int max(Node node){
        if(node.isLeaf()){
            return node.getItem(node.getNumItems()-1);
        }else{
            for (int i = 0; i < node.getChildArray().length; i++) {
                if (node.getChildArray()[i]==null){
                    return max(node.getChildArray()[i-1]);
                }
            }
            return 0;
        }
    }
    public void inorder(){
        inorder.clear();
        inorderTravelsal(root, inorder);
        System.out.print("Inorder: ");
        inorder.forEach(el -> System.out.print(el+", "));
        System.out.println();
    }
    private void inorderTravelsal(Node node, ArrayList<Integer> inorder){
        if(node == null) return;

        inorderTravelsal(node.getChild(0), inorder);

        for (int i = 0; i < node.getNumItems(); i++){
            inorder.add(node.getItem(i));
            inorderTravelsal(node.getChild(i+1), inorder);
        }
    }
    public Integer successor(int key){
        inorder.clear();
        inorderTravelsal(root, inorder);

        for (int i = 0; i < inorder.size(); i++) {
            if(inorder.get(i)==key){
                try{
                    return inorder.get(i+1);
                }catch(IndexOutOfBoundsException ex){
                    return null;
                }
            }
        }
        return null;
    }
    public Integer ancestor(int key){
        inorder.clear();
        inorderTravelsal(root, inorder);

        for (int i = 0; i < inorder.size(); i++) {
            if(inorder.get(i)==key){
                try{
                    return inorder.get(i-1);
                }catch(IndexOutOfBoundsException ex){
                    return null;
                }
            }
        }
        return null;
    }
    public void split(Node thisNode) {

        Integer itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);

        Node newRight = new Node();

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else
            parent = thisNode.getParent();

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int j = n - 1; j > itemIndex; j--) {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }
        parent.connectChild(itemIndex + 1, newRight);


        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }
    public Node getNextChild(Node theNode, long theValue) {
        int j;

        int numItems = theNode.getNumItems();
        for (j = 0; j < numItems; j++) {
            if (theValue < theNode.getItem(j)) {
                return theNode.getChild(j);
            }
        }
        return theNode.getChild(j);
    }
}
