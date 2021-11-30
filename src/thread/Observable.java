package thread;

import controller.BoardController;
import javafx.application.Platform;

public class Observable extends Thread {
    private BoardController bController;
    private int mazeType;

    private IObserver listener;

    public Observable(BoardController bController, int mazeType) {
        this.bController = bController;
        this.mazeType = mazeType;
    }

    public void setListener(IObserver listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        listener.onInit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                switch (mazeType) {
                    case 1:
                        bController.easyBoard();
                        break;
                    case 2:
                        bController.mediumBoard();
                        break;
                    default:
                        bController.hardBoard();
                        break;
                }
            }
        });
        listener.onFinish();
    }

}
