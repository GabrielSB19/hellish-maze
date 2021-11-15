package collection;

public interface IGraph<V,E> {
    void addEdge(E edge,V source, V destination);
    void addVextex(V vertex);
    V getVertex(int id);
    int[] dijkstra(int source);
    int[][] floydWarshall();
}
