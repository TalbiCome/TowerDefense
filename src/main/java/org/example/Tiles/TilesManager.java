package org.example.Tiles;

import java.util.ArrayList;

public class TilesManager {

    public ArrayList <ArrayList <Tiles>> grid = new ArrayList<>();
    public TilesManager(){
        for(int x=0; x < 20; x++){
            ArrayList<Tiles> temporaryList = new ArrayList<>();
            for(int y = 0; y < 20; y++){
                temporaryList.add(new Tiles(x*32,y*32));
            }
            grid.add(temporaryList);
        }

        for(int x=0; x < 20; x++){
            for(int y = 0; y < 20; y++){
                grid.get(x).get(y).setNeighbours(setNeighbours(x,y));
            }
        }

    }
    private ArrayList<Tiles> setNeighbours(int i, int j){
        ArrayList<Tiles> neighbour = new ArrayList<>();
        if(i > 0 && j > 0){neighbour.add(grid.get(i-1).get(j-1));}
        if(i < 19 && j > 0){neighbour.add(grid.get(i+1).get(j-1));}
        if(i > 0 && j < 19){neighbour.add(grid.get(i-1).get(j+1));}
        if(i < 19 && j < 19){neighbour.add(grid.get(i+1).get(j+1));}

        if(i > 0){neighbour.add(grid.get(i-1).get(j));}
        if(i < 19){neighbour.add(grid.get(i+1).get(j));}
        if(j > 0){neighbour.add(grid.get(i).get(j-1));}
        if(j < 19){neighbour.add(grid.get(i).get(j+1));}
        return neighbour;
    }


}
