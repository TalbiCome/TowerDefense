package org.example.Window;
import org.example.Scenes.*;

import java.awt.*;

public class Render {

    private Window window;

    public Render(Window window){this.window = window;}

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
