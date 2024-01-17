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

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            gameView.switchLevel(2);
            gameController.initGameLevel(1);
            Mouse mouse = gameView.window.getMouse();
            mouse.setGrid(gameView.window.getScreen().getTManager());
        }

        if(e.getKeyCode() == KeyEvent.VK_Z){
            gameView.switchLevel(1);
            gameController.initGameLevel(1);
            Mouse mouse = gameView.window.getMouse();
            mouse.setGrid(gameView.window.getScreen().getTManager());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
