package org.example.Scenes;

import org.example.GameController;
import org.example.Pos;
import org.example.Window.Window;


import java.awt.*;

public class Playing extends GameScenes implements Scenes {

    private Window window;
    private GameController gameController;
    public Playing(Window window){
        super(window);
        this.window = window;
    }

    @Override
    public void render(Graphics g){
        drawMap(g);
        drawTower(g);
    }

    @Override
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    private Color changeColorToType(int typeID){
        Color color;
        switch (typeID) {
            case 0:
                color = new Color(0, 100, 200); //Water
                break;
            case 1:
                color = new Color(0,150,0); //Grass
                break;
            case 2:
                color = new Color(100,100,100); //Path
                break;
            default:
                color = new Color(0,0,0);
        }
        return color;
    }

    private void drawMap(Graphics g){
        for(int column= 0; column < 20; column++){
            for(int row=0; row < 20; row++){
                g.setColor(changeColorToType(window.getScreen().
                        getTManager().
                        grid.get(column).get(row).
                        getTypeID()));
                g.fillRect(window.getScreen().getTManager().grid.get(row).get(column).getColumn(),
                        window.getScreen().getTManager().grid.get(row).get(column).getRow(),
                        32,32
                        );
            }
        }
    }

    private void drawTower(Graphics g){
        for(int tower = 0;
            tower < gameController.getGame().getActiveTowers().size();
            tower++){
            Pos pos = gameController.getGame().getActiveTowers().get(tower).getPos();
            g.setColor(Color.MAGENTA);
            g.fillRect(pos.getX(), pos.getY(), 32,32 );

        }
    }

    private void drawEnemy(Graphics g){
        for(int enemy = 0;
            enemy < gameController.getGame().getActiveEnemies().size(); enemy++){

        }
    }

}
