package model.door;

public class InfernalDoor extends Door {

    public InfernalDoor() {
        token = (int) ((Math.random() * (8 - 4 + 1) + 4));
    }

    @Override
    public int getToken() {
        return token;
    }

}
