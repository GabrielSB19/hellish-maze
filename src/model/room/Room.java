package model.room;

public abstract class Room {
    protected int id;

    protected Room(int id) {
        this.id = id;
    }

    abstract int getId();

}
