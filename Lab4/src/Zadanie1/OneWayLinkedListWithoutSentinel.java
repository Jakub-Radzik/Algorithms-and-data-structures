package Zadanie1;

public class OneWayLinkedListWithoutSentinel<T> implements LinkedListOneWay<T>{
    Element<T> head = null;

    public OneWayLinkedListWithoutSentinel() {}

    @Override
    public void addEnd(T t) {
        Element<T> newElem = new Element<>(t);
        if(head==null){
            head=newElem;
            newElem.setNextElem(newElem);
        }
        else{
            Element<T> tail = head;
            while(tail.getNextElem() != head){
                tail = tail.getNextElem();
            }
            tail.setNextElem(newElem);
            newElem.setNextElem(head);
        }
    }

    @Override
    public void insert(int pos, T t) {

        Element<T> actElem = head;
        Element<T> newElem = new Element<>(t);

        if(pos == 0){
            newElem.setNextElem(head);

            while (actElem.getNextElem()!=head){
                actElem = actElem.getNextElem();
            }
            head = newElem;
            actElem.setNextElem(newElem);

        }
        else{
            for(int i =0; i<pos-1;i++){
                actElem = actElem.getNextElem();
            }
            newElem.setNextElem(actElem.getNextElem());
            actElem.setNextElem(newElem);
        }


    }

    @Override
    public T get(int pos) {
        Element<T> actElem = head;
        for (int i = 0; i < pos; i++) {
            actElem = actElem.getNextElem();
        }
        return actElem.getData();
    }

    @Override
    public T set(int pos, T t) {
        Element<T> actElem = head;
        for (int i = 0; i < pos; i++) {
            actElem = actElem.getNextElem();
        }
        T valBefore = actElem.getData();
        actElem.setData(t);
        return valBefore;
    }

    @Override
    public boolean contains(T t) {
        Element<T> actElem = head.getNextElem();
        while (actElem!=head){
            if(actElem.getData()==t) return true;
            actElem = actElem.getNextElem();
        }
        return false;
    }

    @Override
    public int size() {
        int pos=1;
        Element<T> actElem=head;

        if(actElem==null) return 0;

        actElem=actElem.getNextElem();
        while(actElem!=head)
        {
            pos++;
            actElem=actElem.getNextElem();
        }
        return pos;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public void deletePos(int pos) {
        Element<T> actElem = head;
        if(pos == 0 || pos%size()==0){
            head = head.getNextElem();
            for (int i = 0; i < size()-1; i++) {
                actElem = actElem.getNextElem();
            }
            actElem.setNextElem(head);
        }else{
            for (int i = 0; i < pos-1; i++) {
                actElem = actElem.getNextElem();
            }
            actElem.setNextElem(actElem.getNextElem().getNextElem());
        }
    }

    @Override
    public boolean delete(T t) {
        Element<T> actElem = head;

        if (actElem.getData() == t) {
            for (int i = 0; i < size() - 1; i++) {
                actElem = actElem.getNextElem();
            }
            actElem.setNextElem(head.getNextElem());
            head = head.getNextElem();
            return true;
        }

        for (int i = 0; i < size() - 1; i++) {
            if (actElem.getNextElem().getData() == t) {
                actElem.setNextElem(actElem.getNextElem().getNextElem());
            }
            actElem = actElem.getNextElem();
        }
        return false;
    }

    @Override
    public T deleteEl(Element e) {
        Element<T> actElem = head.getNextElem();
        T data = null;
        if(head == e){
            data = head.getData();
            head = head.getNextElem();
            for (int i = 0; i < size(); i++) {
                actElem = actElem.getNextElem();
            }
            actElem.setNextElem(head);
        }else{
            actElem = head;
            while(actElem.getNextElem()!=e)
            {
                actElem=actElem.getNextElem();
            }
            data = actElem.getNextElem().getData();

            actElem.setNextElem(actElem.getNextElem().getNextElem());
        }

        return data;
    }

    @Override
    public void wyswietlListe() {
        Element<T> actElem = head;
        if(size()==0) System.out.println("[]");

        else{
            System.out.print('[');
            for (int i = 0; i < size(); i++) {
                System.out.print(actElem.getData()+", ");
                actElem = actElem.getNextElem();
            }
            System.out.print("]\n");
        }

    }
}
