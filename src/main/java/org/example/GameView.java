package org.example;

import org.example.Window.Window;

public class GameView {

    /**
     * The unique window
     */
    public Window window;
    /**
     * The gameController to communicate changes
     */
    public GameController gameController;

    /**
     * *Constructor of GameView Class
     * @param gameController the controller use everywhere else
     */
    public GameView(GameController gameController){
        this.gameController = gameController;
    }

    /**
     * Start the window and initialise the Window
     */
    public void launchWindow(){
        window = new Window();
        window.intiInput();
        window.startThread();
        window.getMouse().setGameController(gameController);
        window.getPlaying().setGameController(gameController);

    }

    /**
     * Switch and update the view for the right level
     */
    public void switchLevel(){
        window.getLManager().levelSwitch();
    }

}
