package Zadanie3;

public class StackTest {
    public static void main(String[] args) {
        StackList<Integer> stack = new StackList<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            stack.display();
        }

        for (int i = 0; i < 3; i++) {
            stack.pop();
            stack.display();
        }

    }
}
