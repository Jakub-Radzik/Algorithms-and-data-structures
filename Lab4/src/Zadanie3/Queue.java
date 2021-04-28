package Zadanie3;

import Wyjatki.EmptyQueueException;
import Zadanie1.OneWayLinkedListWithoutSentinel;

import java.util.StringJoiner;

public class Queue<T> implements IQueue<T> {

    OneWayLinkedListWithoutSentinel<T> list = new OneWayLinkedListWithoutSentinel<>();

    @Override
    public boolean isEmpty() {
        return list.size()==0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        T elem = list.get(list.size()-1);
        list.deletePos(list.size()-1);
        return elem;
    }

    @Override
    public void enqueue(T elem) {
        if(isEmpty()) {list.addEnd(elem);}
        else {list.insert(0,elem);}
    }

    public void display(){
        list.wyswietlListe();
    }

    @Override
    public T first() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();
        return list.get(list.size()-1);
    }
}
