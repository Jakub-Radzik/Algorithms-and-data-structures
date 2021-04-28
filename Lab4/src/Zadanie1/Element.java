package Zadanie1;

import java.util.Objects;

public class Element<T> {
    private T data;
    private Element<T> nextElem;

    public Element(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Element<T> getNextElem() {
        return nextElem;
    }

    public void setNextElem(Element<T> nextElem) {
        this.nextElem = nextElem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element<?> element = (Element<?>) o;
        return Objects.equals(data, element.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
