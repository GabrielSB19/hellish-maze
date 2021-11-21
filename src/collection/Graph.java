package collection;

import java.util.*;

public abstract class Graph<V, E> implements IGraph<V, E> {
    protected Integer[][] adjacencyMatrix;
    protected List<Vertex<V, E>> vertex;
    protected int[] prev;

    @Override
    public abstract void addEdge(E edge, V source, V destination);

    @Override
    public void addVertex(V vertex) {
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
    public void fillMatrix(int i, int j, int token) {
        adjacencyMatrix[i][j] = token;
    }

    protected void initMatrix() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                }
            }
        }
    }

    @Override
    public int dijkstra(int start) {

        int[] distance = new int[vertex.size()];
        distance[start] = 0;

        Queue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < vertex.size(); i++) {
            if (i != start) {
                distance[i] = Integer.MAX_VALUE;
            }
            prev[i] = -1;

            queue.add(distance[start]);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < vertex.size(); i++) {
                if (adjacencyMatrix[u][i] != null && adjacencyMatrix[u][i] != 0) {
                    int alt = distance[u] + adjacencyMatrix[u][i];

                    if (alt < distance[i]) {
                        distance[i] = alt;
                        prev[i] = u;
                        queue.add(i);
                    }
                }
            }
        }

        return distance[vertex.size() - 1];
    }

    @Override
    public List<Integer> getPath() {
        List<Integer> path = new ArrayList<>();
        int c = 0;
        for (int i = prev.length - 1; i >= 0; i--) {
            if (prev[i] != 0) {
                if (c == 0) {
                    path.add(i);
                    path.add(prev[i]);
                    c = prev[i];
                } else if (c == i) {
                    path.add(prev[i]);
                    c = prev[i];
                }
            }

        }
        Collections.reverse(path);
        return path;
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
