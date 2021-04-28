import java.util.Random;

public class Main {


    public static void displayTab(int[] tab){
        System.out.print('[');
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i]+", ");
        }
        System.out.println(']');
    }

    private static final int size = 100000;

    public static void main(String[] args) {
        long start = 0;
        long stop = 0;
        Random rand = new Random();
        int[] tab = new int[size];
//        int[] tab = {8,7,6,5,4,3,2,1};

        for (int i = 0; i < size; i++) {
            int n = rand.nextInt(5000);
            tab[i] = n;
        }

        int[] testArr =  tab.clone();
//        System.out.println("TABLICA PRZED SORTOWANIEM");
//        displayTab(testArr);

        System.out.println("długosc: "+size);
        //QUICK SORT===========================================================================================
        SortMethods1.setRewrites(0);
        SortMethods1.setComparisons(0);
        System.out.println("QUICK SORT");

        start=System.nanoTime();
        SortMethods1.quickSort(testArr,0,testArr.length-1);
        stop=System.nanoTime();

        System.out.println("Czas wykonania:"+(stop-start));
        System.out.println("Porównań / Przepisań - "+SortMethods1.getComparisons()+" / "+SortMethods1.getRewrites());

        //MERGE SORT===========================================================================================

        SortMethods1.setRewrites(0);
        SortMethods1.setComparisons(0);
        System.out.println("MERGE SORT");

        start=System.nanoTime();
        SortMethods1.mergeSort(testArr,testArr.length);
        stop=System.nanoTime();

        System.out.println("Czas wykonania:"+(stop-start));
        System.out.println("Porównań / Przepisań - "+SortMethods1.getComparisons()+" / "+SortMethods1.getRewrites());

        //HEAP SORT===========================================================================================
        SortMethods1.setRewrites(0);
        SortMethods1.setComparisons(0);
        testArr = tab.clone();
        System.out.println("HEAP SORT");

        start=System.nanoTime();
        SortMethods1.heapSort(testArr);
        stop=System.nanoTime();

        System.out.println("Czas wykonania:"+(stop-start));

    }
}