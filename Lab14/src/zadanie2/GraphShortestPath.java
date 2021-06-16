package zadanie2;

import Graph.ArrayGraphPrimAlgorithm;

public class GraphShortestPath extends ArrayGraphPrimAlgorithm {

    public GraphShortestPath(int[][] graph, int v) {
        super(graph, v);
    }
    int minDistance(int[] dist, Boolean[] sptSet){
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < vertices_count; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int[] dist, int src){
        System.out.println("Shortest way from "+src+":");
        for (int i = 0; i < vertices_count; i++)
            System.out.println(src+"->"+ i + " = " + dist[i]);
    }

    public void dijkstra(int src){
        int[] dist = new int[vertices_count];
        Boolean[] sptSet = new Boolean[vertices_count];

        for (int i = 0; i < vertices_count; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < vertices_count - 1; count++) {
            int y = minDistance(dist, sptSet);
            sptSet[y] = true;
            for (int x = 0; x < vertices_count; x++){
                if (!sptSet[x] && graph[y][x] != 0 &&
                        dist[y] != Integer.MAX_VALUE && dist[y] + graph[y][x] < dist[x])
                    dist[x] = dist[y] + graph[y][x];
            }

        }

        printSolution(dist, src);

    }
}
