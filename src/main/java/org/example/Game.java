package org.example;

import java.util.*;

public class Game {

    private static Game instance = null;
    ArrayList<Enemy> activeEnemys = new ArrayList<Enemy>();
    Stack<Enemy> enemysQueue = new Stack<Enemy>();
    ArrayList<Tower> activeTowers = new ArrayList<Tower>();
    ElementsFactory elementsFactory = ElementsFactory.getInstance();
    int headQuarterHP = 30;

    Level level = null;

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

    public void loadTestLevel(int levelNum)
    {
        switch (levelNum)
        {
            case 1:
                level = Level.loadTestLevel1();
                break;
            case 2:
                level = Level.loadTestLevel2();
                break;
            default:
                throw new IllegalArgumentException("Level number does not exist");
        }

        for (int encodedEnemy: level.encodedEnemyList) {
            enemysQueue.add(elementsFactory.createEnemy(encodedEnemy, level.posArray));
        }
        headQuarterHP = 30;
    }

    public boolean areAllEnemyDead()
    {
        return enemysQueue.isEmpty() && activeEnemys.isEmpty();
    }

    public boolean didPlayerLost()
    {
        return headQuarterHP < 1;
    }

    public void resetLevel()
    {
        activeEnemys.clear();
        activeTowers.clear();
        enemysQueue.clear();
        headQuarterHP = 30;
    }

    public void spawnNextEnemy()
    {
        if(!enemysQueue.isEmpty())
        {
            activeEnemys.add(enemysQueue.pop());
        }
    }

    public void spawnTower(Pos pos)
    {
        activeTowers.add(new Tower(pos));
    }

    public void removeTower(Pos pos)
    {
        activeTowers.removeIf(towerInList -> Pos.arePosesEquals(towerInList.position, pos));
    }

    public void updateActiveEnemys()
    {
        ArrayList<Enemy> toDelete = new ArrayList<>();
        for (Enemy enemy: activeEnemys) {
            enemy.updateStatus();
            if(enemy.isAtEnd)
            {
                headQuarterHP -= 1;
                toDelete.add(enemy);
            }
            else if (enemy.isDead)
            {
                toDelete.add(enemy);
            }
        }
        activeEnemys.removeAll(toDelete); //Evite les problèmes d'acces concourent
        toDelete.clear();
    }

    public void updateTower()
    {
        boolean isTargetAvailable = !activeEnemys.isEmpty();
        for (Tower tower: activeTowers) {
            if(isTargetAvailable && tower.target == null)
            {
                tower.assignNewTarget(activeEnemys.get(0));
            }
            tower.shootAtTarget();
        }
    }


}
