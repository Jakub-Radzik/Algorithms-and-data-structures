package Graph;

public class Edge implements Comparable<Edge> {
    private int src, dest, weight;

    public int compareTo(Edge compareEdge){
        return this.weight - compareEdge.weight;
    }

    public void setParams(int src, int dest, int weight){
        setSrc(src);
        setDest(dest);
        setWeight(weight);
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
