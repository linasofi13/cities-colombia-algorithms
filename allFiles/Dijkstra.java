
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Implementation of Dijkstra's algorithm
 * @author htrefftz and ChatGPT 3.5
 */
public class Dijkstra {

    LinkedList<Edge>[] graph;       // Graph
    int[] dist;                    // shortest distances to each vertex
    int[] prev;                    // previous vertex in shortest path
    ArrayList<Vertex> q;            // Queue as an ArrayList
    PriorityQueue<Vertex> pq;     // Queue as a PriorityQueue

    /**
     * Constructor. Reads the graph from a file.
     * 
     * @param fileName Name of the file
     */
    public Dijkstra(String fileName, String format) {
        if(format.equals("new")) readFileNewFormat(fileName);
        int n = graph.length;
        // Initialize arrays
        dist = new int[n];          
        prev = new int[n];
        q = new ArrayList();                // Queue as an ArrayList
        pq = new PriorityQueue<>();       // Queue as a PriorityQueue
    }

    /**
     * Finds the shortest distances from source to all other nodes
     * 
     * @param source starting node
     */
    public void DijkstraDistance(int source) {
        Arrays.fill(dist, Integer.MAX_VALUE);   // Initially, distances are infinite
        dist[source] = 0;                       // Distance from source to source = 0
        prev[source] = -1;                      // Source has no predecesor
        //q.add(new Vertex(source, 0));           // Start adding source to the queue
        pq.add(new Vertex(source, 0));
        
        //while (!q.isEmpty()) {
        //    Vertex u = poll(q);                     // Retrieve vertex with smallest distance

        while(!pq.isEmpty()) {
            Vertex u = pq.poll();
            
            // The following condition is necessary if the distance cannot be updated
            // in the priority queue
            if (u.d > dist[u.number]) {            // u's distance larger that the
                continue;                           // distance stored in d
            }                                       // Older distance was added previously to the PQ

            for (Edge v : graph[u.number]) {          // Visit all numbers "e" that v conects to
                int alt = dist[u.number] + v.weight;
                if (alt < dist[v.to]) {             // Check if e's distance can be improved
                    dist[v.to] = alt;               // Update distance
                    prev[v.to] = u.number;            // Update predecessor
                    //q.add(new Vertex(v.to, dist[v.to]));   // Add vertext e to Q
                    pq.add(new Vertex(v.to, dist[v.to]));
                }
            }
        }
    }

    /**
     * Returns an ArrayList with the path from source to target
     * @param target Target node
     * @return 
     */
    public ArrayList<Integer> getPath(int target) {
        ArrayList<Integer> path = new ArrayList<>();
        for (int node = target; node != -1; node = prev[node]) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;

    }

    
    /**
     * Reads the graph from a text file.
     * 
     * Format:
     * numVertices numEdges
     * origin destination weight
     * 
     * @param fileName 
     */
    private void readFileNewFormat(String fileName) {
        try {
            Scanner in = new Scanner(new File(fileName));
            int numVertices = in.nextInt();
            int numEdges = in.nextInt();
            graph = new LinkedList[numVertices + 1];               // Create array of lines
            for(int i = 1; i <= numVertices; i++) {
                graph[i] = new LinkedList<>();
            }
            for(int i = 0; i < numEdges; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                int w = in.nextInt();
                graph[from].add(new Edge(to, w));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo " + fileName);
            System.exit(1);
            
        }
    }

}
