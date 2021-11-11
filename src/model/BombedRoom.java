package model;

import java.util.LinkedList;

public class BombedRoom implements Room {

    private int id;
    private LinkedList<Door> doors;
    private boolean treasure;

    public BombedRoom(int id) {
        this.id = id;
        doors = new LinkedList<>();
        treasure = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public LinkedList<Door> getDoors() {
        return doors;
    }

    @Override
    public boolean hasTreasure() {
        return treasure;
    }

}
