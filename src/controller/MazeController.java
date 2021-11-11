package controller;

import java.io.IOException;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import routes.Route;

public class MazeController {

    @FXML
    private Pane mainPane;

    @FXML
    private Circle btnCloseLogin;

    @FXML
    private Circle btnMinimize;

    @FXML
    private Pane instructionsPane;

    @FXML
    private Pane initPane;

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

    @FXML
    public void showInstructions(ActionEvent event) {
        new FadeIn(instructionsPane).play();
        instructionsPane.toFront();
    }

    @FXML
    public void showWelcome(ActionEvent event) {
        new FadeIn(initPane).play();
        initPane.toFront();
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
            default:
                return null;
        }
    }
}
