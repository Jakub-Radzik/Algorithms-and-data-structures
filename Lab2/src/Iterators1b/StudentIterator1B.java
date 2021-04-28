package Iterators1b;

import Interfaces.Iterator1b;
import Model.Student;

public class StudentIterator1B implements Iterator1b<Student> {
    private Student[] tab;
    private int position = -1;
    int first;
    int last;
    private Student currentItem= null;

    @Override
    public void first() {
        position = 0;
        currentItem = tab[position];
    }
    @Override
    public void next() {
        position++;
        if(!isDone()){
            currentItem = tab[position];
        }
    }

    @Override
    public boolean isDone() {
        return position<first || position>=tab.length;
    }

    @Override
    public Student currentItem() {
        return currentItem;
    }

    public StudentIterator1B(Student[] tab) {
        this.tab = tab;
        first();
        last = tab.length-1;
    }
}
