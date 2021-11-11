package model.door;

import model.room.Room;

public class SilverDoor extends Door {

    public SilverDoor(Room source, Room destination) {
        super(source, destination);
        token = 1;
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
