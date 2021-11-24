package collection;

import model.door.Door;
import model.door.SilverDoor;
import model.room.Room;
import model.room.TraditionalRoom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    public DirectedGraph<Room, Door> setUpScenary1(){
        return new DirectedGraph<>(3);

    }

    public UndirectedGraph<Room, Door> setUpScenary2(){
        return new UndirectedGraph<>(3);
    }

    public UndirectedGraph<Room, Door> setUpScenary3(){
        /*
        Only declare the method but we do not initialize it
         */
        return new UndirectedGraph<>(3);
    }

    public void initGraph(Graph<Room, Door> graph){
        TraditionalRoom R1 = new TraditionalRoom(0);
        TraditionalRoom R2 = new TraditionalRoom(1);
        TraditionalRoom R3 = new TraditionalRoom(2);
        SilverDoor D1 = new SilverDoor();
        SilverDoor D2 = new SilverDoor();
        graph.addVertex(R1);
        graph.addVertex(R2);
        graph.addVertex(R3);
        graph.addEdge(D1, R1, R2);
        graph.addEdge(D2, R2, R3);
        graph.fillMatrix(R1.getId(), R2.getId(), D1.getToken());
        graph.fillMatrix(R2.getId(), R3.getId(), D2.getToken());
    }

    @Test
    void addEdgeD() {
        DirectedGraph<Room, Door> graph = setUpScenary1();
        TraditionalRoom R1 = new TraditionalRoom(0);
        TraditionalRoom R2 = new TraditionalRoom(1);
        SilverDoor D1 = new SilverDoor();
        graph.addVertex(R1);
        graph.addVertex(R2);
        graph.addEdge(D1, R1, R2);

        assertNotNull(graph.getVertex(0).getEdges().get(0));
    }

    @Test
    void addVertexD() {
        DirectedGraph<Room, Door> graph = setUpScenary1();
        TraditionalRoom R1 = new TraditionalRoom(0);
        graph.addVertex(R1);

        assertNotNull(graph.getVertex(0));
    }

    @Test
    void getVertexD() {
        DirectedGraph<Room, Door> graph = setUpScenary1();
        initGraph(graph);
        assertNotNull(graph.getVertex(0));
    }

    @Test
    void searchVertexD() {
        DirectedGraph<Room, Door> graph = setUpScenary1();
        initGraph(graph);
        Vertex<Room, Door> test = graph.searchVertex(graph.getVertex(2).getData());
        assertEquals(2, test.getData().getId());
    }

    @Test
    void fillMatrixD() {
        DirectedGraph<Room, Door> graph = setUpScenary1();
        initGraph(graph);
        /*
        The fill matrix method was realized in the initGraph method.
         */
        int weight = graph.getVertex(0).getEdges().get(0).getData().getToken();

        assertNotNull(graph.adjacencyMatrix);
        assertEquals(weight, graph.adjacencyMatrix[0][1]);
    }

    @Test
    void initMatrixD() {
        DirectedGraph<Room, Door> graph = setUpScenary1();
        initGraph(graph);
        graph.initMatrix();
        assertEquals(0, graph.adjacencyMatrix[0][0]);
        assertEquals(0, graph.adjacencyMatrix[1][1]);
    }

    @Test
    void dijkstraD() {
       DirectedGraph<Room, Door> graph = setUpScenary1();
       initGraph(graph);
       int dist = graph.dijkstra(0);
       int token1 = (graph.getVertex(0).getEdges().get(0).getData().getToken());
       int token2 = (graph.getVertex(1).getEdges().get(0).getData().getToken());
       int tokens = token1+token2;
       assertEquals(tokens, dist);
    }

    @Test
    void getPathD() {
        DirectedGraph<Room, Door> graph = setUpScenary1();
        initGraph(graph);
        graph.dijkstra(0);
        String path= "["+graph.getVertex(1).getData().getId()+", "+graph.getVertex(2).getData().getId()+"]";
        assertEquals(path, graph.getPath());
    }

    @Test
    void floydWarshallD() {
        DirectedGraph<Room, Door> graph = setUpScenary1();
        initGraph(graph);

        assertEquals(graph.getVertex(2).getData().getId(), graph.floydWarshall(1));
    }

    @Test
    void addEdgeUD() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        TraditionalRoom R1 = new TraditionalRoom(0);
        TraditionalRoom R2 = new TraditionalRoom(1);
        SilverDoor D1 = new SilverDoor();
        graph.addVertex(R1);
        graph.addVertex(R2);
        graph.addEdge(D1, R1, R2);

        assertNotNull(graph.getVertex(0).getEdges().get(0));
    }

    @Test
    void addVertexUD() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        TraditionalRoom R1 = new TraditionalRoom(0);
        graph.addVertex(R1);

        assertNotNull(graph.getVertex(0));
    }

    @Test
    void getVertexUD() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        initGraph(graph);
        assertNotNull(graph.getVertex(0));
    }

    @Test
    void searchVertexUD() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        initGraph(graph);
        Vertex<Room, Door> test = graph.searchVertex(graph.getVertex(2).getData());
        assertEquals(2, test.getData().getId());
    }

    @Test
    void fillMatrixUD() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        initGraph(graph);
        /*
        The fill matrix method was realized in the initGraph method.
         */
        int weight = graph.getVertex(0).getEdges().get(0).getData().getToken();

        assertNotNull(graph.adjacencyMatrix);
        assertEquals(weight, graph.adjacencyMatrix[0][1]);
    }

    @Test
    void initMatrixUD() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        initGraph(graph);
        graph.initMatrix();
        assertEquals(0, graph.adjacencyMatrix[0][0]);
        assertEquals(0, graph.adjacencyMatrix[1][1]);
    }

    @Test
    void dijkstraUD() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        initGraph(graph);
        int dist = graph.dijkstra(0);
        int token1 = (graph.getVertex(0).getEdges().get(0).getData().getToken());
        int token2 = (graph.getVertex(1).getEdges().get(1).getData().getToken());
        int tokens = token1+token2;
        assertEquals(tokens, dist);
    }

    @Test
    void getPathUD() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        initGraph(graph);
        graph.dijkstra(0);
        String path= "["+graph.getVertex(1).getData().getId()+", "+graph.getVertex(2).getData().getId()+"]";
        assertEquals(path, graph.getPath());
    }

    @Test
    void floydWarshallUD() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        initGraph(graph);

        assertEquals(graph.getVertex(2).getData().getId(), graph.floydWarshall(1));
    }

    @Test
    void addEdgeEm() {
        UndirectedGraph<Room, Door> graph = setUpScenary3();
        TraditionalRoom R1 = new TraditionalRoom(0);
        TraditionalRoom R2 = new TraditionalRoom(1);
        SilverDoor D1 = new SilverDoor();
        graph.addVertex(R1);
        graph.addVertex(R2);
        graph.addEdge(D1, R1, R2);

        assertNotNull(graph.getVertex(0).getEdges().get(0));
    }

    @Test
    void addVertexEm() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        TraditionalRoom R1 = new TraditionalRoom(0);
        graph.addVertex(R1);

        assertNotNull(graph.getVertex(0));
    }

    @Test
    void getVertexEm() {
        UndirectedGraph<Room, Door> graph = setUpScenary2();
        initGraph(graph);
        assertNotNull(graph.getVertex(0));
    }

    @Test
    void searchVertexEm() {
        UndirectedGraph<Room, Door> graph = setUpScenary3();
        Vertex<Room, Door> test = graph.searchVertex(new TraditionalRoom(0));
        assertNull(test);
    }

    @Test
    void dijkstraEm() {
        UndirectedGraph<Room, Door> graph = setUpScenary3();
        graph.addVertex(new TraditionalRoom(0));
        assertEquals(0, graph.dijkstra(0));
    }

    @Test
    void getPathEm() {
        UndirectedGraph<Room, Door> graph = setUpScenary3();
        graph.addVertex(new TraditionalRoom(0));
        graph.dijkstra(0);
        System.out.println(graph.getPath());
        /*
        When no paths are available, the algorithm will show [-1, 0].
         */
        assertEquals("[-1, 0]", graph.getPath());
    }

    @Test
    void floydWarshallEm() {
        UndirectedGraph<Room, Door> graph = setUpScenary3();
        graph.addVertex(new TraditionalRoom(0));
        /*
        The shortest way is the same
         */
        assertNotNull(graph.getPath());

    }
}