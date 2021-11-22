package model.door;

public class GoldenDoor extends Door {

    public GoldenDoor() {
        token = (int) ((Math.random() * (6 - 4 + 1) + 4));;
    }

    @Override
    public int getToken() {
        return token;
    }
}
