package org.example.Input;

import org.example.GameController;
import org.example.Scenes.GameStates;
import org.example.Tiles.Tiles;
import org.example.Tiles.TilesManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {

    private TilesManager TManager;
    private GameController gameController;
    public  void setGameController(GameController gameController){this.gameController = gameController;}

    public void setGrid(TilesManager TManager){
        this.TManager = TManager;
    };

    private void getTiles(int x, int y){
        int typeID = 100;
        if(x <20 && y<20){typeID = TManager.grid.get(x).get(y).getTypeID();}
        switch(typeID){
            case 0:
                System.out.println("Impossible to construct a tower because it's water");
                break;
            case 1:
                System.out.println("Tower construct");
                TManager.grid.get(x).get(y).setTypeID(10);
                for(int z = 0; z < TManager.grid.get(x).get(y).getNeighbours().size(); z++){
                    TManager.grid.get(x).get(y).getNeighbours().get(z).setTypeID(10);
                }
                gameController.addTower(TManager.grid.get(x).get(y).getRow(), TManager.grid.get(x).get(y).getColumn());
                break;
            case 2:
                System.out.println("Impossible to construct a tower because it's on the path");
                break;
            default:
                System.out.println("Error, it is a tower or outside of the grid");
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1 && GameStates.gameStates == GameStates.PLAYING){
            System.out.println("I clicked : "+ e.getY()/32 + ", " + e.getX()/32);
            getTiles(e.getY()/32-1,e.getX()/32);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
