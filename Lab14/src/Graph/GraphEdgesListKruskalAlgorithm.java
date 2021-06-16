package Graph;

import java.util.Arrays;

public class GraphEdgesListKruskalAlgorithm {

    int vertices_count, edges_count;
    public Edge[] edge;

    public GraphEdgesListKruskalAlgorithm(int vertices, int edges) {
        vertices_count = vertices;
        edges_count = edges;
        edge = new Edge[edges_count];
        for (int i = 0; i < edges; ++i)
            edge[i] = new Edge();
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(Subset[] subsets, int x, int y) {
        int x_root = find(subsets, x);
        int y_root = find(subsets, y);

        if (subsets[x_root].rank < subsets[y_root].rank) {
            subsets[x_root].parent = y_root;
        } else if (subsets[x_root].rank > subsets[y_root].rank) {
            subsets[y_root].parent = x_root;
        } else {
            subsets[y_root].parent = x_root;
            subsets[x_root].rank++;
        }
    }

    public void KruskalMST() {
        //create of new edges
        Edge[] result = new Edge[vertices_count];

        int e = 0;
        int i = 0; //sort by index
        //prepearing for new graph
        for (i = 0; i < vertices_count; ++i)
            result[i] = new Edge();

        //1) sort by weight: i
        Arrays.sort(edge);

        Subset[] subsets = new Subset[vertices_count];
        for (i = 0; i < vertices_count; ++i)
            subsets[i] = new Subset();

        //creating single elem subsets
        for (int v = 0; v < vertices_count; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0; //edge index


        while (e < vertices_count - 1) {
            Edge next_edge = edge[i];
            System.out.println("\nWe are on edge: " + next_edge.getSrc() + "---[" + next_edge.getWeight() + "]---" + next_edge.getDest());
            i++;

            int x = find(subsets, next_edge.getSrc());
            int y = find(subsets, next_edge.getDest());
            System.out.println("Found: " + x + "(source) " + y + "(target)");

            if (x != y) {
                result[e++] = next_edge;
                System.out.println("Union on " + x + " --- " + y);
                Union(subsets, x, y);
            }
        }

        System.out.println("\nResult MST: ");
        System.out.println("src --- [weight] --- dest\n");
        int minimumSumOfEdges = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].getSrc() + " --- [" + result[i].getWeight() + "] --- " + result[i].getDest());
            minimumSumOfEdges += result[i].getWeight();
        }
        System.out.println("Lowest possible sum of weights MST: " + minimumSumOfEdges);
    }



    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Edge value : edge) {
            txt.append(value.getSrc())
                    .append(" --- [")
                    .append(value.getWeight());

            if (value.getWeight() > 9) {
                txt.append("] --- ");
            } else {
                txt.append("]  --- ");
            }

            txt.append(value.getDest())
                    .append("\n");
        }

        return txt.toString();
    }
}