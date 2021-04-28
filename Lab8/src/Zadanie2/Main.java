package Zadanie2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    //METHODS FOR ARRAYS:
    public static void fillArrayWithRandom(int[] tab){
        Random rand = new Random();
        int n;
        for (int i = 0; i < tab.length; i++) {
            n = rand.nextInt(100);
            tab[i] = n;
        }
    }
    public static int linearSearch(int[] tab, int searchValue){
        for (int i = 0; i < tab.length; i++) {
            comparations++;
            if(tab[i]==searchValue){
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int arr[],int first, int last, int key){
        if (last>=first){
            int mid = first + (last - first)/2;
            comparations++;
            if (arr[mid] == key){
                return mid;
            }
            comparations++;
            if (arr[mid] > key){
                return binarySearch(arr, first, mid-1, key);
            }else{
                return binarySearch(arr, mid+1, last, key);
            }
        }
        return -1;
    }

    //HEAP SORT
    public static void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }
    private static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }


    public static void print(int[] tab){
        System.out.print("[");
        Arrays.stream(tab).forEach(elem -> {
            System.out.print(elem+", ");
        });
        System.out.println("]");
    }


    private static int comparations = 0;
    public static int getComparations() {
        return comparations;
    }

    public static void setComparations(int comparations) {
        Main.comparations = comparations;
    }


    public static void main(String[] args) {

        int[] tab = new int[32];
        int[] tabSorted;

        fillArrayWithRandom(tab);

        System.out.println("TABLICA PO WYPELNIENIU: ");
        print(tab);
        tabSorted = tab.clone();
        heapSort(tabSorted);
        System.out.println("TABLICA POSORTOWANA:");
        print(tabSorted);

        Random rand = new Random();
        ArrayList<Integer> LINEAR_COMPARATIONS_OK = new ArrayList<>();
        ArrayList<Integer> BINARY_COMPARATIONS_OK = new ArrayList<>();

        ArrayList<Integer> LINEAR_COMPARATIONS_WRONG = new ArrayList<>();
        ArrayList<Integer> BINARY_COMPARATIONS_WRONG = new ArrayList<>();


        int wrong_search_linear = 0;
        int ok_search_linear = 0;
        int wrong_search_binary = 0;
        int ok_search_binary = 0;

        int n;
        for (int i = 0; i < 200; i++) {
            n = rand.nextInt(100);

            if(linearSearch(tab,n)==-1){
                LINEAR_COMPARATIONS_WRONG.add(getComparations());
                wrong_search_linear++;
            }else{
                LINEAR_COMPARATIONS_OK.add(getComparations());
                ok_search_linear++;
            }
            setComparations(0);

            if(binarySearch(tabSorted,0,tabSorted.length-1,n)==-1){
                BINARY_COMPARATIONS_WRONG.add(getComparations());
                wrong_search_binary++;
            }else{
                BINARY_COMPARATIONS_OK.add(getComparations());
                ok_search_binary++;
            }
            setComparations(0);

        }
        System.out.println("WYSZUKIWANIE LINIOWE W TABLICY NIEPOSORTOWANEJ: ");
        System.out.println("Liczba wyszukiwań trafionych: "+ok_search_linear);
        System.out.println("Liczba wyszukiwań chybionych: "+wrong_search_linear);
        System.out.println("Srednia liczba porównan dla wyszukiwan trafionych: "+LINEAR_COMPARATIONS_OK.stream().mapToInt(elem->elem).average().orElse(Double.NaN));
        System.out.println("Srednia liczba porównan dla wyszukiwan chybionych: "+LINEAR_COMPARATIONS_WRONG.stream().mapToInt(elem->elem).average().orElse(Double.NaN));
        System.out.println("Srednia liczba porównan dla wyszukiwan: "+(LINEAR_COMPARATIONS_OK.stream().mapToInt(elem->elem).sum() + LINEAR_COMPARATIONS_WRONG.stream().mapToInt(elem->elem).sum())/(ok_search_linear+wrong_search_linear));
        System.out.println("WYSZUKIWANIE BINARNE W TABLICY POSORTOWANEJ: ");
        System.out.println("Liczba wyszukiwań trafionych: "+ok_search_binary);
        System.out.println("Liczba wyszukiwań chybionych: "+wrong_search_binary);
        System.out.println("Srednia liczba porównan dla wyszukiwan trafionych: "+BINARY_COMPARATIONS_OK.stream().mapToInt(elem->elem).average().orElse(Double.NaN));
        System.out.println("Srednia liczba porównan dla wyszukiwan chybionych: "+BINARY_COMPARATIONS_WRONG.stream().mapToInt(elem->elem).average().orElse(Double.NaN));
        System.out.println("Srednia liczba porównan dla wyszukiwan: "+(BINARY_COMPARATIONS_OK.stream().mapToInt(elem->elem).sum() + BINARY_COMPARATIONS_WRONG.stream().mapToInt(elem->elem).sum())/(ok_search_binary+wrong_search_binary));


    }
}
