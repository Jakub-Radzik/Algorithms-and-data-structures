package Iterators1a;

import Interfaces.Predicate;

import java.util.Iterator;

public class FilterStudentIterator<T> implements Iterator<T> {
    private Iterator<T> iterator;
    private Predicate<T> predicate;
    private T elemNext = null;
    private boolean bHasNext = true;

    public FilterStudentIterator(Iterator<T> iterator, Predicate<T> predicate) {
        super();
        this.iterator = iterator;
        this.predicate = predicate;
        findNextValid();
    }
    private void findNextValid() {
        while (iterator.hasNext()) {
            elemNext = iterator.next();
            if (predicate.accept(elemNext)) {
                return;
            }
        }
        bHasNext=false;
        elemNext=null;
    }

    @Override
    public boolean hasNext() {
        return bHasNext;
    }

    @Override
    public T next() {
        T nextValue = elemNext;
        findNextValid();
        return nextValue;
    }

}
