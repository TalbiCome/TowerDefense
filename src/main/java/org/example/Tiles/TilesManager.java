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
    }
}
