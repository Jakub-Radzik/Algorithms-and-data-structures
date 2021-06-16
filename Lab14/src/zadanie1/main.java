package zadanie1;

import Graph.ArrayGraphPrimAlgorithm;
import Graph.GraphEdgesListKruskalAlgorithm;

public class main {
    public static void main(String[] args) {
        System.out.println("GRAPH WITH KRUSKAL ALGOR.");
        int V = 7; // vertices
        int E = 12; // edges
        GraphEdgesListKruskalAlgorithm graph = new GraphEdgesListKruskalAlgorithm(V, E);

        graph.edge[0].setParams(0,1,10);
        graph.edge[1].setParams(0,2,6);
        graph.edge[2].setParams(0,3,5);
        graph.edge[3].setParams(1,3,15);
        graph.edge[4].setParams(2,3,4);
        graph.edge[5].setParams(3,4,9);
        graph.edge[6].setParams(4,5,1);
        graph.edge[7].setParams(3,5,30);
        graph.edge[8].setParams(1,5,50);
        graph.edge[9].setParams(2,6,5);
        graph.edge[10].setParams(3,6,5);
        graph.edge[11].setParams(4,6,5);

        System.out.println("Starter Graph");
        System.out.println(graph.toString());
        System.out.println("Algo. kruksal operation:");
        graph.KruskalMST();


        System.out.println("GRAPH - PRIM ALGOR.");

        int[][] graph2 = new int[V][V];
        ArrayGraphPrimAlgorithm prim = new ArrayGraphPrimAlgorithm(graph2, V);
        prim.setEdge(0,1,10);
        prim.setEdge(0,2,6);
        prim.setEdge(0,3,5);
        prim.setEdge(1,3,15);
        prim.setEdge(2,3,4);
        prim.setEdge(3,4,9);
        prim.setEdge(4,5,1);
        prim.setEdge(3,5,30);
        prim.setEdge(1,5,50);
        prim.setEdge(2,6,5);
        prim.setEdge(3,6,5);
        prim.setEdge(4,6,5);

        prim.primMST();


    }
}
