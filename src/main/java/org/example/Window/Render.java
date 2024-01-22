package org.example.Window;
import org.example.Scenes.*;

import java.awt.*;

public class Render {

    /**
     * The window we use
     */
    private Window window;

    /**
     * Constructor of the Render Class
     * @param window the unique window we use
     */
    public Render(Window window){this.window = window;}

    /**
     * Change the render we use depending on the GameStates
     * @param g Graphics
     */
    public void render(Graphics g){
        switch (GameStates.gameStates){
            case MENU :
                window.getMenu().render(g);
                break;
            case PLAYING:
                window.getPlaying().render(g);
                break;
        }

    }
}
