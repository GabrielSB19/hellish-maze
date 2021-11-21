package collection.directedGraph;

import java.util.LinkedList;
import java.util.List;

import collection.IGraph;
import collection.IVertex;

public class DirectedGraph<V,E> implements IGraph<V,E> {
    private int[][] adjacencyMatrix;
    private List<Vertex<V, E>> vertex;

    public DirectedGraph(int vertex) {
        adjacencyMatrix = new int[vertex][vertex];
        this.vertex = new LinkedList<>();
    }
    
    @Override
    public void addEdge(E edge, V source, V destination) {
        Edge<V,E> newEdge = new Edge<V,E>(edge);
        newEdge.setSource(searchVertex(source));
        newEdge.setDestination(searchVertex(destination));
        searchVertex(source).addEdge(newEdge);
    }

    @Override
    public void addVextex(V vertex) {
        Vertex<V, E> v = new Vertex<V, E>(vertex);
        this.vertex.add(v);
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
    public IVertex<V, E> getVertex(int id) {
        return vertex.get(id);
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
    public void prim() {
        
    }

    @Override
    public void kruskal() {
        
    }
    
}
