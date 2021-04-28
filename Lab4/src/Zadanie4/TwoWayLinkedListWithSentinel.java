package Zadanie4;

import java.util.AbstractList;
public class TwoWayLinkedListWithSentinel<E> extends AbstractList<E> {
    Node<E> sentinel = null;

    public TwoWayLinkedListWithSentinel() {
        sentinel = new Node<>(null);
//        sentinel.setPrev(sentinel);
//        sentinel.setNext(sentinel);
    }

    public Node getElement(int index){
        Node elem = sentinel.getNext();
        int counter = 0;
        while(elem!=sentinel && counter<index){
            counter++;
            elem=elem.getNext();}
        if(elem==sentinel)
            throw new IndexOutOfBoundsException();
        return elem;
    }

    public Node getElement(E value){
        Node elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel && !value.equals(elem.getValue())){
            counter++;
            elem=elem.getNext();
        }
        if(elem==sentinel)
            return null;
        return elem;
    }

    public boolean isEmpty(){
        return sentinel.getNext()==sentinel;
    }

    public void clear(){
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    public boolean contains(Object value){
        return indexOf(value) != -1;
    }

    @Override
    public E get(int index) {
        Node elem = getElement(index);
        return (E) elem.getValue();
    }

    public E set(int index, E value) {
        Node elem = getElement(index);
        E retValue= (E) elem.getValue();
        elem.setValue(value);
        return retValue;
    }

    public boolean add(E value) {
        Node newElem=new Node(value);

        Node elem = sentinel;
        if(sentinel.getNext()==null){
            sentinel.setNext(newElem);
            newElem.setPrev(sentinel);
            return true;
        }

        while(elem.getNext()!=null){
            elem = elem.getNext();
        }

        elem.setNext(newElem);
        newElem.setPrev(elem);
        return true;
    }


//    public void add(int index, E value) {
//        Node<E> newElem=new Node<>(value);
//        if(index==0) {sentinel.setValue(value);}
//        else{
//            Node elem=getElement(index-1);
//            elem.insertAfter(newElem);
//        }
//    }

    public int indexOf(Object value) {
        Node elem=sentinel.getNext();
        int counter=0;
        while(elem!=sentinel && !elem.getValue().equals(value)){
            counter++;
            elem=elem.getNext();}
        if(elem==sentinel)
            return -1;
        return counter;
    }

    public E remove(int index) {
        Node elem=getElement(index);
        elem.remove();
        return (E) elem.getValue();
    }

    public boolean remove(Object value) {
        Node elem= getElement((E) value);
        if(elem==null) return false;
        elem.remove();
        return true;
    }

    public int size() {
        Node elem=sentinel.getNext();
        int counter=0;
        while(elem.getNext()!=null){
            counter++;
            elem=elem.getNext();}
        return counter;
    }

    @Override
    public String toString() {
        Node elem = sentinel.getNext();
        String txt = "[";
        while (elem!=null){
            txt+=elem.getValue()+", ";
            elem = elem.getNext();
        }
        txt+="]";
        return txt;
    }
}