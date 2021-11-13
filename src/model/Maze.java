package model;

public class Maze {
    private MazeFactory[] factories;
    private final int EASY_V = 9,EASY_E = 12;
    private final int MEDIUM_V = 16,MEDIUM_E = 24;
    private final int HARD_V = 25,HARD_E = 40;

    public Maze(){
        factories = new MazeFactory[3];
        initfactories();
    }

    private void initfactories(){
       factories[0] = new EasyFactory();
       factories[1] = new MediumFactory();
       factories[2] = new HardFactory();
    }

    public void easy(){
      for (int i = 0; i < EASY_V; i++) {
          for (int j = 0; j < EASY_V; j++) {
              
          }
      }
    }

    public void medium(){

    }

    public void hard(){

    }

    private void createRooms(){

    }

    private void createDoors(){
        
    }
}
