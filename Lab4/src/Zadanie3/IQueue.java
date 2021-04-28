package Zadanie3;

import Wyjatki.EmptyQueueException;

public interface IQueue<T> {
    boolean isEmpty();
    boolean isFull();
    T dequeue() throws EmptyQueueException;
    void enqueue(T elem);
    T first() throws EmptyQueueException;
}
