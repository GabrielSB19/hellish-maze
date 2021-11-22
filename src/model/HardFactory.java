package model;

import model.door.Door;
import model.door.InfernalDoor;
import model.room.*;

public class HardFactory implements MazeFactory {

    @Override
    public Room createRoom(int id) {
        return new EnchantedRoom(id);
    }

    @Override
    public Door createDoor() {
        return new InfernalDoor();
    }
}
