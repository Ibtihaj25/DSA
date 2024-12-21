import java.util.*;

public class GraphUsingDijkstra {
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
    public GraphUsingDijkstra(int numVertices) {
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

    // Dijkstra's Algorithm
    public void dijkstra(int source) {
        int[] distances = new int[graph.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(source, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.dest;

            for (Edge neighbor : graph[currentNode]) {
                int newDist = distances[currentNode] + neighbor.weight;
                if (newDist < distances[neighbor.dest]) {
                    distances[neighbor.dest] = newDist;
                    pq.add(new Edge(neighbor.dest, newDist));
                }
            }
        }

        // Print distances from the source
        System.out.println("Distances from source " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + " -> " + distances[i]);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        GraphUsingDijkstra g = new GraphUsingDijkstra(5);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 4, 20);
        g.addEdge(1, 2, 30);
        g.addEdge(1, 3, 40);
        g.addEdge(1, 4, 50);
        g.addEdge(3, 4, 60);

        g.getAllNeighbour();
        System.out.println();
        g.dijkstra(4);
    }
}
