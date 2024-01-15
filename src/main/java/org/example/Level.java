package org.example;

import java.util.ArrayList;
import java.util.List;

public class Level {
    ArrayList<Integer> encodedEnemyList = new ArrayList<Integer>();
    ArrayList<Pos> posArray = new ArrayList<Pos>();

    protected Level(Integer[] encodedEnemyList, Pos[] posArray)
    {
        this.encodedEnemyList.addAll(List.of(encodedEnemyList));
        this.posArray.addAll(List.of(posArray));
    }

    public static Level loadLevel1()
    {
        Integer[] encodedEnemyList = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        Pos[] posArray = {new Pos(0,0), new Pos(500, 500)};
        return new Level(encodedEnemyList, posArray);
    }

}
