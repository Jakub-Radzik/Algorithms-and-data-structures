package Iterators1b;

import Interfaces.Iterator1b;
import Interfaces.Predicate;

public class StudentInteratorFilter1B<T> implements Iterator1b{
    private Iterator1b<T> iter;
    private Predicate<T> predicate;

    @Override
    public void first() {
        iter.first();
    }

    @Override
    public void next() {
        iter.next();
    }

    @Override
    public boolean isDone() {
        return iter.isDone();
    }

    @Override
    public T currentItem() {
        return iter.currentItem();
    }

    public void findNextValid(){
        while(!isDone()){
            next();
            if(predicate.accept(currentItem())){
                return;
            }
        }
    }

    public StudentInteratorFilter1B(Iterator1b<T> iter, Predicate<T> predicate) {
        this.iter = iter;
        this.predicate = predicate;
        iter.first();
    }
}
