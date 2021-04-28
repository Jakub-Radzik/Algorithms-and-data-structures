package Zadanie1;

public interface LinkedListOneWay<E> {
    void addEnd(E e);
    void insert(int pos, E e);
    E get( int pos );
    E set(int pos, E e);
    boolean contains( E e );
    int size();
    void clear();
    void deletePos( int pos);
    boolean delete( E e );
    E deleteEl(Element e);
    void wyswietlListe();
}
