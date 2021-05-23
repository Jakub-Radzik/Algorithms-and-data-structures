package zad1;

public class ArrayDisjointSetsCompression extends ArrayDisjoint{

    public ArrayDisjointSetsCompression(int n) {
        super(n);
    }
    @Override
    void makeSet() {
        super.makeSet();
    }

    @Override
    int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        else{
            int result = find(parent[i]);
            parent[i] = result;
            return result;
        }
    }

    @Override
    void union(int i, int j) {
        int irepresentant = this.find(i);
        int jrepresentant = this.find(j);
        this.parent[irepresentant] = jrepresentant;
    }
}
