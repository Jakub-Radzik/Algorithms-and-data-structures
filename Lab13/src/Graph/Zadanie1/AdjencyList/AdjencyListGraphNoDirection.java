package Graph.Zadanie1.AdjencyList;

import java.util.ArrayList;

public class AdjencyListGraphNoDirection extends GraphAdjency {

    public AdjencyListGraphNoDirection(int n) {
        super(n);
    }

    @Override
    public void addEdge(int u, int v) {

        ArrayList<Integer> tmp;

        try{
            tmp = adjencyList.get(u);
            tmp.add(v);
            adjencyList.put(u, tmp);
        }catch (NullPointerException ex){
            tmp = new ArrayList<>();
            tmp.add(v);
            adjencyList.put(u, tmp);
        }

        try {
            tmp = adjencyList.get(v);
            tmp.add(u);
            adjencyList.put(v, tmp);
        }catch (NullPointerException ex){
            tmp = new ArrayList<>();
            tmp.add(u);
            adjencyList.put(v, tmp);
        }

    }
}
