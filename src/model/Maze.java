package model;

import collection.DirectedGraph;
import collection.IGraph;
import collection.UndirectedGraph;
import model.door.Door;
import model.room.Room;
import model.room.TraditionalRoom;

public class Maze {
    private MazeFactory[] factories;
    private IGraph<Room, Door> graph;

    public Maze() {
        factories = new MazeFactory[3];
        initfactories();
    }

    private void initfactories() {
        factories[0] = new EasyFactory();
        factories[1] = new MediumFactory();
        factories[2] = new HardFactory();
    }

    public void createGraph(int amount, boolean type) {
        if (type) {
            graph = new DirectedGraph<>(amount);
        } else {
            graph = new UndirectedGraph<>(amount);
        }
    }

    public void addRoom(int id, int type) {
        int roomType = (int) ((Math.random() * type));
        graph.addVertex(factories[roomType].createRoom(id));
    }

    public void addDoor(Room source, Room destination, int type) {
        int roomType = (int) ((Math.random() * type));
        Door newDoor = factories[roomType].createDoor();
        graph.addEdge(newDoor, source, destination);
        graph.fillMatrix(source.getId(), destination.getId(), newDoor.getToken());
    }

    public void setTreasure(int id) {
        TraditionalRoom tRoom = (TraditionalRoom) graph.getVertex(id).getData();
        tRoom.setTreasure(true);
    }

    public Player newPlayer(int avatar) {
        return new Player(avatar);
    }

    public IGraph<Room, Door> getGraph() {
        return this.graph;
    }

<<<<<<< HEAD
    public void test(){
        graph.floydWarshall();
    }
=======
    public int minimumPath(int start) {
        return graph.dijkstra(start);

    }

>>>>>>> 646835abcbc3a5b8d05877b4dce85e1fe3d863a7
}
