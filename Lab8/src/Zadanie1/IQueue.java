package Zadanie1;

public interface IQueue{
    void enqueue(int value) throws Exception;
    void clear();
    int size();
    boolean isEmpty();
    boolean isFull();
    int first() throws Exception;
    int dequeue() throws Exception;
    int remove(int idx) throws Exception;
    void changePriority(int idx, int newPriority) throws Exception;
}
