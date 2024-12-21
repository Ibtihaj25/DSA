import java.util.*;

public class DirectedGraph {
    private int numVertices; // Number of vertices
    private ArrayList<ArrayList<Integer>> adjacencyList; // Adjacency list for the graph

    // Constructor
    public DirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        
        // Initialize adjacency lists
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add a directed edge from source to destination
    public void addEdge(int source, int dest) {
        adjacencyList.get(source).add(dest);
    }

    // Helper method to find all paths
    private void findAllPathsUtil(int current, int destination, boolean[] visited, List<Integer> path, List<List<Integer>> allPaths) {
        // Mark the current node as visited and add it to the current path
        visited[current] = true;
        path.add(current);

        // If the current node is the destination, add the path to allPaths
        if (current == destination) {
            allPaths.add(new ArrayList<>(path));
        } else {
            // Recur for all unvisited neighbors
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor]) {
                    findAllPathsUtil(neighbor, destination, visited, path, allPaths);
                }
            }
        }

        // Backtrack: Remove the current node from the path and mark it as unvisited
        path.remove(path.size() - 1);
        visited[current] = false;
    }

    // Method to print all paths from s to d
    public void printAllPaths(int source, int destination) {
        boolean[] visited = new boolean[numVertices]; // To track visited nodes
        List<Integer> path = new ArrayList<>();       // To store the current path
        List<List<Integer>> allPaths = new ArrayList<>(); // To store all valid paths

        // Find all paths
        findAllPathsUtil(source, destination, visited, path, allPaths);

        // Print the paths
        System.out.println("All paths from " + source + " to " + destination + ":");
        for (List<Integer> p : allPaths) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(4); // Create a graph with 4 vertices

        // Add edges to the graph
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);

        // Source and destination
        int source = 2, destination = 3;

        // Print all paths from source to destination
        graph.printAllPaths(source, destination);
    }
}
