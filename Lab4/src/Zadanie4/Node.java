package Zadanie4;

public class Node<T> {
    private T value;
    private Node next;
    private Node prev;

    public T getValue() { return value; }
    public void setValue(T value) { this.value = value; }
    public Node getNext() {return next;}
    public void setNext(Node next) {this.next = next;}
    public Node getPrev() {return prev;}
    public void setPrev(Node prev) {this.prev = prev;}

    Node(T data){this.value=data;}

    public void insertAfter(Node elem){
        elem.setNext(this.getNext());
        elem.setPrev(this);
        this.getNext().setPrev(elem);
        this.setNext(elem);
    }


    public void remove(){
        this.getNext().setPrev(this.getPrev());
        this.getPrev().setNext(this.getNext());
    }
}
