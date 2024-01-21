package org.example.Scenes;

import org.example.Enemy;
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

    /**
     * draw tower, the map and the enemy on the screen
     * @param g
     */
    @Override
    public void render(Graphics g){
        drawMap(g);
        drawTower(g);
        drawEnemy(g);
        drawBaseHp(g);
        drawGold(g);
    }

    @Override
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * Change the color we need to show each tiles depending on the type of the tile
     * @param typeID type of tile, 0,1 or 2
     * @return color which is the color in a rgb unit( red: ?, green: ?, blue : ?)
     */
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

    /**
     * Draw the map on the screen
     * @param g
     */
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

    /**
     * Get all the active tower and draw them on the screen
     * @param g
     */
    private void drawTower(Graphics g){
        for(int tower = 0;
            tower < gameController.getGame().getActiveTowers().size();
            tower++){
            Pos pos = gameController.getGame().getActiveTowers().get(tower).getPos();
            g.setColor(Color.MAGENTA);
            g.fillRect(pos.getX(), pos.getY(), 24,24 );

        }
    }

    /**
     * get all the active enemy and draw them
     * @param g
     */
    private void drawEnemy(Graphics g){
        for(Enemy enemy:gameController.getGame().getActiveEnemys()) {
            typeOfEnemy(enemy);

            g.setColor(typeOfEnemy(enemy));
            g.fillRect(enemy.getPosition().getX(), enemy.getPosition().getY(), 16, 16);

            g.setColor(Color.gray);
            g.drawRect(enemy.getPosition().getX(), enemy.getPosition().getY(), 16, 5);
            g.setColor(Color.GREEN);
            g.fillRect(enemy.getPosition().getX(), enemy.getPosition().getY() - 10, enemy.getHP() * 4, 5);
        }

    }

    private Color typeOfEnemy(Enemy enemy){
        if(enemy.getClass() == org.example.NormalEnemy.class){
            return Color.CYAN;
        }
        if(enemy.getClass() == org.example.FastEnemy.class){
            return Color.YELLOW;
        }
        else{return Color.RED;}
    }

    private void drawBaseHp(Graphics g){
        g.setColor(Color.gray);
        g.drawRect(0,0,300,20);
        g.setColor(Color.GREEN);
        g.fillRect(0,0,gameController.getGame().getHeadQuarterHP()*10,20);
    }


    private void drawGold(Graphics g){
        g.drawString(String.valueOf(gameController.getGame().getMoney()),600 ,25);
    }

}
