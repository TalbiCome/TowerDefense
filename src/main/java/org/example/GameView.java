package org.example;

import org.example.Input.Keyboard;
import org.example.Window.Window;

public class GameView {

    public Window window;
    public Keyboard KListener;
    public GameController gameController;

    public GameView(GameController gameController){
        this.gameController = gameController;
    }
    public void launchWindow(){
        window = new Window();
        window.intiInput();
        window.startThread();
        KListener = new Keyboard(this);
        window.addKeyListener(KListener);
        window.getMouse().setGameController(gameController);
        window.getPlaying().setGameController(gameController);

    }

    public void switchLevel(int i){
        window.getLManager().levelSwitch(i);
    }

}
