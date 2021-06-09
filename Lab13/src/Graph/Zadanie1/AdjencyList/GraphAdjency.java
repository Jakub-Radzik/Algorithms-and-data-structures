package Graph.Zadanie1.AdjencyList;

import java.util.*;

public abstract class GraphAdjency {

    public GraphAdjency(int n) {
        for (int i = 0; i < n; i++) {
            adjencyList.put(i, new ArrayList<>());
        }
    }
    protected Map<Integer, ArrayList<Integer>> adjencyList = new TreeMap<>();

    public abstract void addEdge(int u, int v);

    public void addNode(){
        adjencyList.put(adjencyList.size(), new ArrayList<Integer>());
    }

    public void printGraph(){
        for (Map.Entry<Integer, ArrayList<Integer>> entry : adjencyList.entrySet()) {
            int key = entry.getKey();
            ArrayList<Integer> list = entry.getValue();

            System.out.print("["+key+"]");
            for (int j = 0; j < list.size(); j++) {
                System.out.print(" -> "+ list.get(j));
            }
            System.out.println();

        }
    }



}
