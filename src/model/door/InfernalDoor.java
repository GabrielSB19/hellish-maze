package model.door;

import model.room.Room;

public class InfernalDoor extends Door {

    public InfernalDoor(Room source, Room destination) {
        super(source, destination);
        token = (int) ((Math.random() * (5 - 2 + 1) + 2));
    }

    @Override
    public int getToken() {
        return token;
    }

    @Override
    public Room getSource() {
        return source;
    }

    @Override
    public Room getDestination() {
        return destination;
    }
}
