package model.door;

public class GoldenDoor extends Door {

    public GoldenDoor() {
        token = 0;
    }

    @Override
    public int getToken() {
        return token;
    }
}
