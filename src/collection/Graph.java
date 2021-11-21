package collection;

import java.util.*;

public abstract class Graph<V, E> implements IGraph<V, E> {
    protected Integer[][] adjacencyMatrix;
    protected List<Vertex<V, E>> vertex;

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
    public int[] dijkstra(int start) {

        int[] distance = new int[vertex.size()];
        distance[start] = 0;
        int[] prev = new int[vertex.size()];

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
                if (adjacencyMatrix[u][i] != 0 && adjacencyMatrix[u][i] != null) {
                    int alt = distance[u] + adjacencyMatrix[u][i];

                    if (alt < distance[i]) {
                        distance[i] = alt;
                        prev[i] = u;
                        queue.add(i);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(prev));
        return distance;
    }

    @Override
    public int[][] floydWarshall() {
        return null;
    }

}
