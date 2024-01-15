package org.example;

import java.util.ArrayList;

public class Game {

    private static Game instance = null;
    ArrayList<Enemy> activeEnemys = new ArrayList<Enemy>();
    ArrayList<Enemy> enemysQueue = new ArrayList<Enemy>();
    ArrayList<Tower> activeTowers = new ArrayList<Tower>();
    ElementsFactory elementsFactory = ElementsFactory.getInstance();
    int headQuarterHP = 30;

    Level level;

    protected Game(){};

    public static Game getInstance()
    {
        if(instance == null)
        {
            instance = new Game();
        }
        return instance;
    }

    public void loadLevel(int levelNum)
    {
        switch (levelNum)
        {
            case 1:
                level = Level.loadLevel1();
                break;
            case 2:
                level = Level.loadLevel2();
                break;
            default:
                throw new IllegalArgumentException("Level number does not exist");
        }

        for (int encodedEnemy: level.encodedEnemyList) {
            enemysQueue.add(elementsFactory.createEnemy(encodedEnemy, level.posArray));
        }
        headQuarterHP = 30;
    }

    public void update()
    {

    }


}
