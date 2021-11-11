package model;

import model.door.Door;
import model.door.InfernalDoor;
import model.room.BombedRoom;
import model.room.Room;

public class MediumFactory implements MazeFactory {

    @Override
    public Room createRoom(int id) {
        return new BombedRoom(id);
    }

    @Override
    public Door createDoor(Room source, Room destination) {
        return new InfernalDoor(source, destination);
    }

}
