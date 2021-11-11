package model.room;

import java.util.LinkedList;

import model.door.Door;

public class TraditionalRoom extends Room {

    private boolean hasTreasure;

    public TraditionalRoom(int id) {
        super(id);
        hasTreasure = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public LinkedList<Door> getDoors() {
        return doors;
    }

    public boolean hasTreasure() {
        return hasTreasure;
    }

    public void setTreasure(boolean treasure){
        hasTreasure = treasure;
    }

}
