package org.example;

import org.example.Tiles.*;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class GameView extends JPanel{

    private Random random;
    private int size = 32;
    private long lastTime;
    private int frames;
    private Grid grid;
    private Level level;





    public GameView(){
        random = new Random();
        grid = new Grid();
        level = new Level(grid);
        System.out.println(grid.grid.get(0).get(0).getTypeID());


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Create the grid
        for(int x= 0; x < 20; x++){
            for(int y=0; y < 20; y++){
                g.setColor(changeColorToType(grid.grid.get(x).get(y).getTypeID()));
                g.fillRect(grid.grid.get(y).get(x).getX(),grid.grid.get(y).get(x).getY(), size,size);

            }
        }

        FPSCounter();

    }

    private void FPSCounter() {
        frames++;
        if(System.currentTimeMillis() - lastTime >= 1000){
            System.out.println("FPS : " + frames);
            frames = 0;
            lastTime = System.currentTimeMillis();
        }
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

    public Grid getGrid() {
        return grid;
    }

    public static void main(String[] args){
    }
}
