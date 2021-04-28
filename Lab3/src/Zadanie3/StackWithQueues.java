package Zadanie3;

import Interfaces.EmptyQueueException;
import Interfaces.FullQueueException;
import Zadanie1.LimitedQueue;


public class StackWithQueues<T> {
    private LimitedQueue<T> q1 = new LimitedQueue<>();
    private LimitedQueue<T> q2 = new LimitedQueue<>();

    private int curr_size;

    public StackWithQueues() {
        curr_size = 0;
    }

    public void push(T x) throws FullQueueException, EmptyQueueException {

        curr_size++;
        if(q1.isEmpty()){
            q1.enqueue(x);
        }else{
            for (int i = 0; i < curr_size-1; i++) {
                q2.enqueue(q1.dequeue());
            }
            q1.enqueue(x);

            for (int i = 0; i < curr_size-1; i++) {
                q1.enqueue(q2.dequeue());
            }
        }



//        q2.enqueue(x);
//        while (!q1.isEmpty()) {
//            q2.enqueue(q1.first());
//            q1.dequeue();
//        }
//
//        //swap
//        LimitedQueue<T> q = q1;
//        q1 = q2;
//        q2 = q;
    }

    public void pop() throws EmptyQueueException {
        if (q1.isEmpty())
            return;
        q1.dequeue();
        curr_size--;
    }

    public T top() throws EmptyQueueException {
        if (q1.isEmpty()){
            throw new EmptyQueueException();}
        return q1.first();
    }

    public int size() {
        return curr_size;
    }

    @Override
    public String toString() {
        return "q1=" + q1+"\nq2=" + q2+"\nsize="+size();
    }
}

