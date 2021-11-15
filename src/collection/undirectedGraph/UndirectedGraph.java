package collection.undirectedGraph;

import java.util.ArrayList;
import java.util.List;

import collection.IGraph;
import collection.IVertex;

public class UndirectedGraph<V, E> implements IGraph<V, E> {
    private int[][] adjacencyMatrix;
    private List<Vertex<V, E>> vertex;

    public UndirectedGraph(int vertex) {
        adjacencyMatrix = new int[vertex][vertex];
        this.vertex = new ArrayList<>();
    }

    @Override
    public void addVextex(V vertex) {
        Vertex<V, E> v = new Vertex<V, E>(vertex);
        this.vertex.add(v);
    }

    @Override
    public void addEdge(E edge, V source, V destination) {
        Edge<V,E> newEdge = new Edge<V,E>(edge);
        newEdge.setSource(searchVertex(source));
        newEdge.setDestination(searchVertex(destination));
        searchVertex(source).addEdge(newEdge);
        searchVertex(destination).addEdge(newEdge);
    }

    private Vertex<V,E> searchVertex(V data){
        Vertex<V,E> wanted = null;
        for (Vertex<V,E> v : vertex) {
            if(v.getData().equals(data)){
                wanted = v;
            }
        }
        return wanted;
    }

    @Override
    public int[] dijkstra(int source) {
        return null;
    }

    @Override
    public int[][] floydWarshall() {
        return null;
    }

    @Override
    public IVertex<V,E> getVertex(int id) {
        return vertex.get(id);
    }

}
