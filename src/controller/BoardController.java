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

    @FXML
    private ImageView notKey;
    private MazeController mController;
    private int avatar;

    private final int EASY_V = 9, EASY_E = 12;
    private final int MEDIUM_V = 16, MEDIUM_E = 24;
    private final int HARD_V = 25, HARD_E = 40;

    public BoardController(MazeController mController, int avatar) {
        this.mController = mController;
        this.avatar = avatar;
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
            mController.getMaze().addRoom(i);
        }
    }

    private void createDoors(int doors, int render) {
        Maze m = mController.getMaze();
        for (int i = 0; i < render * render; i++) {
            if ((i + 1) % render != 0) {
                m.addDoor(m.getGraph().getVertex(i).getData(), m.getGraph().getVertex(i + 1).getData());
            }
        }
        for (int i = 0; i < render * render; i++) {
            if ((double) ((i + 1.0) / render) <= (render - 1)) {
                m.addDoor(m.getGraph().getVertex(i).getData(), m.getGraph().getVertex(i + render).getData());
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
                Label lblId = new Label(idRoom + "");
                GridPane tempGrid = new GridPane();
                tempGrid.add(lblId, 0, 0);
                roomStyle(tempGrid, m.getGraph().getVertex(idRoom).getData());
                for (int k = 0; k < m.getGraph().getVertex(idRoom).getEdges().size(); k++) {
                    Room s = m.getGraph().getVertex(idRoom).getEdges().get(k).getSource().getData();
                    Room d = m.getGraph().getVertex(idRoom).getEdges().get(k).getDestination().getData();
                    int source = (s.getId() == idRoom) ? s.getId() : d.getId();
                    int destination = (d.getId() == idRoom) ? s.getId() : d.getId();
                    int[] pos = getPosition(source, destination);
                    doorStyle(tempGrid, m.getGraph().getVertex(idRoom).getEdges().get(k).getData(), pos[0], pos[1],
                            pos[2], pos[3]);
                }
                tempGrid.setStyle("-fx-border-color: red; -fx-border-radius: 40px; -fx-background-radius: 40px;");
                boxStyle(tempGrid, 0, tempGrid.getChildren().size());
                board.add(tempGrid, j, i);
                idRoom++;
            }
        }
        boxStyle(board, 0, board.getChildren().size());
        board.setHgap(15);
        board.setVgap(15);
        board.setPadding(new Insets(15, 15, 15, 15));
    }

    private int[] getPosition(int s, int d) {
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
        } else if (s - d == 3) {
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
        img.setFitHeight(35);
        img.setFitWidth(35);
    }

    private void roomStyle(GridPane gP, Room r) {
        ImageView img = null;
        if (r instanceof KeyRoom) {
            KeyRoom key = (KeyRoom) r;
            if (key.hasKey()) {
                img = new ImageView(new Image(Route.KEY.getRoute()));
                renderImg(img);
                gP.add(img, 3, 0);
            }
        } else if (r instanceof EnchantedRoom) {
            img = new ImageView(new Image(Route.ENCHANTED.getRoute()));
            renderImg(img);
            gP.add(img, 3, 0);
        } else {
            TraditionalRoom tRoom = (TraditionalRoom) r;
            if (tRoom.hasTreasure()) {
                img = new ImageView(new Image(Route.TREASURE.getRoute()));
                renderImg(img);
                gP.add(img, 3, 0);
            }
        }
    }

    private void doorStyle(GridPane gP, Door d, int col1, int row1, int col2, int row2) {
        ImageView img = null;
        if (d instanceof SilverDoor) {
            img = new ImageView(new Image(Route.SILVER.getRoute()));
            renderImg(img);
            gP.add(img, col1, row1);
        } else if (d instanceof GoldenDoor) {
            img = new ImageView(new Image(Route.GOLD.getRoute()));
            renderImg(img);
            gP.add(img, col1, row1);
        } else {
            img = new ImageView(new Image(Route.INFERNAL.getRoute()));
            renderImg(img);
            gP.add(img, col1, row1);
        }
        gP.add(new Label(d.getToken() + ""), col2, row2);
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

            break;
        case DOWN:

            break;
        case RIGHT:

            break;
        case LEFT:

            break;
        default:
            break;
        }

    }
}
