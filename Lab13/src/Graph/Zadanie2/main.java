package Graph.Zadanie2;

public class main {
    public static void main(String[] args) {
        AdjecncyGraphDirectionWithTravelsals graph = new AdjecncyGraphDirectionWithTravelsals(10);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(7,8);
        graph.addEdge(8,9);
        graph.addEdge(7,9);
        graph.addEdge(1,9);

        graph.printGraph();
        System.out.println("BFS from 0: ");
        graph.BFS(0);
        System.out.println("DFS from 0: ");
        graph.DFS();

    }
}
