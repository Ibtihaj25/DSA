import java.util.*;

public class GraphUsingPrim {
    private ArrayList<Edge>[] graph;

    // Edge class to store destination and weight
    private static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        public String toString() {
            return "(Dest: " + dest + ", Weight: " + weight + ")";
        }
    }

    // Constructor
    public GraphUsingPrim(int numVertices) {
        graph = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    // Method to add an edge
    public void addEdge(int src, int dest, int weight) {
        graph[src].add(new Edge(dest, weight));
        graph[dest].add(new Edge(src, weight)); // Since it's an undirected graph
    }

    // Method to print all neighbors
    public void getAllNeighbour() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + ": " + graph[i]);
            System.out.println();
        }
    }

    // Prim's Algorithm for Minimum Spanning Tree
    public void primsMST() {
        int numVertices = graph.length;
        boolean[] inMST = new boolean[numVertices];
        int[] key = new int[numVertices];
        int[] parent = new int[numVertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.dest;

            if (inMST[u]) continue;
            inMST[u] = true;

            for (Edge neighbor : graph[u]) {
                int v = neighbor.dest;
                int weight = neighbor.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Edge(v, key[v]));
                }
            }
        }

        // Print the MST
        System.out.println("Minimum Spanning Tree:");
        for (int i = 1; i < numVertices; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " | Weight: " + key[i]);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        GraphUsingPrim g = new GraphUsingPrim(5);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 4, 20);
        g.addEdge(1, 2, 30);
        g.addEdge(1, 3, 40);
        g.addEdge(1, 4, 50);
        g.addEdge(3, 4, 60);

        g.getAllNeighbour();
        System.out.println();
        g.primsMST();
    }
}
