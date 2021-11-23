package collection;

import java.util.LinkedList;

public class DirectedGraph<V, E> extends Graph<V, E> {

    public DirectedGraph(int vertex) {
        adjacencyMatrix = new Integer[vertex][vertex];
        this.vertex = new LinkedList<>();
        prev = new int[vertex];
        initMatrix();
    }

    @Override
    public void addEdge(E edge, V source, V destination) {
        Edge<V, E> newEdge = new Edge<V, E>(edge);
        newEdge.setSource(searchVertex(source));
        newEdge.setDestination(searchVertex(destination));
        searchVertex(source).addEdge(newEdge);
    }

    @Override
    public void fillMatrix(int i, int j, int token) {
        adjacencyMatrix[i][j] = token;
    }

}
