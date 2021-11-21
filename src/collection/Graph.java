package collection;

import java.util.List;

public abstract class Graph<V,E> implements IGraph<V, E>{
    protected int[][] adjacencyMatrix;
    protected List<Vertex<V, E>> vertex;

    @Override
    public abstract void addEdge(E edge, V source, V destination);

    @Override
    public void addVextex(V vertex) {
        Vertex<V, E> v = new Vertex<V, E>(vertex);
        this.vertex.add(v);
    }

    @Override
    public Vertex<V, E> getVertex(int id) {
        return vertex.get(id);
    }

    @Override
    public Vertex<V, E> searchVertex(V data) {
        Vertex<V, E> wanted = null;
        for (Vertex<V, E> v : vertex) {
            if (v.getData().equals(data)) {
                wanted = v;
            }
        }
        return wanted;
    }

    @Override
    public void fillMatrix(int i, int j, int token){
        adjacencyMatrix[i][j] = token;
    }

    private void initMatrix(){
        for (int i = 0; i<adjacencyMatrix.length; i++){
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if(i == j){
                    adjacencyMatrix[i][j] = 0;
                }
            }
        }
    }

    @Override
    public int[] dijkstra(int source) {
        return null;
    }

    @Override
    public int[][] floydWarshall() {
        return null;
    }
    
}
