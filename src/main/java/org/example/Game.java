package org.example;

import org.example.LevelBuilder.Level;
import org.example.LevelBuilder.LevelBuilder;
import org.example.LevelBuilder.LevelBuilderInterface;
import org.example.LevelBuilder.LevelDirector;

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
     * store the active enemies which will take damage, move and be displayed on screen
     */
    ArrayList<Enemy> activeEnemies = new ArrayList<>();
    /**
     * store the list of enemy that will be fed to the factory to be instantiated into the active Enemy list
     */
    Stack<Enemy> enemiesQueue = new Stack<>();

    /**
     * store the list of active towers
     */
    ArrayList<Tower> activeTowers = new ArrayList<>();

    /**
     * the factory used to generate enemy from an int value
     */
    ElementsFactory elementsFactory = ElementsFactory.getInstance();

    /**
     * store the HP from the main base when at 0 the game is lost
     */
    int headQuarterHP = 30;

    /** used to generate a level*/
    LevelDirector levelDirector = new LevelDirector();
    /** used to generate a level, can be the normal one or another if map creation*/
    LevelBuilderInterface builder = new LevelBuilder();

    /**
     * contain the generated level
     */
    Level level = null;

    int money = 30;

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
        level = levelDirector.createLevel(builder, levelNum);

        /*
        for (int encodedEnemy: level.encodedEnemiesList) {
            enemiesQueue.add(elementsFactory.createEnemy(encodedEnemy, level.path));
        }
        */
        headQuarterHP = 30;
    }

    public void addEnemy(int levelnum){
        for (int encodedEnemy: level.encodedEnemiesList) {
            enemiesQueue.add(elementsFactory.createEnemy(encodedEnemy, level.path));
        }
    }

    /**
     * verify that the enemy queue and the active enemy list are both empty, indicating if the player as won
     * @return true if the player won, else return false
     */
    public boolean areAllEnemyDead()
    {
        return enemiesQueue.isEmpty() && activeEnemies.isEmpty();
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
        activeEnemies.clear();
        activeTowers.clear();
        enemiesQueue.clear();
        headQuarterHP = 30;
    }

    /**
     * pop an enemy from the queue and add it to the active enemy list
     */
    public void spawnNextEnemy()
    {
        if(!enemiesQueue.isEmpty())
        {
            activeEnemies.add(enemiesQueue.pop());
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
    public void updateActiveEnemies()
    {
        ArrayList<Enemy> toDelete = new ArrayList<>();
        for (Enemy enemy: activeEnemies) {
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
        activeEnemies.removeAll(toDelete); //avoid concurrent access to the list of active enemy
        toDelete.clear();
    }

    /**
     * main routine for the tower
     * assign an enemy target and make the tower deal damages
     */
    public void updateTower()
    {
        boolean isTargetAvailable = !activeEnemies.isEmpty();
        for (Tower tower: activeTowers) {
            if(isTargetAvailable && tower.target == null)
            {
                if(!activeEnemies.get(0).isDead)
                {
                    tower.assignNewTarget(activeEnemies.get(0));
                }
            }
            tower.shootAtTarget();
        }
    }

    public ArrayList<Tower> getActiveTowers() {
        return activeTowers;
    }

    public ArrayList<Enemy> getActiveEnemys() {
        return activeEnemies;
    }

    public Level getLevel() {
        return level;
    }
}
