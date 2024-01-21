package org.example.Scenes;
import org.example.GameController;
import org.example.Input.MyButton;
import org.example.Pos;
import org.example.Window.*;
import org.example.Window.Window;

import java.awt.*;

public class Menu extends GameScenes implements Scenes{

    private Window window;
    private GameController gameController;
    private MyButton playButton;

    public Menu(Window window){
        super(window);
        this.window = window;
        playButton = new MyButton("Play",50, 100,100,50);
    }

    @Override
    public void render(Graphics g) {
        playButton.render(g);
        
    }

    @Override
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public MyButton getPlayButton() {
        return playButton;
    }
}
