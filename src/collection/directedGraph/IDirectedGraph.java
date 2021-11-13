package collection.directedGraph;

public interface IDirectedGraph<V,E> {
    void addEdge(E edge,V vertex);
    void addVextex(V vertex);
    void createGraph(int vertex);
}
