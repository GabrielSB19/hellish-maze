package model;

import model.door.Door;
import model.door.SilverDoor;
import model.room.Room;
import model.room.TraditionalRoom;

public class EasyFactory implements MazeFactory {

    @Override
    public Room createRoom(int id) {
        return new TraditionalRoom(id);
    }

    @Override
    public Door createDoor(Room source, Room destination) {
        return new SilverDoor(source, destination);
    }
    
}
