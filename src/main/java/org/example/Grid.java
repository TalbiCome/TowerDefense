package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Grid {
    public ArrayList <ArrayList <Tiles> > grid = new ArrayList<>();

    public Grid(){

        for(int x = 0; x < 20; x++){
            ArrayList<Tiles> temporaryList = new ArrayList<>();
            for(int y = 0; y < 20; y++){
                temporaryList.add(new Tiles(x*32,y*32));
            }
            grid.add(temporaryList);
        }

    };


    public static void main(String [] args){
        Grid grid = new Grid();
        System.out.println(grid.grid.get(0));
        System.out.println(grid.grid.get(1));
    }


}
