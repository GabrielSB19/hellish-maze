package model;

public class MediumFactory implements MazeFactory {

    @Override
    public Room createRoom(int id) {
        return new BombedRoom(id);
    }

    @Override
    public Door createDoor(Room source, Room destination) {
        return new GoldenDoor(source, destination);
    }

}
