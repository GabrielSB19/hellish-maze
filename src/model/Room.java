package model;

import java.util.LinkedList;

public interface Room {
    int getId();
    LinkedList<Door> getDoors();
    boolean hasTreasure();
}
