package org.example.Scenes;

import org.example.GameController;

import java.awt.*;

public interface Scenes {

    /**
     * Draw all the things we need to see on this Scenes
     * @param g
     */
    public void render(Graphics g);

    /**
     * Set the gameController to give the change we make when the user play with the window
     * @param gameController
     */
    public void setGameController(GameController gameController);
}
