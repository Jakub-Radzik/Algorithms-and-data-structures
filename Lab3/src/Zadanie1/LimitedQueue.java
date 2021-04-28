package Zadanie1;

import Interfaces.EmptyQueueException;
import Interfaces.FullQueueException;
import Interfaces.IQueue;

import java.util.Arrays;
import java.util.StringJoiner;

public class LimitedQueue<T> implements IQueue<T> {

    private static final int DEFAULT_CAPACITY = 16;
    T[] queue;
    int endIndex;

    public LimitedQueue(int size) {
        queue=(T[])new Object[size+1];
        endIndex = queue.length;
    }

    public LimitedQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return queue[queue.length-1]==null;
    }

    @Override
    public boolean isFull() {
        return queue[0]!=null;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
            T retValue=queue[queue.length-1];
            for (int i = queue.length-1; i > 0; i--) {
                queue[i] = queue[i-1];
            }
            queue[0] = null;
            endIndex++;

        return retValue;
    }

    @Override
    public void enqueue(T elem) throws FullQueueException {
        if(isFull())
            throw new FullQueueException();
        queue[--endIndex] = elem;
    }

    @Override
    public int size() {
        return (endIndex + queue.length) % queue.length;
    }

    @Override
    public T first() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        return queue[queue.length-1];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(queue,endIndex,queue.length));
    }
}
