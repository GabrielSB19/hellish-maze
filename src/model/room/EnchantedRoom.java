package model.room;

public class EnchantedRoom extends Room {
    private int clue;

    public EnchantedRoom(int id) {
        super(id);
        clue = 0;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getClue() {
        return clue;
    }

    public void setClue(int clue) {
        this.clue = clue;
    }
}
