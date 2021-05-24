package zad1.onArrays;

public class ArrayDisjointSetsCompression extends ArrayDisjoint{

    public ArrayDisjointSetsCompression(int n) {
        super(n);
    }

    @Override
    void makeSet() {
        super.makeSet();
    }

    @Override
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        else{
            int result = find(parent[i]);
            parent[i] = result;
            return result;
        }
    }

//    @Override
//    public void union(int x, int y) {
//        super.union(x, y);
//    }


}
