package Graph.Zadanie2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdjecncyGraphDirectionWithTravelsals {
        private Map<Integer, ArrayList<Integer>> adjencyList = new HashMap<>();
        private String result;

        public AdjecncyGraphDirectionWithTravelsals(int size) {
            for (int i = 0; i < size; i++) {
                adjencyList.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int x, int y) {
            if (x < adjencyList.size() && y < adjencyList.size())
                adjencyList.get(x).add(y);
        }

        public void addNode(int i) {
            adjencyList.put(i ,new ArrayList<>());
        }

        public void BFS(int s) {
            boolean[] visitedNodes = new boolean[adjencyList.size()];
            StringBuilder travel = new StringBuilder();
            ArrayList<Integer> queue = new ArrayList<>();

            visitedNodes[s] = true;
            queue.add(s);

            System.out.println("\nAdded element: " + s);
            System.out.println("Queue:" + queue);
            System.out.println("Visited elements:");

            for (int i = 0; i < visitedNodes.length; i++)
                System.out.print("["+i + " - " + visitedNodes[i] + "]");

            System.out.println("\n");

            while (queue.size() != 0) {
                s = queue.remove(0);
                travel.append(s).append(" ");

                System.out.println("Displayed elem: " + s);
                System.out.println("Current result: " + travel);
                System.out.println("Queue:" + queue + "\n");

                for (int n : adjencyList.get(s)) {
                    if (!visitedNodes[n]) {
                        visitedNodes[n] = true;
                        queue.add(n);
                        System.out.println("We add elem: " + n);
                        System.out.println("Queue:" + queue);
                        System.out.println("Visited elems:");
                        for (int i = 0; i < visitedNodes.length; i++) {
                            System.out.print("[" + i + " - " + visitedNodes[i] + "]");
                        }
                        System.out.println("\n");
                    }
                }
            }
            System.out.println("\n\nFinal result: " + travel);
        }


        private void DFSRec(boolean[] visited, int x) {
            visited[x] = true;
            result += x + " ";
            System.out.println("New result: " + result + "\n");

            for (int n : adjencyList.get(x)) {
                if (!visited[n]) {
                    System.out.println("We visit: " + n);
                    DFSRec(visited, n);
                }
            }
        }

        public void DFS() {
            boolean[] visited = new boolean[adjencyList.size()];
            result = "";
            for (int i = 0; i < adjencyList.size(); ++i) {
                if (!visited[i]) {
                    System.out.println("We visit: " + i);
                    DFSRec(visited, i);
                }
            }
            System.out.println("\n\nFinal result: " + result);
        }

        public void printGraph() {
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
