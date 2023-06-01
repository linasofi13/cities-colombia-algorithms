# cities-colombia-algorithms :round_pushpin:
Proyecto final para la materia Estructura de Datos y Algoritmos II. Dado un grafo de 40 ciudades de Colombia, se evalúa el algoritmo de BFS, Bellman-Ford, Dijkstra y Floyd-Warshall para el análisis de resultados y tiempos de ejecución de los mismos.

## Grafo y Dataset

El dataset se encuentra en el archivo llamado `citiesColombia.txt` el cual es un archivo de texto que contiene la cantidad de vertices y aristas junto con la distancia en km entre los nodos. De esta manera:

```
40 135
1 2 167
1 3 158
2 1 167 
  ```
A cada ciudad se le asigno un número y su nombre. La asignación puede apreciarse en esta imagen:

![image](https://github.com/linasofi13/cities-colombia-algorithms/assets/103126242/f37c3f3c-fcaa-4cf6-ad10-10c187296c41)

```
public City(String name, int number){
        this.name = name;
        this.number = number;
    }
 ```

El grafo se almacena en una lista de adyacencia a excepción del algoritmo de Floyd Warshall donde se almacena como Matriz de Adyacencia.

## Ejecución

Desde el archivo `Main.java` se pueden ejecutar los 4 algoritmos, indicando el origen deseado. Por defecto se asignó la ciudad de Pasto. Para el caso de Dijkstra, también se tiene la ciudad destino, la cual es Medellín, pudiendo ser modificada también por el usuario.

## Output

El programa muestra la ejecución de los 4 algoritmos. Para todos muestra las distancias mínimas y para Dijsktra se muestra el camino más corto entre el origen y el destino. Así mismo se muestra el tiempo de ejecución para cada algoritmo. Esta información se amplía en los informes.

## Informes 
Se encuentran en los archivos:
- `Informe_ProyectoFinal_Resultados.pdf`
- `Informe_ProyectoFinal_Tiempos.pdf`



** Realizado por Paulina Cerón y Lina Ballesteros en base al código de Helmuth Trefftz
