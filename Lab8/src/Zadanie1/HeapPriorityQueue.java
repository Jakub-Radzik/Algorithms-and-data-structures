package Zadanie1;

public class HeapPriorityQueue implements IQueue {
    private int[] tab;
    private int SIZE;

    public HeapPriorityQueue(int[] tab) {
        this.tab = tab;
        SIZE = tab.length;
        buildHeap(tab,SIZE);
    }

    @Override
    public void enqueue(int value) throws Exception{
        if(isFull()){
            throw new Exception("Kolejka pełna");
        }else{
            tab[SIZE] = value;
            SIZE++;
        }
        buildHeap(tab,SIZE);
    }

    @Override
    public void clear() {
        tab = null;
        SIZE = 0;
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean isEmpty() {
        return SIZE == 0;
    }

    @Override
    public boolean isFull() {
        return SIZE == tab.length;
    }

    @Override
    public int first() throws Exception{
        if (isEmpty()) throw new Exception("Pusta kolejka");
        return tab[0];
    }

    @Override
    public int dequeue() throws Exception{
        if (isEmpty()) throw new Exception("Pusta kolejka");
        int result = tab[0];
        if (SIZE > 1) {
            tab[0] = tab[SIZE - 1];
            sink(0);
        }
        remove(SIZE - 1);
        return result;
    }

    @Override
    public void changePriority(int idx, int newPriority) throws Exception {
        if(isEmpty()) throw new Exception("Pusta kolejka");
        if(idx>=SIZE || idx<0) throw new Exception("Błędny indeks");
        tab[idx] = newPriority;
        buildHeap(tab,SIZE);
    }

    @Override
    public int remove(int idx) throws Exception {
        if(idx>=SIZE || idx<0) throw new IndexOutOfBoundsException("Indeks nie istnieje");
        if(isEmpty()) throw new Exception("Pusta kolejka");
        int returnValue = tab[idx];
        swap(idx, SIZE-1);
        SIZE--;
        buildHeap(tab,SIZE);
        return returnValue;
    }

    private void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

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
    private void buildHeap(int arr[], int n) {
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private void swap(int index1, int index2) {
        int temp = tab[index1];
        tab[index1] = tab[index2];
        tab[index2] = temp;
    }

    private void swim(int index) {
        int parent;

        while(index != 0 && tab[index] > tab[ parent= (index - 1) / 2 ]){
            swap(index, parent);
            index = parent;
        }
    }

    private void sink(int index) {
        boolean isDone = false;
        int child;
        while (!isDone && (child = 2 * index + 1) < SIZE) {
            if (child < SIZE - 1 && tab[child] < tab[child + 1])
                ++child;
            if (tab[index] < tab[child]) {
                swap(index, child);
                index = child;
            } else isDone = true;
        }
    }

    public void print(){
        String txt = "[";
        for (int i = 0; i < SIZE; i++) {
            txt+=tab[i]+", ";
        }
        txt+="]";
        System.out.println(txt);
    }

    public void printTree(){
        StringBuilder sb = new StringBuilder();
        int max=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<Math.pow(2,i) && j+Math.pow(2,i)<10;j++){

                if(j>max){
                    max=j;
                }
            }

        }

        for(int i=0;i<10;i++){
            for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<10;j++){

                for(int k=0;(k<max/((int)Math.pow(2, i)));k++){
                    sb.append(" ");
                }
                sb.append(tab[j+(int)Math.pow(2,i)-1]+" ");

            }
            sb.append("\n");
        }



        System.out.println(sb.toString());

    }


}
