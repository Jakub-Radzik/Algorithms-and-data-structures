package Zadanie3;


public class StackWithQueuesTest {
    public static void main(String[] args) {
        StackWithQueues<Integer> s = new StackWithQueues<>();

        try{
            s.push(1);
            System.out.println(s);
            s.push(2);
            System.out.println(s);
            s.push(3);
            System.out.println(s);
            System.out.println("Rozmiar stosu: " + s.size());
            System.out.println(s.top());
            s.pop();
            System.out.println(s.top());
            s.pop();
            System.out.println(s.top());
            System.out.println("current size: " + s.size());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
