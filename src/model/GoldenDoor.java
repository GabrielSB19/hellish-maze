package model;

public class GoldenDoor implements Door {
    private int energy;
    private Room source;
    private Room destination;

    public GoldenDoor(Room source, Room destination) {
        this.source = source;
        this.destination = destination;
        energy = (int) (Math.random() * (10 - 5 + 1) + 5);
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public Room getSource() {
        return source;
    }

    @Override
    public Room getDestination() {
        return destination;
    }

}
