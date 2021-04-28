package Zadanie4;

public class Test4 {

    public static TwoWayLinkedListWithSentinel<Integer> sentinel = new TwoWayLinkedListWithSentinel<>();
    public static TwoWayLinkedListWithHead<Integer> head = new TwoWayLinkedListWithHead<>();


    //sentinel list after head list
    public static<T> void connect1(){
        Node firstOfSentinel = sentinel.getElement(0);
        head.connectWith(firstOfSentinel);
        System.out.println(head);
    }

    //sentinel list before elem of head list/ idx as parameter
    public static<T> void connect2(int idx){
        Node firstOfSentinel = sentinel.getElement(0);
        Node lastOfSentinel = sentinel.getElement(sentinel.size());
        head.connectWithIn(firstOfSentinel, lastOfSentinel, idx);
        System.out.println(head);
    }

    public static void main(String[] args) {
        generateData();
        System.out.println("S "+sentinel); //nieparzyste
        System.out.println("H "+head); //parzyste
        connect1();
        sentinel = new TwoWayLinkedListWithSentinel<>();
        head = new TwoWayLinkedListWithHead<>();
        generateData();
        connect2(3);
    }

    private static void generateData() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                head.add(i);
            }else{
                sentinel.add(i);
            }
        }
    }
}
