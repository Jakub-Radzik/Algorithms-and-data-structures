package Graph.Zadanie1.AdjencyList;

import java.util.ArrayList;

public class AdjencyListGraphDirection extends GraphAdjency {

    public AdjencyListGraphDirection(int n) {
        super(n);
    }

    @Override
    public void addEdge(int u, int v) {
        ArrayList<Integer> tmp = adjencyList.get(u);
        tmp.add(v);
        adjencyList.put(u, tmp);
        adjencyList.put(v, new ArrayList<>());

    }


}
