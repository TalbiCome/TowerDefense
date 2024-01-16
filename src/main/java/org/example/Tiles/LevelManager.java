package org.example.Tiles;

import org.example.Window.Window;

public class LevelManager {
    private int[][] currentLevel;
    private TilesLevel TLevel;

    public LevelManager(int level,TilesManager grid){
        TLevel = new TilesLevel(grid);
        switch (level){
            case 1:
                currentLevel = TLevel.getLevel1();
                break;
            default:
                currentLevel = TLevel.getLevelDefault();
        }


    }

    //Getter/Setter
    public int[][] getCurrentLevel() {
        return currentLevel;
    }
}
