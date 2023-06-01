

/**
 *
 * @author htrefftz
 */
public class Vertex implements Comparable<Vertex>{
    int number;
    int d;
    int color;
    Vertex pi;

    public Vertex(int number, int d, Vertex pi) {
        this.number = number;
        this.d = d;
        this.pi = pi;
    }
    public Vertex(int number) {
        this.number = number;
    }
    public Vertex(int node, int dist) {
        this.number = node;
        this.d = dist;
    }
       
    @Override
    public int compareTo(Vertex other) {
        return Integer.compare(d, other.d);
    }
}
