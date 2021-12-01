package model;

import collection.Graph;
import collection.UndirectedGraph;
import model.door.Door;
import model.door.GoldenDoor;
import model.door.InfernalDoor;
import model.door.SilverDoor;
import model.room.EnchantedRoom;
import model.room.KeyRoom;
import model.room.Room;
import model.room.TraditionalRoom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    public void setUpScenary1(){}

    @Test
    void createGraph() {
        setUpScenary1();
        Graph<Room, Door> graph = new UndirectedGraph<>(15);
        assertNotNull(graph);
    }

    @Test
    void addRoom() {
        setUpScenary1();
        Room room1 = new TraditionalRoom(0);
        Room room2 = new KeyRoom(1);
        Room room3 = new EnchantedRoom(2);

        assertNotNull(room1);
        assertNotNull(room2);
        assertNotNull(room3);
    }

    @Test
    void addDoor() {
        setUpScenary1();
        Door door1 = new SilverDoor();
        Door door2 = new GoldenDoor();
        Door door3 = new InfernalDoor();

        assertNotNull(door1);
        assertNotNull(door2);
        assertNotNull(door3);
    }

    @Test
    void setTreasure() {
        setUpScenary1();
        TraditionalRoom room1 = new TraditionalRoom(2);
        room1.setTreasure(true);

        assertTrue(room1.hasTreasure());
    }
}