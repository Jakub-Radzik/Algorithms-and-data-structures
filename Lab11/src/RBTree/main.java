package RBTree;

public class main {
    public static void main(String[] args) {
        BlackRedTree brt = new BlackRedTree();

        for (int i = 10; i < 120; i+=10) {
            brt.insert(i);
        }

        System.out.println("Display levels: ");
        brt.displayLevels();
        System.out.println("Inorder");
        brt.displayInOrder();
        System.out.println("\nLooking for node with key 40:");
        System.out.println(brt.find(40));
        System.out.println("Parameters:");
        brt.showParameters();
    }
}
