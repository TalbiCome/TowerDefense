package org.example.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.example.GameController;
import org.example.GameView;
import org.example.Window.Window;

public class Keyboard implements KeyListener {

    private GameView gameView;
    private GameController gameController;
    public Keyboard(GameView gameView){
        this.gameView = gameView;
    }

    /**
     * set the gameController in this class to make sure we can communicate change
     * to all other
     * @param gameController
     */
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
