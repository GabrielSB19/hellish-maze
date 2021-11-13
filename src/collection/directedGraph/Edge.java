package collection.directedGraph;

public class Edge<V,E> {
    private E data;
    private Vertex<V,E> destination;

    public Edge(E data) {
        this.data = data;
    }

    public E getData() {
        return this.data;
    }

    public Vertex<V,E> getDestination() {
        return this.destination;
    }

    public void setDestination(Vertex<V,E> destination) {
        this.destination = destination;
    }
    
}
