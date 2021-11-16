package model.door;

public class SilverDoor extends Door {

    public SilverDoor() {
        token = (int) (Math.random() * (3))+1;
    }

    @Override
    public int getToken() {
        return token;
    }
}
