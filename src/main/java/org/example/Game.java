package org.example;

import java.util.*;

/**
 * Model part of the MVC
 * Main class of the game
 * Singleton
 */
public class Game {

    /**
     * contain the only allowed instance of the game class
     */
    private static Game instance = null;
    /**
     * store the active enemys wich will take damage, move and be displayed on screen
     */
    ArrayList<Enemy> activeEnemys = new ArrayList<Enemy>();
    /**
     * store the list of enemy that will be fed to the factory to be instantiated into the active Enemy list
     */
    Stack<Enemy> enemysQueue = new Stack<Enemy>();

    /**
     * store the list of active towers
     */
    ArrayList<Tower> activeTowers = new ArrayList<Tower>();

    /**
     * the factory used to generate enemy from an int value
     */
    ElementsFactory elementsFactory = ElementsFactory.getInstance();

    /**
     * store the HP from the main base when at 0 the game is lost
     */
    int headQuarterHP = 30;

    /**
     * contain the level to generate
     */
    Level level = null;

    protected Game(){}

    /**
     * Singleton instance getter
     * @return the only allowed instance of Game class
     */
    public static Game getInstance()
    {
        if(instance == null)
        {
            instance = new Game();
        }
        return instance;
    }

    /**
     * must use resetLevel() if it's not the first level to be loaded
     * the level by adding its elements into the game, instantiate the encoded enemy into the queue
     * @param levelNum the number referencing the level to generate
     */
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

    /**
     * Only used in tests !!!
     * load the level by adding its elements into the game
     * @param levelNum the number referencing the level to generate
     */
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

    /**
     * verify that the enemy queue and the active enemy list are both empty, indicating if the player as won
     * @return true if the player won, else return false
     */
    public boolean areAllEnemyDead()
    {
        return enemysQueue.isEmpty() && activeEnemys.isEmpty();
    }

    /**
     * check if the player HP are > 0
     * @return true if the player lost, else return false
     */
    public boolean didPlayerLost()
    {
        return headQuarterHP < 1;
    }

    /**
     * clear all the list and reset the player HP
     */
    public void resetLevel()
    {
        activeEnemys.clear();
        activeTowers.clear();
        enemysQueue.clear();
        headQuarterHP = 30;
    }

    /**
     * pop an enemy from the queue and add it to the active enemy list
     */
    public void spawnNextEnemy()
    {
        if(!enemysQueue.isEmpty())
        {
            activeEnemys.add(enemysQueue.pop());
        }
    }

    /**
     * add a tower to the list of active tower
     * @param pos the position of the created tower
     */
    public void spawnTower(Pos pos)
    {
        activeTowers.add(new Tower(pos));
    }

    /**
     * remove a tower from the list of active tower with the same pos
     * @param pos the position of the tower to remove
     */
    public void removeTower(Pos pos)
    {
        activeTowers.removeIf(towerInList -> Pos.arePosesEquals(towerInList.position, pos));
    }

    /**
     * main routine for the enemy
     * update the status of all enemy in the active list
     * add damage to the base if they are at the end of the position list
     * remove them if they are dead
     */
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
        activeEnemys.removeAll(toDelete); //avoid concurrent access to the list of active enemy
        toDelete.clear();
    }

    /**
     * main routine for the tower
     * assign an enemy target and make the tower deal damages
     */
    public void updateTower()
    {
        boolean isTargetAvailable = !activeEnemys.isEmpty();
        for (Tower tower: activeTowers) {
            if(isTargetAvailable && tower.target == null)
            {
                if(!activeEnemys.get(0).isDead)
                {
                    tower.assignNewTarget(activeEnemys.get(0));
                }
            }
            tower.shootAtTarget();
        }
    }

    public ArrayList<Tower> getActiveTowers() {
        return activeTowers;
    }

    public ArrayList<Enemy> getActiveEnemys() {
        return activeEnemys;
    }
}
