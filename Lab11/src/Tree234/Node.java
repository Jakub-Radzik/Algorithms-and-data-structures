package Tree234;

class Node {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private Integer nodeValuesArray[] = new Integer[ORDER - 1];

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return (childArray[0] == null) ? true : false;
    }
    public int getNumItems() {
        return numItems;
    }

    public Integer getItem(int index) {
        return nodeValuesArray[index];
    }
    public boolean isFull() {
        return numItems == ORDER - 1;
    }
    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (nodeValuesArray[j] == null) {
                break;
            } else if (nodeValuesArray[j] == key) {
                return j;
            }
        }
        return -1;
    }
    public int insertItem(int newItem) {

        numItems++;
        Integer newKey = newItem;

        for (int j = ORDER - 2; j >= 0; j--) {
            if (nodeValuesArray[j] == null) {
                continue;
            } else {
                int itsKey = nodeValuesArray[j];
                if (newKey < itsKey) {
                    nodeValuesArray[j + 1] = nodeValuesArray[j];
                } else {
                    nodeValuesArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        nodeValuesArray[0] = newItem;
        return 0;
    }
    public int removeItem() {
        int temp = nodeValuesArray[numItems - 1];
        nodeValuesArray[numItems - 1] = null;
        numItems--;
        return temp;
    }
    public Node[] getChildArray() {
        return childArray;
    }

    public void setChildArray(Node[] childArray) {
        this.childArray = childArray;
    }
    public void displayNode() {
        System.out.print("[");
        for (int j = 0; j < numItems; j++) {
            System.out.print(nodeValuesArray[j] + ",");
        }
        System.out.print("]");
    }
}
