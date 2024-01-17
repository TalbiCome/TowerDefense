package org.example.Scenes;
import org.example.GameController;
import org.example.Window.*;
import org.example.Window.Window;

import java.awt.*;

public class Menu extends GameScenes implements Scenes{

    private Window window;
    private GameController gameController;

    public Menu(Window window){
        super(window);
        this.window = window;
    }

    @Override
    public void render(Graphics g) {
        
    }

    @Override
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

}
