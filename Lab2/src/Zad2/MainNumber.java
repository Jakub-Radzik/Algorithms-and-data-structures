package Zad2;

import Interfaces.Predicate;

public class MainNumber{

    public static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberIterator itr = new NumberIterator(1,100);
        Predicate<Integer> predicate = MainNumber::isPrime;
        NumberFilterIterator nItr = new NumberFilterIterator(itr, predicate);

        while (!itr.isDone()){
            nItr.findNextValid();
            System.out.println(itr.currentItem);
        }


    }
}
