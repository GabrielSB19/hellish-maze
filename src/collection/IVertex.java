package collection;

import java.util.List;

public interface IVertex<V,E> {
    V getData();
    List<IEdge<V, E>> getEdges();
}
