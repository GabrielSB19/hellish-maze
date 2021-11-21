package collection;

public interface IGraph<V,E> {
    void addEdge(E edge,V source, V destination);
    void addVextex(V vertex);
    IVertex<V,E> getVertex(int id);
    int[] dijkstra(int source);
    int[][] floydWarshall();
    void prim();
    void kruskal();
}
