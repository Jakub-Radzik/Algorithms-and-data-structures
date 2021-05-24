import BST.BST;
import RBTree.BlackRedTree;
import TreeTwoThreeFour.Tree234;

import java.util.ArrayList;

public class main2 {

    public static int randomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {

        for (int test = 100; test < 1000000; test*=10) {

            BST bst = new BST();
            BlackRedTree rb = new BlackRedTree();
            Tree234 t234 = new Tree234();

            int min = 0;
            int max = test;
            int treeElems = test/2;

            for (int i = 0; i < treeElems; i++) {
                int k = randomInt(min,max);
                bst.insert(k);
                rb.insert(k);
                t234.insert(k);
            }

            int tries = test/4;

            ArrayList<Integer> goodTriesBST = new ArrayList<>();
            ArrayList<Integer> goodTriesRB = new ArrayList<>();
            ArrayList<Integer> goodTries234 = new ArrayList<>();

            ArrayList<Integer> badTriesBST = new ArrayList<>();
            ArrayList<Integer> badTriesRB = new ArrayList<>();
            ArrayList<Integer> badTries234 = new ArrayList<>();

            for (int i = 0; i < tries; i++) {
                int searchFor = randomInt(min,max);

                bst.findKey(searchFor);
                rb.find(searchFor);
                t234.find(searchFor);

                if(bst.findKey(searchFor) == null){
                    badTriesBST.add(BST.getFindTry());
                }else{
                    goodTriesBST.add(BST.getFindTry());
                }

                if(rb.find(searchFor) == null){
                    badTriesRB.add(BlackRedTree.getFindTry());
                }else{
                    goodTriesRB.add(BlackRedTree.getFindTry());
                }

                if(t234.find(searchFor) == null){
                    badTries234.add(Tree234.getFindTry());
                }else{
                    goodTries234.add(Tree234.getFindTry());
                }

                BST.setFindTry(0);
                BlackRedTree.setFindTry(0);
                Tree234.setFindTry(0);

            }

            System.out.println("======================================================================");
            System.out.println("In trees are numbers in range: [ "+min+" : "+max+" ]");
            System.out.println("Number of tries: "+tries);

            System.out.print("AVG Comparisons for BST Good search: ");
            goodTriesBST.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .stream()
                    .map(Math::round)
                    .findFirst()
                    .ifPresent(System.out::println);

            System.out.print("AVG Comparisons for BST Bad search: ");
            badTriesBST.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .stream()
                    .map(Math::round)
                    .findFirst()
                    .ifPresent(System.out::println);


            System.out.print("AVG Comparisons for RB Good search: ");
            goodTriesRB.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .stream()
                    .map(Math::round)
                    .findFirst()
                    .ifPresent(System.out::println);

            System.out.print("AVG Comparisons for RB Bad search: ");
            badTriesRB.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .stream()
                    .map(Math::round)
                    .findFirst()
                    .ifPresent(System.out::println);

            System.out.print("AVG Comparisons for 234 Good search: ");
            goodTries234.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .stream()
                    .map(Math::round)
                    .findFirst()
                    .ifPresent(System.out::println);

            System.out.print("AVG Comparisons for 234 Bad search: ");
            badTries234.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .stream()
                    .map(Math::round)
                    .findFirst()
                    .ifPresent(System.out::println);

        }

    }
}
