package zadanie2;

public class main2 {

    private static final int V = 9;

    public static void main(String[] args) {
        int[][] graph = new int[][] { { 0, 4, 1, 0, 0, 1, 0, 81, 0 },
                                    { 4, 0, 18, 0, 0, 0, 0, 111, 0 },
                                    { 1, 18, 0, 72, 0, 42, 0, 0, 22 },
                                    { 0, 0, 72, 0, 92, 114, 0, 0, 0 },
                                    { 0, 0, 0, 92, 0, 10, 0, 0, 0 },
                                    { 1, 0, 42, 114, 10, 0, 2, 0, 0 },
                                    { 0, 0, 0, 0, 0, 2, 0, 12, 62 },
                                    { 81, 111, 0, 0, 0, 0, 12, 0, 17 },
                                    { 0, 0, 22, 0, 0, 0, 62, 17, 0 } };

        GraphShortestPath dijkstra = new GraphShortestPath(graph, V);
        for (int i = 0; i < V; i++) {
            dijkstra.dijkstra(i);
        }

    }
}
