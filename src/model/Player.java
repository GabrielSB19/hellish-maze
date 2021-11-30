package model;

public class Player {
    private int avatar;
    private boolean winner;
    private int idRoom;
    private int tokens;
    private boolean hasKey;

    public Player(int avatar) {
        this.avatar = avatar;
        winner = false;
        idRoom = 0;
        tokens = 0;
        hasKey = false;
    }

    public int getAvatar() {
        return this.avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public boolean isWinner() {
        return this.winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public synchronized int getIdRoom() {
        return this.idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public synchronized int getTokens() {
        return this.tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public void decreaseTokens(int tokens) {
            this.tokens -= tokens;
    }

    public boolean isHasKey() {
        return this.hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

}
