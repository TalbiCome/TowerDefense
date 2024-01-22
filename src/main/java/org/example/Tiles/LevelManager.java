package org.example.Tiles;

import org.example.Window.Window;

public class LevelManager {

    /**
     * The level and map we are using at the moment
     */
    private int[][] currentLevel;
    /**
     * To get the level we use
     */
    private TilesLevel TLevel;

    /**
     * Constructor of the LevelManager
     * @param grid is the grid we use to separate each tiles
     */
    public LevelManager(TilesManager grid){
        TLevel = new TilesLevel(grid);
    }

    /**
     * To change the level and map
     */
    public void levelSwitch(){
        currentLevel = TLevel.level();
    }

    //Getter/Setter

    /**
     * to get the current level
     * @return the current level
     */
    public int[][] getCurrentLevel() {
        return currentLevel;
    }
}
