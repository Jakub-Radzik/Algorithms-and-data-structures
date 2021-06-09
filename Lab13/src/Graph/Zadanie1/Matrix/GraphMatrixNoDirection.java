package Graph.Zadanie1.Matrix;

public class GraphMatrixNoDirection extends GraphMatrix{

    public GraphMatrixNoDirection(int n) {
        super(n);
    }

    @Override
    public void addEdge(int u, int v) {
        try{
            Matrix[u][v] = 1;
            Matrix[v][u] = 1;
        }catch (ArrayIndexOutOfBoundsException ex){
            int newSize = Math.max(u, v)+1;
            int[][] newMatrix = new int[newSize][];
            for (int i = 0; i < newSize; i++) {
                newMatrix[i] = new int[newSize];
            }

            for (int i = 0; i < Matrix.length; i++) {
                if (Matrix[i].length >= 0) System.arraycopy(Matrix[i], 0, newMatrix[i], 0, Matrix[i].length);
            }

            Matrix = newMatrix;
            Matrix[u][v] = 1;
            Matrix[v][u] = 1;
        }
    }
}
