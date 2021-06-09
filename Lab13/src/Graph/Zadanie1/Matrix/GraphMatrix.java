package Graph.Zadanie1.Matrix;

import java.util.Arrays;

public abstract class GraphMatrix {
    int[][] Matrix;

    public GraphMatrix(int n) {
        Matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            Matrix[i] = new int[n];
            Arrays.fill(Matrix[i], 0);
        }
    }
    public abstract void addEdge(int u, int v);
    public void addNode(){

        int[][] copy = new int[Matrix.length+1][];

        for (int i = 0; i < copy.length; i++) {
            copy[i] = new int[Matrix.length+1];
            Arrays.fill(copy[i], 0);
        }

        for (int i = 0; i < Matrix.length; i++) {
            System.arraycopy(Matrix[i], 0, copy[i], 0, Matrix[i].length);
        }
        Matrix = copy;
    }

    public void printGraph(){
        System.out.print("   ");
        for (int i = 0; i < Matrix.length; i++) {
            System.out.print(i+" ");
        }
        System.out.println();

        for (int i = 0; i < Matrix.length; i++) {
            if ((i < 10)) {
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }

            for (int j = 0; j < Matrix[i].length; j++) {
                if(j>9){
                    System.out.print(Matrix[i][j]+"  ");
                }else{
                    System.out.print(Matrix[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

}
