package Zadanie1;

public class OneWayTest {
    public static void main(String[] args) {
        OneWayLinkedListWithoutSentinel<Integer> list = new OneWayLinkedListWithoutSentinel<>();
        list.addEnd(0);
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addEnd(5);
        list.addEnd(6);
        System.out.println(list.get(3));
        list.wyswietlListe();
        System.out.println();
        System.out.println("AFTER");
        list.deletePos(0);
        list.deletePos(1);
        list.wyswietlListe();
        System.out.println("\nSET NA POZYCJI");
        list.set(3,10);
        list.set(0,10);
        list.wyswietlListe();
        System.out.println("\nINSERT NA POZYCJI");
        list.insert(0,20);
        list.insert(1,21);
        list.insert(5,21);
        list.wyswietlListe();
        System.out.println();
        System.out.println(list.contains(21));
        System.out.println(list.contains(6));
        System.out.println(list.contains(22222));
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());
        list.addEnd(0);
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addEnd(5);
        list.addEnd(6);
        list.wyswietlListe();
        list.delete(0);
        System.out.println();
        list.wyswietlListe();
        list.delete(1);
        System.out.println();
        list.wyswietlListe();

    }
}
