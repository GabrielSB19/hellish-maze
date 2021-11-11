package model;

import model.door.Door;
import model.room.Room;

public interface MazeFactory {
    Room createRoom(int id);
    Door createDoor(Room source,Room destination);
}
