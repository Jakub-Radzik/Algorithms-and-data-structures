package Zad2;

import Interfaces.Iterator1b;

public class NumberIterator implements Iterator1b<Integer> {
    int currentItem;
    int first;
    int last;

    @Override
    public void first() {
        currentItem = first;
    }

    @Override
    public void next() {
        currentItem++;
    }

    @Override
    public boolean isDone() {
        return currentItem>last;
    }

    @Override
    public Integer currentItem() {
        return currentItem;
    }

    public NumberIterator(int begin, int last) {
        this.currentItem = begin;
        this.first = begin;
        this.last = last;
    }
}
