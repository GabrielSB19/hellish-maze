package model;

public class Player {
    private boolean isWinner;
    private int idRoom;
    private int tokens;
    private boolean hasKey;

    public Player() {
        isWinner = false;
        idRoom = 0;
        tokens = 0;
        hasKey = false;
    }

    public boolean isIsWinner() {
        return this.isWinner;
    }

    public boolean getIsWinner() {
        return this.isWinner;
    }

    public void setIsWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }

    public int getIdRoom() {
        return this.idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getTokens() {
        return this.tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public boolean isHasKey() {
        return this.hasKey;
    }

    public boolean getHasKey() {
        return this.hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

}
