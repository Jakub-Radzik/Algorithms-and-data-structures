package zad1;

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
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y){
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot)
            return;

        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
