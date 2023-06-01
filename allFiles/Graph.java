import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author htrefftz
 */
public class Graph {
    int V;
    int E;
    
    Edge [] edges;
    Vertex [] vertices;
    String[] nombreCiudades = {"Riohacha", "Santa Marta", "Valledupar", "Barranquilla", "Cartagena", "Sincelejo", "Magangué", "Cucuta", "Bucaramanga", "Monteria", "Medellin", "Apartado", "Quibdo", "Nuqui", "Manizales", "Tunja", "Yopal", "Bogota", "Cali", "Pereira", "Armenia", "Ibague", "Neiva", "Villavicencio","Arauca", "Puerto Carreño", "Inirida", "Arauquita", "San José del Guaviare", "Florencia", "Mocoa", "Popayan", "Pasto", "Tumaco", "San Vicente del Caguan", "Miraflores", "San Martin", "Rionegro", "Pamplona" , "San Andres"};
    City[] ciudades = new City[40];
    
    int numEdges;
    
    public Graph(String filename) {
        try {
            Scanner in = new Scanner(new File(filename));
            // Read number of vertices and number of edges
            V = in.nextInt();
            E = in.nextInt();

            // Define the array lists of size V + 1
            edges = new Edge[E];
            vertices = new Vertex[V+1];
            numEdges = 0;
            
            // Read each edge from the file (there are E edges) and add it
            // to the array
            for(int i = 0; i < E; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();
                Edge e = new Edge(u, v, w);
                addEdge(e);
            }
        } catch (IOException e) {
            System.out.println("Could not open file " + filename);
            System.exit(1);
        }
        
    }
    
    public void initialize(int s) {
        for(int i = 1; i <= V; i++) {
            Vertex v = new Vertex(i, Integer.MAX_VALUE, null);
            vertices[i] = v;
        }
        vertices[s].d = 0;
    }

    public String getName(int number){
        return ciudades[number].name;
    }
    public int getNumber(String ciudad) {
        for (int i = 0; i < nombreCiudades.length; i++) {
            if (nombreCiudades[i].equals(ciudad)) {
                return i+1; 
            }
        }
        return -1; 
    }
    
    public boolean bellFDistances(int s) {
        // Inicializar las distancias de los vértices usando el metodo initialize
        initialize(s);
        // Iterar sobre todos los vértices, V - 1 veces, el total de vertices menos 1
        for (int i = 1; i <= V-1; i++) {
            // Iterar sobre todas las aristas del grafo 
            for (int j = 0; j < E; j++) {
                // Relajar la arista en la que vamos usando el metodo relax
                relax(edges[j]); 
            }
        }
        
        return true;
    }
    
    public String distances() {
        String s = "";
        for(int i = 1; i <= V; i++) {
            s += "City " + i + " Name: " + ciudades[i-1] + " distance : " + vertices[i].d;
            if(vertices[i].pi == null) {
                s += " pi: nil\n";
            } else {
                s += " pi: " + vertices[i].pi.number + "| Name: " + getName(vertices[i].pi.number) +"\n";
            }
        }
        return s;
    }
    
    void relax(Edge e) {
        Vertex u = vertices[e.u];
        Vertex v = vertices[e.to];
        int w = e.weight;
        if(u.d != Integer.MAX_VALUE && v.d > u.d + w) {
            v.d = u.d + w;
            v.pi = u;
        }
    }
        
    void addEdge(Edge e) {
        edges[numEdges] = e;
        numEdges++;
    }
    
    public String toString() {
        String s = "";
        for(int i = 0; i < E; i++) {
            s += edges[i].u + " -> " + edges[i].to + " : " + edges[i].weight + "\n";
        }
        return s;
    }
}