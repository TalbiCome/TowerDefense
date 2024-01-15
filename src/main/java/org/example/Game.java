package org.example;

import java.util.ArrayList;

public class Game {

    private static Game instance = null;
    ArrayList<Enemy> activeEnemys = new ArrayList<Enemy>();
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
}
