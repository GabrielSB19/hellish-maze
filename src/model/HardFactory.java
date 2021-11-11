package model;

import model.door.Door;
import model.door.GoldenDoor;
import model.room.*;

public class HardFactory implements MazeFactory {

    @Override
    public Room createRoom(int id) {
        return null;
    }

    @Override
    public Door createDoor(Room source,Room destination) {
        return new GoldenDoor(source, destination);
    }
}
