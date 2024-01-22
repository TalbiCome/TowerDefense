package org.example.Scenes;

import org.example.Window.Window;

public class GameScenes {

    /**
     * The Window use by the application
     */
    private Window window;

    /**
     * Constructor of the Scenes
     * @param window the window we use to play our game
     */
    public GameScenes(Window window){this.window = window;}

    /**
     * getter of the window
     * @return window , the window we use
     */
    public Window getWindow(){return window;}

}
