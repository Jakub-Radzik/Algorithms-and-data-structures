package zad1.onArrays;

import java.util.ArrayList;

public abstract class ArrayDisjoint {
    protected int[] parent;

    public ArrayDisjoint(int n) {
        parent = new int[n];
        makeSet();
    }

    void makeSet() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public abstract int find(int x);

    public void union(int x, int y){
        int xRep = find(x);
        int yRep = find(y);
        parent[xRep] = yRep;
    }

    public void printSet() {
        for (int i=0; i<parent.length; i++) {
            int tmp = i;
            String s = "";
            while (parent[tmp] != tmp) {
                s += tmp + ", ";
                tmp = parent[tmp];
            }
            s += tmp + ", ";
            System.out.println(s);
        }
    }

    public void displaySets(){
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            sets.add(new ArrayList<>());
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(this.find(j)==i){
                    sets.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < sets.size(); i++) {
            if(sets.get(i).size()!=0){
                System.out.print("[");
                sets.get(i).stream().forEach(e -> System.out.print(e+ ", "));
                System.out.print("]");
            }
        }
        System.out.println();
    }

}
