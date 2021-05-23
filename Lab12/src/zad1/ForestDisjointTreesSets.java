package zad1;

public class ForestDisjointTreesSets {
    int parent[];
    int rank[];

    public ForestDisjointTreesSets(int i) {
        this.parent = new int[i];
        this.rank = new int[i];
    }

    public void makeSet(int x){
        parent[x] = x;
        rank[x] = 0;
    }

    public void union(int x, int y){
        link(findSet(x), findSet(y));
    }

    public void link(int x, int y){
        if(rank[x]>rank[y]){
            parent[y] = x;
        }else{
            parent[x] = y;
            if(rank[x]==rank[y]){
                rank[y]=rank[y]+1;
            }
        }
    }

    public int findSet(int x) {
        if(x!= parent[x]){
            parent[x] = findSet(parent[x]); //compression by caching result
        }
        return parent[x];
    }
}
