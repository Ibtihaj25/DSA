package Lab14;
import java.util.ArrayList;

public class Graph {
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
    public Graph(int numVertices) {
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

    // Main method for testing
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 4, 20);
        g.addEdge(1, 2, 30);
        g.addEdge(1, 3, 40);
        g.addEdge(1, 4, 50);
        g.addEdge(3, 4, 60);

        g.getAllNeighbour();
    }
}
