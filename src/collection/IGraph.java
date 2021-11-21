package collection;

public interface IGraph<V,E> {
    void addEdge(E edge,V source, V destination);
    void addVextex(V vertex);
    Vertex<V,E> getVertex(int id);
    Vertex<V, E> searchVertex(V data);
    int[] dijkstra(int source);
    int[][] floydWarshall();
    void prim();
    void kruskal();
}
