package org.example;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class TestElementsFactory {
    @Test
    void testElementsFactory()
    {
        ElementsFactory elementFactory = ElementsFactory.getInstance();
        Pos[] posArray = {new Pos(0, 0), new Pos(50, 50)};
        ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
        ArrayList<Tower> towerList = new ArrayList<Tower>();


        enemyList.add(elementFactory.createEnemy(1, new WalkingStrategy(), posArray));
        enemyList.add(elementFactory.createEnemy(2, new WalkingStrategy(), posArray));
        enemyList.add(elementFactory.createEnemy(3, new WalkingStrategy(), posArray));

        towerList.add(elementFactory.createTower(new Pos(1, 0)));
        towerList.add(elementFactory.createTower(new Pos(2, 0)));

        assertEquals(3, enemyList.size());
        assertEquals(2, towerList.size());
        assertThrows(IllegalArgumentException.class, () -> elementFactory.createEnemy(7, new WalkingStrategy(), posArray));
    }
}
