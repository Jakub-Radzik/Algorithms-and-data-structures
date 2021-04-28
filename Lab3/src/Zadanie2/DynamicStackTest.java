package Zadanie2;

public class DynamicStackTest {
    public static void main(String[] args) {
        DynamicStack<Integer> ds = new DynamicStack<>();

        for (int i = 0; i < 30; i++) {
            ds.push(i);
            System.out.println(ds);
        }
        for (int i = 0; i < 5; i++) {
            ds.pop();
            System.out.println(ds);
        }

    }
}
