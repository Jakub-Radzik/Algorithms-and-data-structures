package Tree234;

public class main {
    public static void main(String[] args) {
        Tree234 t234 = new Tree234();
        System.out.println("INSERTING: ");
        for (int i = 10; i < 110; i += 10) {
            t234.insert(i);
            System.out.print(i + ", ");
        }
        for (int i = 145; i > 0; i -= 10) {
            t234.insert(i);
            System.out.print(i + ", ");
        }
        System.out.println("\nDisplay levels: ");
        t234.displayLevels();
        System.out.println("Node with key: 100:");
        t234.find(100).displayNode();
        System.out.println("\nminimum: " + t234.minimum());
        System.out.println("maximum: " + t234.maximum());
        t234.inorder();
        System.out.println("For key 20: Successor: " + t234.successor(20) + " Ancestor: " + t234.ancestor(20));
        System.out.println("For key 5: Successor: " + t234.successor(5) + " Ancestor: " + t234.ancestor(5));
        System.out.println("For key 145: Successor: " + t234.successor(145) + " Ancestor: " + t234.ancestor(145));

    }

}
