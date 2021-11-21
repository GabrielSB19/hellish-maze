package collection.directedGraph;

import collection.IEdge;
import collection.IVertex;

public class Edge<V,E> implements IEdge<V,E> {
    private E data;
    private Vertex<V, E> source; 
    private Vertex<V, E> destination; 

    public Edge(E data) {
        this.data = data;
    }

    @Override
    public E getData() {
        return data;
    }

    @Override
    public IVertex<V, E> getDestination() {
        return destination;
    }

    @Override
    public IVertex<V, E> getSource() {
        return source;
    }

    public void setSource(Vertex<V, E> source) {
        this.source = source;
    }

    public void setDestination(Vertex<V, E> destination) {
        this.destination = destination;
    }
    
}
