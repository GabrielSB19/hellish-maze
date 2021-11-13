package collection.directedGraph;

import java.util.LinkedList;

public class Vertex<V,E> {
    private V data;
    private LinkedList<Edge<V,E>> edges;
}
