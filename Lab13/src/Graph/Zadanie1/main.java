package Graph.Zadanie1;

import Graph.Zadanie1.AdjencyList.AdjencyListGraphDirection;
import Graph.Zadanie1.AdjencyList.AdjencyListGraphNoDirection;
import Graph.Zadanie1.AdjencyList.GraphAdjency;
import Graph.Zadanie1.Matrix.GraphMatrix;
import Graph.Zadanie1.Matrix.GraphMatrixDirection;
import Graph.Zadanie1.Matrix.GraphMatrixNoDirection;

public class main {
    public static void main(String[] args) {
        GraphAdjency adjencyListGraphNoDirection = new AdjencyListGraphNoDirection(10);
        GraphAdjency adjencyListGraphDirection = new AdjencyListGraphDirection(10);
        GraphMatrix graphMatrixDirection = new GraphMatrixDirection(10);
        GraphMatrix graphMatrixNoDirection = new GraphMatrixNoDirection(10);

        adjencyListGraphNoDirection.addEdge(0,1);
        adjencyListGraphNoDirection.addEdge(0,2);
        adjencyListGraphNoDirection.addEdge(0,3);
        adjencyListGraphNoDirection.addEdge(1,4);
        adjencyListGraphNoDirection.addEdge(2,5);
        adjencyListGraphNoDirection.addEdge(5,6);
        adjencyListGraphNoDirection.addEdge(5,12);

        adjencyListGraphNoDirection.addNode();

        adjencyListGraphDirection.addEdge(0,1);
        adjencyListGraphDirection.addEdge(0,2);
        adjencyListGraphDirection.addEdge(0,3);
        adjencyListGraphDirection.addEdge(1,4);
        adjencyListGraphDirection.addEdge(2,5);
        adjencyListGraphDirection.addEdge(5,6);
        adjencyListGraphDirection.addEdge(5,12);

        adjencyListGraphDirection.addNode();

        graphMatrixDirection.addEdge(0,1);
        graphMatrixDirection.addEdge(0,2);
        graphMatrixDirection.addEdge(0,3);
        graphMatrixDirection.addEdge(1,4);
        graphMatrixDirection.addEdge(2,5);
        graphMatrixDirection.addEdge(5,6);
        graphMatrixDirection.addEdge(5,12);

        graphMatrixDirection.addNode();

        graphMatrixNoDirection.addEdge(0,1);
        graphMatrixNoDirection.addEdge(0,2);
        graphMatrixNoDirection.addEdge(0,3);
        graphMatrixNoDirection.addEdge(1,4);
        graphMatrixNoDirection.addEdge(2,5);
        graphMatrixNoDirection.addEdge(5,6);
        graphMatrixNoDirection.addEdge(5,12);

        graphMatrixNoDirection.addNode();

        System.out.println("GRAPH - NO DIRECTION - ADJENCY LIST");
        adjencyListGraphNoDirection.printGraph();
        System.out.println("GRAPH - DIRECTION - ADJENCY LIST");
        adjencyListGraphDirection.printGraph();
        System.out.println("GRAPH - NO DIRECTION - NEIGHBOURHOOD MATRIX");
        graphMatrixNoDirection.printGraph();
        System.out.println("GRAPH - DIRECTION - NEIGHBOURHOOD MATRIX");
        graphMatrixDirection.printGraph();

    }
}
