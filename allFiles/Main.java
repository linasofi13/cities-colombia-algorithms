/**
 * Implementación de algoritmos en grafos
 * Lina Sofía Ballesteros Merchán, Paulina Cerón Mancipe
 * May 30, 2023
 * Estructuras de Datos y Algoritmos II
 */
import java.util.*;

public class Main {
  
  public static void main(String[] args){
    String[] nombreCiudades = {"Riohacha", "Santa Marta", "Valledupar", "Barranquilla", "Cartagena", "Sincelejo", "Magangué", "Cucuta", "Bucaramanga", "Monteria", "Medellin", "Apartado", "Quibdo", "Nuqui", "Manizales", "Tunja", "Yopal", "Bogota", "Cali", "Pereira", "Armenia", "Ibague", "Neiva", "Villavicencio","Arauca", "Puerto Carreño", "Inirida", "Arauquita", "San José del Guaviare", "Florencia", "Mocoa", "Popayan", "Pasto", "Tumaco", "San Vicente del Caguan", "Miraflores", "San Martin", "Rionegro", "Pamplona" , "San Andres"};
    City[] ciudades = new City[40];

    /* 
      Scanner scn = new Scanner(System.in);
      System.out.println("Ciudad de origen: ");
      String city =   scn.next();
      System.out.println("Ciudad de destino: ");
      String destiny = scn.next();     
     */

    String city = "Pasto";
    String destiny = "Medellin";

    BreadthFirst bf = new BreadthFirst("citiesColombia.txt",nombreCiudades);
    Dijkstra dijkstra = new Dijkstra("citiesColombia.txt", "new");
    Graph bellman = new Graph("citiesColombia.txt");
    FloydWarshall fw = new FloydWarshall("citiesColombia.txt");
    
    //Ciudades para cada algoritmo
    for(int i = 0; i < ciudades.length; i++) {
        ciudades[i] = new City(nombreCiudades[i], i + 1);
        bf.ciudades[i] = new City(nombreCiudades[i], i + 1);
        bellman.ciudades[i] = new City(bellman.nombreCiudades[i], i + 1);
    }

    int source = bellman.getNumber(city);
    int finalc = bellman.getNumber(destiny);

    //Implementación de cada algoritmo desde la ciudad dada
    for (int i = 0; i < bellman.ciudades.length; i++) {
        
        if (bellman.nombreCiudades[i].equals(city)) {
            System.out.println("*** BELLMAN FORD***");
            System.out.println("Desde la ciudad: "+ city);
            bellman.initialize(i + 1);
            long start = System.nanoTime();
            bellman.bellFDistances(source);
            long end = System.nanoTime();
            System.out.println();
            System.out.println(bellman.distances());
            System.out.println("Tiempo Bellman Ford: " + (end - start)+"\n");
        }
        if (nombreCiudades[i].equals(city)) {
            System.out.println("***DIJKSTRA***");
            System.out.println("Desde la ciudad: "+ city);
            long start = System.nanoTime();
            dijkstra.DijkstraDistance(i + 1);
            long end = System.nanoTime();
            ArrayList<Integer> path = dijkstra.getPath(finalc);
            System.out.println("Hacia la ciudad "+destiny);
            System.out.print(path);
            System.out.println(" distance: " + dijkstra.dist[finalc]);
            System.out.println("Hacia todas las ciudades: ");
            System.out.println(Arrays.toString(dijkstra.dist));

            System.out.println("Tiempo Dijkstra: " + (end - start)+"\n");
        }
        if (nombreCiudades[i].equals(city)) {
            System.out.println("***BREADH FIRST***");
            System.out.println("Desde la ciudad: "+ city);
            long start = System.nanoTime();
            bf.BFSDistances(i + 1);
            long end = System.nanoTime();
            System.out.println(bf);
            System.out.println("Tiempo BFS " + (end - start)+"\n");
        }

    }
    System.out.println("***FLOYD-WARSHALL***");
    long start = System.nanoTime();
    fw.computeDistances();
    long end = System.nanoTime();
    System.out.println("Tiempo FloydWarshall: " + (end - start)+"\n");
    
} 
}
