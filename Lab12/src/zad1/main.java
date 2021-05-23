package zad1;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        int n = 10;

        System.out.println("Zbiory rozłączne z tablic");
        ArrayDisjoint set1 = new ArrayDisjointSetsCompression(n);
        ArrayDisjoint set2 = new ArrayDisjointSetsNoCompression(n);

        set1.union(0,1); // [0,1]
        set2.union(0,1);
        set1.union(1,2); // [0,1,2]
        set2.union(1,2);
        set1.union(2,3); // [0,1,2,3]
        set2.union(2,3);
        set1.union(4,5);
        set1.union(5,6);
        set1.union(6,7);
        set2.union(4,5);
        set2.union(5,6);
        set2.union(6,7);// [0,1,2,3], [4,5,6,7], [8], [9]

        System.out.println("Reprezentant [Czas szukania w nano sekundach]");
        System.out.println("Kompresja ścieżek dokłada kodu więc wtedy czas jest dłuższy");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Szukany element | Reprezentant w set1 | Reprezentant w set2");
        System.out.println("                |  Kompresja ścieżek  |  Brak kompresji    ");
        for (int i = 0; i < 10; i++) {
            long before1 = System.nanoTime();
            int s1 = set1.find(i);
            long after1 = System.nanoTime();
            long before2 = System.nanoTime();
            int s2 = set2.find(i);
            long after2 = System.nanoTime();


            System.out.println("       "+i+"                  "+set1.find(i)+" ["+(after1-before1)+"]          "+set2.find(i)+" ["+(after2-before2)+"]");
        }

        System.out.println("Sets on forest");

        ForestDisjointTreesSets forest = new ForestDisjointTreesSets(10);
        for (int i = 0; i < 10; i++) {
            forest.makeSet(i);
        }

        for (int i = 0; i < 10; i+=2) {
            forest.union(i, i+1);
        }

        displaySets(forest);
        System.out.println("1<->2");
        forest.union(1,2);
        displaySets(forest);
        System.out.println("2<->5");
        forest.union(2,5);
        displaySets(forest);
        System.out.println("9<->6");
        forest.union(9,6);
        displaySets(forest);
    }

    public static void displaySets(ForestDisjointTreesSets forest){
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            sets.add(new ArrayList<>());
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(forest.findSet(j)==i){
                    sets.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < sets.size(); i++) {
            if(sets.get(i).size()!=0){
                System.out.print("[");
                sets.get(i).stream().forEach(e -> System.out.print(e+ ", "));
                System.out.print("]");
            }
        }
        System.out.println();
    }

}
