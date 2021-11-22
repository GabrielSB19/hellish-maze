package model;

import model.door.Door;
import model.door.GoldenDoor;
import model.room.KeyRoom;
import model.room.Room;

public class MediumFactory implements MazeFactory {

    @Override
    public Room createRoom(int id) {
        return new KeyRoom(id);
    }

    @Override
    public Door createDoor() {
        return new GoldenDoor();
    }

}
