package controller;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import model.Maze;
import model.room.*;
import routes.Route;

public class BoardController {
    @FXML
    private GridPane board;

    @FXML
    private Label lblTokens;

    @FXML
    private ImageView hasKey;

    @FXML
    private ImageView notKey;
    private MazeController mController;

    private final int EASY_V = 9, EASY_E = 12;
    private final int MEDIUM_V = 16, MEDIUM_E = 24;
    private final int HARD_V = 25, HARD_E = 40;

    public BoardController(MazeController mController) {
        this.mController = mController;
    }

    public void easyBoard() {
        mController.getMaze().createGraph(EASY_V);
        createRooms(EASY_V);
        createDoors(EASY_E, (int) Math.sqrt(EASY_V));
        createBoard(EASY_V);
    }

    public void mediumBoard() {
        mController.getMaze().createGraph(MEDIUM_V);
    }

    public void hardBoard() {
        mController.getMaze().createGraph(HARD_V);
    }

    private void createRooms(int rooms) {
        for (int i = 0; i < rooms; i++) {
            mController.getMaze().addRoom(i + 1);
        }
    }

    private void createDoors(int doors, int render) {
        Maze m = mController.getMaze();
        for (int i = 0; i < doors / 2; i++) {
            if ((i + 1) % render != 0) {
                m.addDoor(m.getGraph().getVertex(i), m.getGraph().getVertex(i + 1));
            }
        }
        for (int i = 0; i < doors / 2; i++) {
            if ((i + 1) % render != 0) {
                m.addDoor(m.getGraph().getVertex(i), m.getGraph().getVertex(i + render));
            }
        }
    }

    private void createBoard(int amount) {
        Maze m = mController.getMaze();
        board.getChildren().clear();
        int rowsAndCols = (int) Math.sqrt(amount);
        int idRoom = 0;
        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {
                idRoom++;
                Label lblId = new Label(idRoom + "");
                GridPane tempGrid = new GridPane();
                tempGrid.add(lblId, 0, 0);
                Room room = m.getGraph().getVertex(idRoom);
                if (room instanceof KeyRoom) {
                    KeyRoom key = (KeyRoom) room;
                    if (key.hasKey()) {
                        tempGrid.add(new ImageView(new Image(Route.KEY.getRoute())), 1, 1);
                    }
                } else if (room instanceof EnchantedRoom) {
                    tempGrid.add(new ImageView(new Image(Route.ENCHANTED.getRoute())), 1, 1);
                } else {
                    TraditionalRoom tRoom = (TraditionalRoom) room;
                    if (tRoom.hasTreasure()) {
                        tempGrid.add(new ImageView(new Image(Route.TREASURE.getRoute())), 1, 1);
                    }
                }
                tempGrid.setStyle(
                        "-fx-border-color: red; -fx-border-radius: 5px; -fx-background-radius: 5px;");
                tempGrid.setAlignment(Pos.CENTER);
                board.add(tempGrid, j, i);
            }
        }
        boxStyle(board, 0, board.getChildren().size());
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

    }
}
