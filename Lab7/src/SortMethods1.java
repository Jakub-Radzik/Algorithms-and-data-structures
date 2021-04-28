public class SortMethods1 {

    private static int comparisons;
    private static int rewrites;

    public static int getComparisons() {
        return comparisons;
    }

    public static void setComparisons(int comparisons) {
        SortMethods1.comparisons = comparisons;
    }

    public static int getRewrites() {
        return rewrites;
    }

    public static void setRewrites(int rewrites) {
        SortMethods1.rewrites = rewrites;
    }

    //merge
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            rewrites++;
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            rewrites++;
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            comparisons++;
            if (l[i] <= r[j]) {
                rewrites++;
                a[k++] = l[i++];
            } else {
                rewrites++;
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            rewrites++;
            a[k++] = l[i++];
        }
        while (j < right) {
            rewrites++;
            a[k++] = r[j++];
        }
    }

    //quick sort
    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        rewrites++;
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;

                rewrites += 3;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        rewrites += 3;
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
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

}

