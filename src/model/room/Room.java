package model.room;

import java.util.LinkedList;

import model.door.Door;

public abstract class Room {
    protected int id;
    protected LinkedList<Door> doors;

    protected Room(int id) {
        this.id = id;
        doors = new LinkedList<>();
    }

    abstract int getId();

    abstract LinkedList<Door> getDoors();
    
}
