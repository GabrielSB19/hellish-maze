package model;

import collection.IGraph;
import collection.undirectedGraph.UndirectedGraph;
import model.door.Door;
import model.room.Room;

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

    public void createGraph(int amount) {
        graph = new UndirectedGraph<>(amount);
    }

    public void addRoom(int id) {
        int roomType = (int) ((Math.random() * 3));
        graph.addVextex(factories[roomType].createRoom(id));
    }

    public void addDoor(Room source, Room destination) {
        int roomType = (int) ((Math.random() * 3));
        graph.addEdge(factories[roomType].createDoor(), source, destination);
    }

    public IGraph<Room,Door> getGraph() {
        return this.graph;
    } 

}
