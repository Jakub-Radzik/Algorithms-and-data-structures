package zad1.onArrays;

public class ArrayDisjointSetsNoCompression extends ArrayDisjoint {

    public ArrayDisjointSetsNoCompression(int n) {
        super(n);
    }

    @Override
    void makeSet() {
        super.makeSet();
    }

    //NO COMPRESSION
    @Override
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

}
