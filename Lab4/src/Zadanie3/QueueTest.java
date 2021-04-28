package Zadanie3;

import Wyjatki.EmptyQueueException;

public class QueueTest {
    public static void main(String[] args) throws EmptyQueueException {
        Queue<Integer> kolejka = new Queue<>();
        kolejka.enqueue(1);
        kolejka.enqueue(2);
        kolejka.enqueue(3);
        kolejka.display();
        kolejka.dequeue();
        kolejka.display();
        System.out.println(kolejka.first());
    }
}
