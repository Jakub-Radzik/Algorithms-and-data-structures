import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int size = 128;
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[size];
//        int[] arr = {0,1,2,3,4,5,6,7};
//        int[] arr = {7,6,5,4,3,2,1,0};
        int[] testArr;

        for (int i = 0; i < size; i++) {
            int n = rand.nextInt(5000);
            arr[i] = n;
        }

        System.out.println("TABLICA TESTOWA:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }

        System.out.println();
        System.out.println("TABLICA PO SORTOWANIU");

        testArr = arr.clone();
        SortMethods.BubbleSort(testArr);
        System.out.println("BUBBLE SORT: [PORÓWNANIA - PRZEPISANIA] - ["+SortMethods.getComparisions()+"-"+SortMethods.getRewrites()+"]");
        SortMethods.setComparisions(0);
        SortMethods.setRewrites(0);


        testArr = arr.clone();
        SortMethods.InsertionSort(testArr);
        System.out.println("INSERTION SORT: [PORÓWNANIA - PRZEPISANIA] - ["+SortMethods.getComparisions()+"-"+SortMethods.getRewrites()+"]");
        SortMethods.setComparisions(0);
        SortMethods.setRewrites(0);

        testArr = arr.clone();
        SortMethods.SelectionSort(testArr);
        System.out.println("SELECTION SORT: [PORÓWNANIA - PRZEPISANIA] - ["+SortMethods.getComparisions()+"-"+SortMethods.getRewrites()+"]");
        SortMethods.setComparisions(0);
        SortMethods.setRewrites(0);

        SortMethods.SelectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(testArr[i]+", ");
        }

    }
}
