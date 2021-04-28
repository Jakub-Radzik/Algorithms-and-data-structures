package Zadanie2;

public class Person {
    private int number;
    private boolean wasMentioned;

    public Person(int number) {
        this.number = number;
        this.wasMentioned = false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isWasMentioned() {
        return wasMentioned;
    }

    @Override
    public String toString() {
        return ""+number;
    }

    public void setWasMentioned(boolean wasMentioned) {
        this.wasMentioned = wasMentioned;
    }
}
