package collection;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
        int numVertex = adjacencyMatrix.length;
        int INF = Integer.MAX_VALUE;
        int [][] path = new int[numVertex][numVertex];
        int [][] dist = new int[numVertex][numVertex];

        for (int i = 0; i < numVertex; i++) {
            for (int j = 0; j < numVertex; j++) {
                if(adjacencyMatrix[i][j] != 0){
                    dist[i][j] = adjacencyMatrix[i][j];
                } else {
                    dist[i][j] = INF;
                }
                if(i == j){
                    dist[i][j] = 0;
                }
                path[i][j] = j;
            }
        }
        for (int k = 0; k < numVertex; k++) {
            for (int j = 0; j < numVertex; j++) {
                for (int i = 0; i < numVertex; i++) {
                    int tmp = (dist[i][k] == INF || dist[k][j] == INF) ? INF : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp){
                        dist[i][j] = tmp;
                        path[i][j] = path[i][k];
                    }
                }

            }
        }
        System.out.println("Floyd Path: \n");
        for (int i = 0; i < numVertex; i++) {
            for (int j = 0; j < numVertex; j++) {
                System.out.printf("%2d ", path[i][j]);
            }
            System.out.println("\n");
        }
        System.out.println("Floyd Dist: \n");
        for (int i = 0; i < numVertex; i++) {
            for (int j = 0; j < numVertex; j++) {
                System.out.printf("%2d ", dist[i][j]);
            }
            System.out.println("\n");
        }
        return dist;
    }
    
}
