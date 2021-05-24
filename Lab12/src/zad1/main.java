package zad1;

import zad1.onArrays.ArrayDisjoint;
import zad1.onArrays.ArrayDisjointSetsCompression;
import zad1.onArrays.ArrayDisjointSetsNoCompression;
import zad1.onTrees.ForestDisjointSetCompression;
import zad1.onTrees.ForestDisjointSetStabilization;
import zad1.onTrees.ForestDisjontSet;


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
        System.out.println("SET1");
        set1.displaySets();
        System.out.println("SET2");
        set2.displaySets();

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

        ForestDisjontSet f1 = new ForestDisjointSetCompression(31);
        ForestDisjontSet f2 = new ForestDisjointSetStabilization(31);

        for (int i = 0; i < 30; i+=2) {
            f1.union(i,i+1);
            f2.union(i,i+1);
        }

        System.out.println("KOMPRESOWANY SET");
        f1.displaySets();
        System.out.println("STABILIZOWANA WYSOKOSC SET");
        f2.displaySets();
    }

}
