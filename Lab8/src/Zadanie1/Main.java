package Zadanie1;


import java.util.Random;

public class Main {

    public static void print(int[] tab){
        String txt = "[";
        for (int i = 0; i < tab.length; i++) {
            txt+=tab[i]+", ";
        }
        txt+="]";
        System.out.println(txt);
    }

    public static void main(String[] args) throws Exception {
        //ARRAY GENERATION
        int[] tab = new int[16];
        Random rand = new Random();
        int n;

        for (int i = 0; i < tab.length; i++) {
            n = rand.nextInt(500);
            tab[i] = n;
        }

        //CREATE HEAP PRIORITY QUEUE
        HeapPriorityQueue heap = new HeapPriorityQueue(tab);
        System.out.println("TABLICA PRZED KOPCOWANIEM: ");
        print(tab);
        System.out.println("KOPIEC: \n");
        heap.printTree();

        heap.dequeue();
        System.out.println("\nKOPIEC PO OPERACJI DEQUEUE:");
        heap.print();
        heap.dequeue();
        System.out.println("KOPIEC PO OPERACJI DEQUEUE:");
        heap.print();

        int v1 = 99999999;
        heap.enqueue(v1);
        System.out.println("KOPIEC PO OPERACJI ENQUEUE WARTOSCI "+v1+":");
        heap.print();

        System.out.println("ROZMIAR KOPCA: "+ heap.size());
        int v2 = 222;
        heap.enqueue(v2);
        System.out.println("KOPIEC PO OPERACJI ENQUEUE WARTOSCI "+v2+":");
        heap.print();

        System.out.println("ROZMIAR KOPCA: "+ heap.size());

        System.out.println("PIERWSZY ELEMENT KOPCA: "+ heap.first());

        int idx = 3;
        int priority = 888888888;
        System.out.println("KOPIEC PO ZMIANIE PRIORYTETU INDEKSU "+idx+" NA WARTOSC "+priority+":");
        heap.changePriority(idx, priority);
        heap.print();

        idx = 9;
        priority = 9;
        System.out.println("KOPIEC PO ZMIANIE PRIORYTETU INDEKSU "+idx+" NA WARTOSC "+priority+":");
        heap.changePriority(idx, priority);
        heap.print();

        idx = 2;
        System.out.println("KOPIEC PO USUNIECIU ELEMENTU O INDEKSIE"+idx+":");
        heap.remove(idx);
        heap.print();

        heap.clear();
        System.out.println("KOPIEC PO OPERACJI CLEAR: ");
        heap.print();

    }
}
