package collection;

public class Edge<V,E> {
    private E data;
    private Vertex<V, E> source; 
    private Vertex<V, E> destination; 

    public Edge(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public Vertex<V, E> getDestination() {
        return destination;
    }

    public Vertex<V, E> getSource() {
        return source;
    }

    public void setSource(Vertex<V, E> source) {
        this.source = source;
    }

    public void setDestination(Vertex<V, E> destination) {
        this.destination = destination;
    }
    
}
