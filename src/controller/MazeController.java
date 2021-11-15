package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXRadioButton;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Maze;
import model.Player;
import routes.Route;

public class MazeController {

    // Mainpane
    @FXML
    private Pane mainPane;

    @FXML
    private Circle btnCloseLogin;

    @FXML
    private Circle btnMinimize;

    // Menu
    @FXML
    private Pane rpane;

    @FXML
    private Pane rpane2;

    @FXML
    private Pane rpane1;

    @FXML
    private Pane instructionsPane;

    @FXML
    private Pane initPane;

    @FXML
    private Pane gamePane;

    @FXML
    private ToggleGroup avatar;

    @FXML
    private JFXRadioButton rAlchemy;

    @FXML
    private JFXRadioButton rBarbarian;

    @FXML
    private JFXRadioButton rDruid;

    @FXML
    private JFXRadioButton rSamurai;
    private Maze maze;
    private BoardController bController;

    public MazeController() {
        maze = new Maze();
    }

    public Maze getMaze() {
        return maze;
    }

    @FXML
    public void back(MouseEvent event) {
        new FadeIn(initPane).play();
        initPane.toFront();
        new FadeIn(rpane).play();
        rpane.toFront();
    }

    @FXML
    public void showInstructions(ActionEvent event) {
        new FadeIn(instructionsPane).play();
        instructionsPane.toFront();
        new FadeIn(rpane2).play();
        rpane2.toFront();
    }

    @FXML
    public void play(ActionEvent event) {
        new FadeIn(gamePane).play();
        gamePane.toFront();
        new FadeIn(rpane1).play();
        rpane1.toFront();
    }

    @FXML
    public void easy(ActionEvent event) {
        if (avatar.getSelectedToggle() != null) {
            bController = new BoardController(this, hasAvatar());
            renderScreen(Route.BOARD);
            bController.easyBoard();
        }
    }

    @FXML
    public void medium(ActionEvent event) {
        if (avatar.getSelectedToggle() != null) {
            bController = new BoardController(this, hasAvatar());
            renderScreen(Route.BOARD);
            bController.mediumBoard();
        }
    }

    @FXML
    public void hard(ActionEvent event) {
        if (avatar.getSelectedToggle() != null) {
            bController = new BoardController(this, hasAvatar());
            renderScreen(Route.BOARD);
            bController.hardBoard();
        }
    }

    private Player hasAvatar() {
        if (avatar.getSelectedToggle().equals(rAlchemy)) {
            return maze.newPlayer(1);
        } else if (avatar.getSelectedToggle().equals(rBarbarian)) {
            return maze.newPlayer(2);
        } else if (avatar.getSelectedToggle().equals(rDruid)) {
            return maze.newPlayer(3);
        } else {
            return maze.newPlayer(4);
        }
    }

    @FXML
    public void handleMouseClick(MouseEvent event) {
        if (event.getSource() == btnCloseLogin) {
            System.exit(0);
        } else if (event.getSource() == btnMinimize) {
            getWindow().setIconified(true);
        }
    }

    private Stage getWindow() {
        return (Stage) mainPane.getScene().getWindow();
    }

    public void renderScreen(Route route) {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(route.getRoute()));
        fxmlloader.setController(setController(route));
        try {
            Parent root = fxmlloader.load();
            mainPane.getChildren().setAll(root);
        } catch (IOException e) {
            System.out.println("Indexing Error");
            e.printStackTrace();
        }
    }

    private Object setController(Route route) {
        switch (route) {
        case WELCOME:
            return this;
        case BOARD:
            return bController;
        default:
            return null;
        }
    }
}
