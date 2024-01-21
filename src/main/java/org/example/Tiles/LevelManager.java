package org.example.Tiles;

import org.example.Window.Window;

public class LevelManager {
    private int[][] currentLevel;
    private TilesLevel TLevel;

    public LevelManager(TilesManager grid){
        TLevel = new TilesLevel(grid);
    }

    public void levelSwitch(){
        currentLevel = TLevel.level();
    }

    //Getter/Setter
    public int[][] getCurrentLevel() {
        return currentLevel;
    }
}
