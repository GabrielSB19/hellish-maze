package collection.directedGraph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<V, E> {
    private V data;
    private List<Edge<V, E>> edges;

    public Vertex(V data) {
        this.data = data;
        edges = new ArrayList<>();
    }

    public V getData() {
        return this.data;
    }

    public List<Edge<V, E>> getEdges() {
        return this.edges;
    }

    public void addEdge(Edge<V, E> edge) {
        edges.add(edge);
    }

}
