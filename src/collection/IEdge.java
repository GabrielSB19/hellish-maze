package collection;

public interface IEdge<V,E> {
    E getData();
    IVertex<V, E> getDestination();
    IVertex<V, E> getSource();
}
