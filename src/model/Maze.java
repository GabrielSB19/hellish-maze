package model;

public class Maze {
    private MazeFactory[] factories;

    public Maze(){
        factories = new MazeFactory[3];
        initfactories();
    }

    private void initfactories(){
       factories[0] = new EasyFactory();
       factories[1] = new MediumFactory();
       factories[2] = new HardFactory();
    }
}
