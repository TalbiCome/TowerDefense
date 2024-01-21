package org.example.LevelBuilder;

import org.example.Pos;

public class LevelBuilder implements LevelBuilderInterface {
    private Level currentLevel;

    public LevelBuilder() {}

    public void buildLevel()
    {
        currentLevel = new Level();
    }

    public void buildMap(int mapNumber)
    {
        currentLevel.map = FileReading.readMapFile("src/main/java/org/example/LevelBuilder/LevelFiles/map_" + mapNumber + ".txt");
    }

    public void buildChemin(int cheminNumber){
        currentLevel.chemin = FileReading.readMapFile("src/main/java/org/example/LevelBuilder/LevelFiles/chemin_" + cheminNumber + ".txt");
    }

    public void buildPath(int pathNumber)
    {
        int[] tmp = FileReading.readEnemyFile("src/main/java/org/example/LevelBuilder/LevelFiles/path_" + pathNumber + ".txt");
        Pos[] path = new Pos[tmp.length/2];
        int j = 0;
        for (int i = 0; i < tmp.length; i+=2) {
            path[j] = new Pos(tmp[i], tmp[i+1]);
            j++;
        }
        currentLevel.path = path;
    }

    public void buildEnemiesList(int enemyNum)
    {
        currentLevel.encodedEnemiesList = FileReading.readEnemyFile("src/main/java/org/example/LevelBuilder/LevelFiles/enemyList_" + enemyNum + ".txt");
    }

    public Level getLevel()
    {
        return currentLevel;
    }

}
