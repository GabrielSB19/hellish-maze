package routes;

public enum Route {
    MAINPANE("../ui/assets/screens/mainPane.fxml"), WELCOME("../ui/assets/screens/menu.fxml"),
    BOARD("../ui/assets/screens/board.fxml"),TRADITIONAL("/ui/assets/images/traditional.png"), KEY("/ui/assets/images/key.png"),
    ENCHANTED("/ui/assets/images/poison.png"), TREASURE("/ui/assets/images/treasure.png"),
    INFERNAL("/ui/assets/images/door3.png"), GOLD("/ui/assets/images/door1.png"),
    SILVER("/ui/assets/images/door2.png"),AVATAR("/ui/assets/images/avatar/");

    private String route;

    private Route(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
