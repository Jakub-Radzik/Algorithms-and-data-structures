package zad1;

public abstract class ArrayDisjoint {
    int[] rank, parent;
    int n;

    public ArrayDisjoint(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    abstract int find(int x);

    abstract void union(int i, int j);
}
