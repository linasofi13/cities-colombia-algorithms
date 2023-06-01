import java.util.LinkedList;
import java.util.Queue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author htrefftz
 */
public class BreadthFirst {

    public static final int WHITE = 0;
    public static final int GRAY = 1;
    public static final int BLACK = 2;

    AdjacencyList al;

    Queue<Vertex> queue;
    Vertex[] vertices;
    String[] nombreCiudades;
     City[] ciudades;


    public BreadthFirst(String fileName, String [] arr) {
        nombreCiudades = arr;
        ciudades = new City[40];
        al = new AdjacencyList(fileName);
        vertices = new Vertex[al.V + 1];
    }

    
    
    public void BFSDistances(int source) {
        int iteration = 0;
        for (int i = 1; i <= al.V; i++) {
            Vertex node = new Vertex(i);
            node.color = WHITE;
            node.d = Integer.MAX_VALUE;
            node.pi = null;
            vertices[i] = node;
        }
        vertices[source].color = GRAY;
        vertices[source].d = 0;
        vertices[source].pi = null;
    
        queue = new LinkedList<>();
        queue.add(vertices[source]);
        while (!queue.isEmpty()) {
            iteration++;
            /* //Imprime el paso a paso del algoritmo
            System.out.println(al);
            System.out.println("--------------------------");
            System.out.println("");
            System.out.println("Iteration " + iteration + "\n");
            System.out.println("--------------------------");
            
            for (int i = 1; i <= al.V; i++) {
                Vertex v = vertices[i];
                System.out.println("City " + nombreCiudades[i-1] + ": color = " + v.color + ", distance = " + v.d);
            }
            System.out.println("--------------------------");
            System.out.println("Queue: " + queue);*/
            Vertex u = queue.poll();
            //System.out.println("After Pop: " + queue);
            //System.out.println("Discovering neighbors of city: " + nombreCiudades[u.number-1]);
            for (Edge e : al.graph[u.number]) {
                Vertex v = vertices[e.to];
                if (v.color == WHITE) {
                    v.color = GRAY;
                    v.d = u.d + e.weight; 
                    v.pi = u;
                    queue.add(vertices[v.number]);
                }
            u.color = BLACK;
            //System.out.println("Queue: " + queue);  
            //System.out.println("--------------------------");
            
            }
        }
    }

    public String toString() {
        String s = "";
        for (int i = 1; i <= al.V; i++) {
                s += "Hacia: "+ "City #" + vertices[i].number +" "+ nombreCiudades[i-1] + ", " 
                    + "distancia: " + vertices[i].d
                    + "\n";
            
        }
        return s;
        
    }
    
        

}
