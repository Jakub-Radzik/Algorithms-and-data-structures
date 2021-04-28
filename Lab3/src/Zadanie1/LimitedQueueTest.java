package Zadanie1;

import Interfaces.EmptyQueueException;
import Interfaces.FullQueueException;

public class LimitedQueueTest {
    public static void main(String[] args) throws FullQueueException, EmptyQueueException {
        LimitedQueue<Integer> lq = new LimitedQueue<>();
        System.out.println(lq);
        for (int i = 0; i < 17; i++) {
            lq.enqueue(i);
            System.out.println(lq);
        }

        for (int i = 0; i < 5; i++) {
            lq.dequeue();
            System.out.println(lq.first());
            System.out.println(lq);
        }


    }
}
