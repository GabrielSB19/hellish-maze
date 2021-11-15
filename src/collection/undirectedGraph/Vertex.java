package collection.undirectedGraph;

import java.util.ArrayList;
import java.util.List;

import collection.IEdge;
import collection.IVertex;

public class Vertex<V, E> implements IVertex<V,E>{
    private V data;
    private List<IEdge<V, E>> edges;

    public Vertex(V data) {
        this.data = data;
        edges = new ArrayList<>();
    }

    public V getData() {
        return this.data;
    }

    public List<IEdge<V, E>> getEdges() {
        return this.edges;
    }

    public void addEdge(Edge<V, E> edge) {
        edges.add(edge);
    }

}
