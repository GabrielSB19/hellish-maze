package model.door;

import model.room.Room;

public class GoldenDoor extends Door {

    public GoldenDoor(Room source, Room destination) {
        super(source, destination);
        token = -1 * (int) ((Math.random() * (10 - 5 + 1) + 5));
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
