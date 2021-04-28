package Interfaces;

public interface ArrayStack<T> {
    boolean isEmpty();
    boolean isFull();
    T pop();
    void push(T elem) throws FullStackException;
    int size();
    T top();
}
