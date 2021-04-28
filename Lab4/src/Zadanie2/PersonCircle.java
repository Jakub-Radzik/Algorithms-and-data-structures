package Zadanie2;

import Zadanie1.OneWayLinkedListWithoutSentinel;

public class PersonCircle {
    public static OneWayLinkedListWithoutSentinel<Person> persons = new OneWayLinkedListWithoutSentinel<>();

    public static void appendPersons(int amount){
        for (int i = 1; i <= amount; i++) {
            persons.addEnd(new Person(i));
        }
    }

    public static void deletePersonWithStep(int step){
        int personsIter = 0;
        int soutCount = 0;
        for (int i = 0; soutCount<persons.size()-1; i++) {

            if(!persons.get(i).isWasMentioned()){
                personsIter++;

                if((personsIter)%step==0){
                    persons.get(i).setWasMentioned(true);
                    System.out.print(persons.get(i).getNumber()+",");
                    soutCount++;
                }
            }


        }
    }

    public static void circle(int n, int k){
        appendPersons(n);
        deletePersonWithStep(k);
    }

    public static void main(String[] args) {
        circle(10,2);
    }

}
