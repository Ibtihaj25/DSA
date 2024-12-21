public class GraphUsingAdjacencyMatrix {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public GraphUsingAdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    // Add an edge between two vertices (for an undirected graph)
    public void addEdge(int source, int destination) {
        if (source < 0 || source >= numVertices || destination < 0 || destination >= numVertices) {
            throw new IllegalArgumentException("Invalid vertex number");
        }
        adjacencyMatrix[source][destination] = 1; // Add edge from source to destination
        adjacencyMatrix[destination][source] = 1; // Add edge from destination to source
    }

    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        GraphUsingAdjacencyMatrix graph = new GraphUsingAdjacencyMatrix(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
