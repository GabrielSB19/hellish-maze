package model;

public class Player {
    private boolean winner;
    private int idRoom;
    private int tokens;
    private boolean hasKey;

    public Player() {
        winner = false;
        idRoom = 0;
        tokens = 0;
        hasKey = false;
    }

    public boolean isWinner() {
        return this.winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
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

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

}
