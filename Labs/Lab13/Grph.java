package Lab13;
import java.util.ArrayList;

public class Grph {
    private int numVertices; // Number of vertices in the graph
    private ArrayList<ArrayList<Edge>> adjacencyList; // Adjacency list representation

    // Constructor to initialize the graph
    public Grph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        
        // Initialize each vertex's adjacency list
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Edge class to represent a connection between two vertices
    static class Edge {
        int source; // Source vertex
        int dest;   // Destination vertex

        // Constructor to initialize an edge
        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // Add an edge in both directions (for an undirected graph)
    public void addEdge(int source, int dest) {
        if (source < 0 || source >= numVertices || dest < 0 || dest >= numVertices) {
            throw new IllegalArgumentException("Invalid vertex number");
        }
        
        // Add edge from source to destination
        adjacencyList.get(source).add(new Edge(source, dest));
        
        // Add edge from destination to source (for undirected graph)
        adjacencyList.get(dest).add(new Edge(dest, source));
    }

    // Print adjacency list of each vertex
    public void getAllNeighbour() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print(edge.dest + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grph graph = new Grph(5); // Create a graph with 5 vertices

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print adjacency list representation
        System.out.println("Adjacency List:");
        graph.getAllNeighbour();
    }
}
