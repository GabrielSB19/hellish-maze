package model.door;

public class GoldenDoor extends Door {

    public GoldenDoor() {
        token = -1;
    }

    @Override
    public int getToken() {
        return token;
    }
}
