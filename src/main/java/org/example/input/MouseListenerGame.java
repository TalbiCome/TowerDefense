package org.example.input;

import org.example.Tiles.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseListenerGame implements MouseListener, MouseMotionListener {

    private Grid grid;

    public void setGrid(Grid grid){
        this.grid = grid;
    };

    private void getTiles(int x, int y){
        int typeID = 100;
        if(x <20 && y<20){typeID = grid.grid.get(x).get(y).getTypeID();}
        switch(typeID){
            case 0:
                System.out.println("Impossible to construct a tower because it's water");
                break;
            case 1:
                System.out.println("Tower construct");
                grid.grid.get(x).get(y).setTypeID(10);
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
        if(e.getButton() == MouseEvent.BUTTON1){

            //System.out.println("Mouse clicked a " + e.getX() /32+ ", " + e.getY()/32);
            //System.out.println(grid.grid.get(e.getY()/32 -1).get(e.getX()/32).getTypeID());
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
        getTiles(e.getY()/32-1,e.getX()/32);

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
