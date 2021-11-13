package model.room;

import java.util.Random;

public class KeyRoom extends Room {

    private boolean hasKey;

    public KeyRoom(int id) {
        super(id);
        hasKey = new Random().nextBoolean();
    }

    @Override
    public int getId() {
        return id;
    }

    public boolean hasKey() {
        return hasKey;
    }

}
