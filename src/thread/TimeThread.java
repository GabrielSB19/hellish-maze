package thread;

import controller.BoardController;
import javafx.application.Platform;

public class TimeThread extends Thread {

    private BoardController bController;

    public TimeThread(BoardController bController) {
        this.bController = bController;
    }

    @Override
    public void run() {
        while (!bController.getPlayer().isWinner()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    bController.decreaseTime();
                    bController.isWinner();
                }
            });
        }
    }
}
