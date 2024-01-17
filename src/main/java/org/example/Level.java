package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Is used to contain the enemy to spawn and their path which will be loaded onto the game
 */
public class Level {
    /**
     * the list of enemy that will be spawned
     */
    ArrayList<Integer> encodedEnemyList = new ArrayList<Integer>();
    /**
     * the path all the enemy will follow
     */
    Pos[] posArray;

    protected Level(Integer[] encodedEnemyList, Pos[] posArray)
    {
        this.encodedEnemyList.addAll(List.of(encodedEnemyList));
        this.posArray = posArray;
    }

    public static Level loadTestLevel1()
    {
        Integer[] encodedEnemyList = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        Pos[] posArray = {new Pos(0,0), new Pos(100, 0)};
        return new Level(encodedEnemyList, posArray);
    }

    public static Level loadTestLevel2()
    {
        Integer[] encodedEnemyList = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        Pos[] posArray = {new Pos(0,0), new Pos(100, 100)};
        return new Level(encodedEnemyList, posArray);
    }

    public static Level loadLevel1()
    {

        Integer[] encodedEnemyList = {
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1
                , 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1 ,1 ,1};
        Pos[] posArray = {new Pos(0,0), new Pos(100, 100)};
        return new Level(encodedEnemyList, posArray);
    }

    public static Level loadLevel2()
    {

        Integer[] encodedEnemyList = {
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2,};
        Pos[] posArray = {new Pos(0,0), new Pos(50, 0), new Pos(50, 50), new Pos(100, 50)};
        return new Level(encodedEnemyList, posArray);
    }



}
