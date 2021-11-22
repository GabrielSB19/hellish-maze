package collection;

public interface IGraph<V, E> {
    void addEdge(E edge, V source, V destination);

    void addVertex(V vertex);

    Vertex<V, E> getVertex(int id);

    Vertex<V, E> searchVertex(V data);

    void fillMatrix(int i, int j, int token);

    int dijkstra(int source);

    int[][] floydWarshall();

    String getPath();
}
