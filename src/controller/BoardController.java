package controller;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import model.Maze;
import model.door.Door;
import model.door.GoldenDoor;
import model.door.SilverDoor;
import model.room.*;
import routes.Route;

public class BoardController {
    @FXML
    private GridPane board;

    @FXML
    private Label lblTokens;

    @FXML
    private ImageView hasKey;

    private MazeController mController;
    private int avatar;

    private final int EASY_V = 9;
    private final int MEDIUM_V = 16;
    private final int HARD_V = 25;

    public BoardController(MazeController mController, int avatar) {
        this.mController = mController;
        this.avatar = avatar;
    }

    public void easyBoard() {
        mController.getMaze().createGraph(EASY_V);
        createRooms(EASY_V, 1);
        createDoors((int) Math.sqrt(EASY_V), 1);
        createBoard(EASY_V, "green");
    }

    public void mediumBoard() {
        mController.getMaze().createGraph(MEDIUM_V);
        createRooms(MEDIUM_V, 2);
        createDoors((int) Math.sqrt(MEDIUM_V), 2);
        createBoard(MEDIUM_V, "yellow");
    }

    public void hardBoard() {
        mController.getMaze().createGraph(HARD_V);
        createRooms(HARD_V, 3);
        createDoors((int) Math.sqrt(HARD_V), 3);
        createBoard(HARD_V, "red");
    }

    private void createRooms(int rooms, int type) {
        for (int i = 0; i < rooms; i++) {
            mController.getMaze().addRoom(i, type);
        }
    }

    private void createDoors(int render, int type) {
        Maze m = mController.getMaze();
        for (int i = 0; i < render * render; i++) {
            if ((i + 1) % render != 0) {
                m.addDoor(m.getGraph().getVertex(i).getData(), m.getGraph().getVertex(i + 1).getData(), type);
            }
        }
        for (int i = 0; i < render * render; i++) {
            if ((double) ((i + 1.0) / render) <= (render - 1)) {
                m.addDoor(m.getGraph().getVertex(i).getData(), m.getGraph().getVertex(i + render).getData(), type);
            }
        }
    }

    private void createBoard(int amount, String color) {
        Maze m = mController.getMaze();
        board.getChildren().clear();
        int rowsAndCols = (int) Math.sqrt(amount);
        int idRoom = 0;
        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {
                GridPane tempGrid = new GridPane();

                Label lblId = new Label(idRoom + "");
                ImageView img = roomImage(m.getGraph().getVertex(idRoom).getData());

                tempGrid.add(lblId, 0, 0);
                tempGrid.add(img, 3, 0);

                for (int k = 0; k < m.getGraph().getVertex(idRoom).getEdges().size(); k++) {
                    Door current = m.getGraph().getVertex(idRoom).getEdges().get(k).getData();
                    Room s = m.getGraph().getVertex(idRoom).getEdges().get(k).getSource().getData();
                    Room d = m.getGraph().getVertex(idRoom).getEdges().get(k).getDestination().getData();

                    int source = (s.getId() == idRoom) ? s.getId() : d.getId();
                    int destination = (d.getId() == idRoom) ? s.getId() : d.getId();
                    int[] pos = getPosition(source, destination, rowsAndCols);

                    ImageView dImg = doorImage(current);
                    Label dToken = new Label(current.getToken() + "");

                    tempGrid.add(dImg, pos[0], pos[1]);
                    tempGrid.add(dToken, pos[2], pos[3]);
                }
                tempGrid.setStyle(
                        "-fx-border-color:" + color + "; -fx-border-radius: 20px; -fx-background-radius: 20px;");
                boxStyle(tempGrid, 0, tempGrid.getChildren().size());
                board.add(tempGrid, j, i);
                idRoom++;
            }
        }
        boxStyle(board, 0, board.getChildren().size());
        board.setHgap(10);
        board.setVgap(10);
        board.setPadding(new Insets(10, 10, 10, 10));
    }

    private int[] getPosition(int s, int d, int props) {
        int[] pos = new int[4];
        if (s - d == 1) {
            pos[0] = 0;
            pos[1] = 1;
            pos[2] = 0;
            pos[3] = 2;
        } else if (s - d == -1) {
            pos[0] = 3;
            pos[1] = 1;
            pos[2] = 3;
            pos[3] = 2;
        } else if (s - d == props) {
            pos[0] = 1;
            pos[1] = 0;
            pos[2] = 2;
            pos[3] = 0;
        } else {
            pos[0] = 1;
            pos[1] = 3;
            pos[2] = 2;
            pos[3] = 3;
        }
        return pos;
    }

    private void renderImg(ImageView img) {
        img.setFitHeight(20);
        img.setFitWidth(20);
    }

    private ImageView roomImage(Room r) {
        ImageView img = null;
        if (r instanceof KeyRoom) {
            img = new ImageView(new Image(Route.KEY.getRoute()));
        } else if (r instanceof EnchantedRoom) {
            img = new ImageView(new Image(Route.ENCHANTED.getRoute()));
        } else {
            TraditionalRoom tRoom = (TraditionalRoom) r;
            if (tRoom.hasTreasure()) {
                img = new ImageView(new Image(Route.TREASURE.getRoute()));
            } else {
                img = new ImageView(new Image(Route.TRADITIONAL.getRoute()));
            }
        }
        renderImg(img);
        return img;
    }

    private ImageView doorImage(Door d) {
        ImageView img = null;
        if (d instanceof SilverDoor) {
            img = new ImageView(new Image(Route.SILVER.getRoute()));
        } else if (d instanceof GoldenDoor) {
            img = new ImageView(new Image(Route.GOLD.getRoute()));
        } else {
            img = new ImageView(new Image(Route.INFERNAL.getRoute()));
        }
        renderImg(img);
        return img;
    }

    private void boxStyle(GridPane gP, int n, int i) {
        if (n < i) {
            GridPane.setFillHeight(gP.getChildren().get(n), true);
            GridPane.setFillWidth(gP.getChildren().get(n), true);
            GridPane.setHgrow(gP.getChildren().get(n), Priority.ALWAYS);
            GridPane.setVgrow(gP.getChildren().get(n), Priority.ALWAYS);
            GridPane.setHalignment(gP.getChildren().get(n), HPos.CENTER);
            GridPane.setValignment(gP.getChildren().get(n), VPos.CENTER);
            n++;
            boxStyle(gP, n, i);
        }
    }

    @FXML
    public void movement(KeyEvent event) {
        switch (event.getCode()) {
        case UP:
            System.out.println("up");
            break;
        case DOWN:
            System.out.println("down");
            break;
        case RIGHT:
            System.out.println("r");
            break;
        case LEFT:
            System.out.println("l");
            break;
        default:
            break;
        }

    }
}
