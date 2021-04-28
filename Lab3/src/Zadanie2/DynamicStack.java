package Zadanie2;

import Interfaces.ArrayStack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.StringJoiner;

public class DynamicStack<T> implements ArrayStack<T> {

    private static final int DEFAULT_CAPACITY = 4;
    private T[] stack;
    private int topIndex;

    public DynamicStack() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicStack(int initialSize){
        stack=(T[])(new Object[initialSize]);
        topIndex=0;
    }

    @Override
    public boolean isEmpty() {
        return topIndex==0;
    }

    @Override
    public boolean isFull() {
        return topIndex==stack.length;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        T ret = stack[topIndex-1];
        stack[--topIndex] = null;
        if(topIndex<=(stack.length/4))
        {
            stack = Arrays.copyOf(stack, stack.length/2);
        }
        return ret;
    }

    @Override
    public void push(T elem){
        stack[topIndex++] = elem;
        if(topIndex>=((stack.length*3)/4))
        {
            stack = Arrays.copyOf(stack, stack.length*2);
        }
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top() {
        return stack[topIndex-1];
    }

    @Override
    public String toString() {
        return "Stack= "+Arrays.toString(Arrays.copyOfRange(stack,0,topIndex)).toString();
    }
}
