package collection;

import java.util.ArrayList;

public class UndirectedGraph<V, E> extends Graph<V, E> {

    public UndirectedGraph(int vertex) {
        adjacencyMatrix = new Integer[vertex][vertex];
        this.vertex = new ArrayList<>();
        prev = new int[vertex];
        initMatrix();
    }

    @Override
    public void addEdge(E edge, V source, V destination) {
        Edge<V, E> newEdge = new Edge<V, E>(edge);
        newEdge.setSource(searchVertex(source));
        newEdge.setDestination(searchVertex(destination));
        searchVertex(source).addEdge(newEdge);
        searchVertex(destination).addEdge(newEdge);
    }

}
