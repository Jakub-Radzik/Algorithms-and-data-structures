import java.util.Comparator;

public class SortMethods {

    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator){
        boolean sorted = false;
        T temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (comparator.compare(arr[i],arr[i+1]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static <T> void selectionSort(T[] arr, Comparator<T> comparator){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (comparator.compare(arr[j], arr[min_idx])<0)
                    min_idx = j;
            T temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static <T> void insertionSort(T[] arr, Comparator<T> comparator){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(arr[j], key)>0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}
