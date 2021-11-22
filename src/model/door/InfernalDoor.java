package model.door;

public class InfernalDoor extends Door {

    public InfernalDoor() {
        token = (int) ((Math.random() * (9 - 6 + 1) + 6));
    }

    @Override
    public int getToken() {
        return token;
    }

}
