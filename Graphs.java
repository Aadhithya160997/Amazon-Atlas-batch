class Edge {
    int source;
    int destination;

    // Constructor
    Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
}

public class Graphs {
    // Method to display the graph edges
    static void displayGraph(Edge[] edges, int numberOfEdges) {
        System.out.println("Graph Edges:");
        for(int i = 0; i < numberOfEdges; i++) {
            System.out.println(edges[i].source + " - " + edges[i].destination);
        }
    }

    public static void main(String[] args) {
        // Define number of edges and vertices
        int numberOfEdges = 8;
        int numberOfVertices = 5;

        // Create array of edges
        Edge[] edges = new Edge[numberOfEdges];

        // Initialize edges
        edges[0] = new Edge(1, 2);
        edges[1] = new Edge(1, 3);
        edges[2] = new Edge(1, 4);
        edges[3] = new Edge(2, 4);
        edges[4] = new Edge(2, 5);
        edges[5] = new Edge(3, 4);
        edges[6] = new Edge(3, 5);
        edges[7] = new Edge(4, 5);

        // Display the graph
        displayGraph(edges, numberOfEdges);
    }
}
