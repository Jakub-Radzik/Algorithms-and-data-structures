package Zadanie4;

import java.util.AbstractList;

public class TwoWayLinkedListWithHead<T> extends AbstractList<T> {

    private Node<T> head = new Node<>(null);

    public TwoWayLinkedListWithHead() {
    }

    public Node getElement(int index){
        Node actElem=head.getNext();
        while(index>0 && actElem!=null){
            index--;
            actElem=actElem.getNext();
        }
        return actElem;
    }

    public void connectWith(Node elem){
        Node last = getElement(size()-1);
        last.setNext(elem);
        elem.setPrev(last);
    }

    public void connectWithIn(Node left, Node right, int idx){
        Node rightConnection = getElement(idx);
        Node leftConnection = getElement(idx-1);

        leftConnection.setNext(left);
        left.setPrev(leftConnection);

        rightConnection.setPrev(right);
        right.setNext(rightConnection);
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void clear(){
        head = new Node<>(null);
    }

    @Override
    public int size() {
        Node elem = head.getNext();
        if(elem == null) return 0;
        int size = 1;
        while(elem.getNext()!=null){
            size++;
            elem = elem.getNext();
        }

        return size;
    }

    @Override
    public boolean add(T t) {
        Node<T> newElem=new Node<>(t);

        if(head.getNext()==null){
            head.setNext(newElem);
            newElem.setNext(null);
            return true;
        }

        Node tail=head;
        while(tail.getNext()!=null)
            tail=tail.getNext();
        tail.setNext(newElem);
        newElem.setPrev(tail);
        newElem.setNext(null);
        return true;
    }

    public void add(int index, T data) {
        Node<T> newElem= new Node<>(data);

        if(index==0) {
            newElem.setNext(head.getNext());
            newElem.setPrev(head);
            head.setNext(newElem);
            newElem.getNext().setPrev(newElem);
        }else{
            Node actElem=getElement(index-1);
            newElem.setNext(actElem.getNext());
            newElem.setPrev(actElem);
            actElem.getNext().setPrev(newElem);
            actElem.setNext(newElem);
        }
    }


    @Override
    public int indexOf(Object data) {
        int pos=0;
        Node actElem=head;
        while(actElem!=null)
        {
            if(actElem.getValue().equals(data))
                return pos;
            pos++;
            actElem=actElem.getNext();
        }
        return -1;}

    @Override
    public boolean contains(Object data) {
        return indexOf(data)>=0;}

    @Override
    public T get(int index) {
        Node actElem=getElement(index);
        return actElem==null?null: (T) actElem.getValue();
    }

    public T set(int index, T data) {
        Node actElem=getElement(index);
        if(actElem==null)
            return null;
        T elemData= (T) actElem.getValue();
        actElem.setValue(data);
        return elemData;
    }

    @Override
    public T remove(int index) {
        if(head==null)
            return null;
        if(index==0){
            T retValue=head.getValue();
            head=head.getNext();
            return retValue;
        }
        Node actElem=getElement(index-1);
        if(actElem==null || actElem.getNext()==null)
            return null;
        T retValue= (T) actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());
        return retValue;
    }

    @Override
    public boolean remove(Object value) {
        if(head==null)
            return false;
        if(head.getValue().equals(value)){
            head=head.getNext();
            return true;}
        Node actElem=head;
        while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(value))
            actElem=actElem.getNext();
        if(actElem.getNext()==null)
            return false;
        actElem.setNext(actElem.getNext().getNext());
        return true;
    }


    @Override
    public String toString() {
        Node el = head.getNext();
        String txt = "[";
        while(el!=null){
            txt += el.getValue()+", ";
            el = el.getNext();
        }
        txt += "]";
        return txt;
    }
}
