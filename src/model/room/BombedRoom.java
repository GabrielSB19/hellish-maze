package model.room;

import java.util.LinkedList;
import java.util.Random;

import model.door.Door;

public class BombedRoom extends Room {

    private boolean hasKey;

    public BombedRoom(int id) {
        super(id);
        hasKey = new Random().nextBoolean();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public LinkedList<Door> getDoors() {
        return doors;
    }

    public boolean hasKey() {
        return hasKey;
    }



}
