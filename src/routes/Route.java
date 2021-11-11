package routes;

public enum Route {
    MAINPANE("../ui/assets/screens/mainPane.fxml"),WELCOME("../ui/assets/screens/menu.fxml");

    private String route;

    private Route(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
