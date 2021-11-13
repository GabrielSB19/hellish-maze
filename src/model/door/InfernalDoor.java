package model.door;

public class InfernalDoor extends Door {

    public InfernalDoor() {
        token = (int) ((Math.random() * (5 - 2 + 1) + 2));
    }

    @Override
    public int getToken() {
        return token;
    }
}
