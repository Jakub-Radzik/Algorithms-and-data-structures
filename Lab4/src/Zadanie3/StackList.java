package Zadanie3;

import Zadanie1.OneWayLinkedListWithoutSentinel;

import java.util.Stack;

public class StackList<T> extends Stack<T> {

    OneWayLinkedListWithoutSentinel<T> list = new OneWayLinkedListWithoutSentinel<>();

    @Override
    public T push(T item) {
        list.addEnd(item);
        return item;
    }

    @Override
    public T pop() {
        T elem = list.get(list.size()-1);
        list.deletePos(list.size()-1);
        return elem;
    }

    @Override
    public boolean empty() {
        return list.size()==0;
    }

    public void display(){
        list.wyswietlListe();
    }

}
