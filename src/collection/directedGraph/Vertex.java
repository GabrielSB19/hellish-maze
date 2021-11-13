package collection.directedGraph;

import java.util.LinkedList;

public class Vertex<V, E> {
    private V data;
    private LinkedList<Edge<V, E>> edges;

    public Vertex(V data) {
        this.data = data;
    }

    public V getData() {
        return this.data;
    }

    public LinkedList<Edge<V, E>> getEdges() {
        return this.edges;
    }

    public void setEdges(LinkedList<Edge<V, E>> edges) {
        this.edges = edges;
    }

}
