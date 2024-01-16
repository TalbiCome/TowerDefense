package org.example.Tiles;

public class LevelManager {
    private int[][] currentLevel;
    private TilesLevel TLevel;

    public LevelManager(int level){
        TLevel = new TilesLevel();
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
