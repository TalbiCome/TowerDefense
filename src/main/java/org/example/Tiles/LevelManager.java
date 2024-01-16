package org.example.Tiles;

import org.example.Window.Window;

public class LevelManager {
    private int[][] currentLevel;
    private TilesLevel TLevel;

    public LevelManager(int level,TilesManager grid){
        TLevel = new TilesLevel(grid);
        levelSwitch(level);
    }

    public void levelSwitch(int level){
        switch (level){
            case 1:
                currentLevel = TLevel.getLevel1();
                break;
            case 2:
                currentLevel = TLevel.getLevel2();
                break;
            default:
                currentLevel = TLevel.getLevelDefault();
                break;
        }
    }

    //Getter/Setter
    public int[][] getCurrentLevel() {
        return currentLevel;
    }
}
