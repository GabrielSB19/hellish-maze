package model.door;

import model.room.Room;

public abstract class Door {
    protected int token;
    protected Room source;
    protected Room destination;

    protected Door(Room source, Room destination){
        this.source = source;
        this.destination = destination;
    }

    abstract int getToken();

    abstract Room getSource();

    abstract Room getDestination();
}
