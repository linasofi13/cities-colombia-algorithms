import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;

/**
 *
 * @author htrefftz
 */
public class AdjacencyList {
    
    // The graph is stored as an array of LinkedLists
    // Each LinkedList contains the 
    LinkedList<Edge> [] graph;
    
    // Number of vertices
    int V;
    
    // Number of edges
    int E;
    
    /**
     * Constructor.
     */
    public AdjacencyList(String filename) {
        try {
            Scanner in = new Scanner(new File(filename));
            // Read number of vertices and number of edges
            V = in.nextInt();
            E = in.nextInt();

            
            // Define the array lists of size V + 1
            // (from 0 to V)
            graph = new LinkedList[V+1];
            
            // Initialize each array position as a reference to an emtpy list
            for(int i = 1; i <= V; i++) {
                graph[i] = new LinkedList<Edge>();
            }
            
            // Read each edge from the file (there are E edges) and add it
            // to the adjacency list
            for(int i = 0; i < E; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();
                Edge e = new Edge(v,w);
                addEdge(u, e);
            }
        } catch (IOException e) {
            System.out.println("Could not open file " + filename);
            System.exit(1);
        }
    }
    
    /**
     * Add an edge to the adjacency list
     * @param u origin of the edge
     * @param v destination of the edge
     */
    public void addEdge(int u, Edge e) {
        // Add the edge to the list of the vertex u
        graph[u].add(e);
    }
    
    /**
     * Return a String that contains the graph information in a readable format
     * 
     * @return the string that can be printed
     */
    public String toString() {
        // Add the number of vertices and edges
        String s = "Number of vertices: " + V;
        s += " Number of edges: " + E + "\n";
        // Add the adjacency list
        for(int i = 1; i < V + 1; i++) {
            s += "Vertex " + i + " -> ";
            for(Edge e : graph[i]) {
                s += e.to + " ";
            }
            s += "\n";
        }
        return s;
    }
    
    /**
     * Main program
     * @param args 
     */
    public static void main(String [] args) {
        AdjacencyList al = new AdjacencyList("graph2.txt");
        System.out.println(al);
    }
    
}


