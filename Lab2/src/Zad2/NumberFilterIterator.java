package Zad2;

import Interfaces.Iterator1b;
import Interfaces.Predicate;

public class NumberFilterIterator{
        private Iterator1b<Integer> iter;
        private Predicate<Integer> predicate;

        public void findNextValid(){
            while(!iter.isDone()){
                iter.next();
                if(predicate.accept(iter.currentItem())){
                    return;
                }
            }
        }

        public NumberFilterIterator(Iterator1b<Integer> iter, Predicate<Integer> predicate) {
            this.iter = iter;
            this.predicate = predicate;
        }
}
