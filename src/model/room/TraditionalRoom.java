package model.room;

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

    public boolean hasTreasure() {
        return hasTreasure;
    }

    public void setTreasure(boolean treasure) {
        hasTreasure = treasure;
    }

}
