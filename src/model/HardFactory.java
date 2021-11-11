package model;

public class HardFactory implements MazeFactory {

    @Override
    public Room createRoom(int id) {
        return null;
    }

    @Override
    public Door createDoor(Room source,Room destination) {
        return null;
    }
}
