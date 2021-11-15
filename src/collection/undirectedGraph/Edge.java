package collection.undirectedGraph;

import com.sun.xml.internal.bind.v2.runtime.Location;

import collection.IEdge;

public class Edge<V, E> implements IEdge<V,E> {
    private E data;
    private Vertex<V, E> source;
    private Vertex<V, E> destination; 

    public Edge(E data) {
        this.data = data;
    }

    public E getData() {
        return this.data;
    }

    public Vertex<V, E> getSource() {
        return this.source;
    }

    public void setSource(Vertex<V, E> source) {
        this.source = source;
    }

    public Vertex<V, E> getDestination() {
        return this.destination;
    }

    public void setDestination(Vertex<V, E> destination) {
        this.destination = destination;
    }

}
