package model.room;


public class KeyRoom extends Room {

    private boolean key;

    public KeyRoom(int id) {
        super(id);
        key = true;
    }

    @Override
    public int getId() {
        return id;
    }

    public boolean getKey() {
        return key;
    }

}
