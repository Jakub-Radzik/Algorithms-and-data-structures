package Iterators1a;

import Model.Student;

import java.util.Iterator;
import java.util.function.Predicate;

public class StudentsIterator implements Iterator<Student> {

    private Student[] tab;
    private int first;
    private int last;
    private int current = 0;

    public StudentsIterator(Student[] tab) {
        super();
        this.tab = tab;
        this.first = 0;
        this.last = tab.length-1;
    }

    public StudentsIterator(Student[] tab, Predicate<Student> predicate) {
        super();
        this.tab = tab;
        this.first = 0;
        this.last = tab.length-1;
    }

    @Override
    public boolean hasNext() {
        return tab.length>current;
    }

    @Override
    public Student next() {
        return tab[current++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove an element of an array.");
    }
}
