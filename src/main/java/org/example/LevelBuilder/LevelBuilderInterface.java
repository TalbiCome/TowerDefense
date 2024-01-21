package org.example.LevelBuilder;

public interface LevelBuilderInterface {
    void buildLevel();
    void buildMap(int mapNumber);
    void buildChemin(int cheminNumber);
    void buildPath(int pathNumber);
    void buildEnemiesList(int enemyNum);
    Level getLevel();
}
