package model;

public interface MazeFactory {
    Room createRoom(int id);
    Door createDoor(Room source,Room destination);
}
