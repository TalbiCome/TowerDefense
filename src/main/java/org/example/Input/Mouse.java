package org.example.Input;

import org.example.GameController;
import org.example.Scenes.GameStates;
import org.example.Tiles.Tiles;
import org.example.Tiles.TilesManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static org.example.Scenes.GameStates.PLAYING;

public class Mouse implements MouseListener, MouseMotionListener {

    private TilesManager TManager;
    private GameController gameController;

    /**
     *  set the gameController in this class to make sure we can communicate change
     *  to all other
     * @param gameController
     */
    public  void setGameController(GameController gameController){this.gameController = gameController;}

    /**
     * get the grid to search in the grid which tile we need to change
     * @param TManager
     */
    public void setGrid(TilesManager TManager){
        this.TManager = TManager;
    };

    /**
     * Construct tower on tiles of grass (1) and can't construct anything
     * if it is outside the grid or any other tiles not grass
     * @param x is the column of the tile
     * @param y is the row of the tile
     */
    private void getTiles(int x, int y){
        int typeID = 100;
        if(x <20 && y<20){typeID = TManager.grid.get(x).get(y).getTypeID();}
        switch(typeID){
            case 0:
                System.out.println("Impossible to construct a tower because it's water");
                break;
            case 1:
                System.out.println("Tower construct");
                gameController.addTower(TManager.grid.get(x).get(y).getRow(), TManager.grid.get(x).get(y).getColumn());
                break;
            case 2:
                System.out.println("Impossible to construct a tower because it's on the path");
                break;
            default:
                System.out.println("Error, it is a tower or outside of the grid");
        }
    }

    /**
     * check if the button is clicked by comparing its hitbox and the position x,y
     * @param x position of the mouse when clicked on the axis x
     * @param y position of the mouse when clicked on the axis y
     * @return true if it is on the button, false otherwise
     */
    private boolean buttonClicked(int x, int y) {
        if(gameController.getGameView().window.getMenu().getPlayButton().getBounds().contains(x,y)){
            return true;
        }
        return false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(GameStates.gameStates == GameStates.MENU){
            if(buttonClicked(e.getX(),e.getY())){
                GameStates.setGameStates(PLAYING);
                gameController.initGameLevel(1);
            }
        }
        if(e.getButton() == MouseEvent.BUTTON1 && GameStates.gameStates == PLAYING){getTiles(e.getY()/32-1,e.getX()/32);}
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}
