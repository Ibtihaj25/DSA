import java.util.*;

public class BfsAndDfsUsingGraph {
    private int numVertices; // Number of vertices
    private ArrayList<ArrayList<Integer>> adjacencyList; // Adjacency list representation

    // Constructor
    public BfsAndDfsUsingGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);

        // Initialize adjacency lists for all vertices
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph (undirected)
    public void addEdge(int source, int dest) {
        adjacencyList.get(source).add(dest); // Add edge from source to destination
        adjacencyList.get(dest).add(source); // Add edge from destination to source
    }

    // Breadth-First Search (BFS)
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices]; // Track visited vertices
        Queue<Integer> queue = new LinkedList<>();   // Queue for BFS traversal

        // Mark the starting vertex as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue a vertex
            System.out.print(vertex + " ");

            // Enqueue all unvisited neighbors of the dequeued vertex
            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS)
    public void DFS(int startVertex, boolean[] visited) {
        // Mark the current vertex as visited
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        // Recur for all unvisited neighbors
        for (int neighbor : adjacencyList.get(startVertex)) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        BfsAndDfsUsingGraph graph = new BfsAndDfsUsingGraph(6); // Create a graph with 6 vertices

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform BFS
        graph.BFS(0);

        // Perform DFS
        System.out.print("DFS Traversal: ");
        boolean[] visited = new boolean[6]; // Initialize visited array for DFS
        graph.DFS(0, visited);
    }
}
