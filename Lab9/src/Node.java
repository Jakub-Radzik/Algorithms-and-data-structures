public class Node {
    private Integer key;
    private Integer value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node() {

    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
