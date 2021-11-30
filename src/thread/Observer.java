package thread;

import controller.BoardController;

public class Observer implements IObserver {
    private BoardController bController;
    private TimeThread timeThread;
    private Observable obs;

    public Observer(BoardController bController, int mazeType) {
        this.bController = bController;
        timeThread = new TimeThread(bController);
        obs = new Observable(bController, mazeType);
    }

    public void init() {
        obs.setListener(this);
        obs.start();
    }

    @Override
    public void onInit() {
        bController.progress.setVisible(true);
    }

    @Override
    public void onFinish() {
        bController.progress.setVisible(false);
        timeThread.start();
    }

}
