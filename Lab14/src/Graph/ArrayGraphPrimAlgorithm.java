package Graph;

public class ArrayGraphPrimAlgorithm {
    protected int[][] graph;
    public int vertices_count;

    public ArrayGraphPrimAlgorithm(int[][] graph,int v) {
        this.graph = graph;
        this.vertices_count = v;
    }

    public void setEdge(int src, int dest, int weight){
        graph[src][dest] = weight;
        graph[dest][src] = weight;
    }

    public void primMST() {
        int[] parent = new int[vertices_count];
        int[] key = new int[vertices_count];

        //1) create a set to keep tracks of vertices already included
        Boolean[] mstSet = new Boolean[vertices_count];

        //2) Initialize all key values as INFINITE
        for (int i = 0; i < vertices_count; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        //3)Initialize all key values as INFINITE
        key[0] = 0;
        parent[0] = -1;

        //4)While mstSet does not include all vertices
        for (int count = 0; count < vertices_count - 1; count++) {
            int u = minKey(key, mstSet); //pick min key from mstSet
            mstSet[u] = true; //include vertex to mstSet
            for (int v = 0; v < vertices_count; v++)
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];   //update key value as weight [u][v]
                }
        }

        printMST(parent);
    }

    void printMST(int[] parent) {
        for (int i = 1; i < vertices_count; i++)
            System.out.println(parent[i]+" --- ["+graph[i][parent[i]]+"] --- " + i);
    }

    int minKey(int[] key, Boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int x = 0; x < vertices_count; x++){
            if (!mstSet[x] && key[x] < min) {
                min = key[x];
                min_index = x;
            }
        }
        return min_index;
    }
}
