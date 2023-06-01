
/**
 * Maintains the info of an Edge
 * @author htrefftz
 */
public class Edge {
    int u;
    int to;                     // Destination node
    int weight;                 // Weight to destination node

    
    public Edge(int u, int v, int w) {
        this.u = u;
        this.to = v;
        this.weight = w;
    }
    public Edge(int v, int weight) {
        this.to = v;
        this.weight = weight;
    }
   
    
    
}
