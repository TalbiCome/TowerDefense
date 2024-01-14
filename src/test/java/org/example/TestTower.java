package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestTower {
    @Test
    void Tower()
    {
        Tower t1 = new Tower(new Pos(0, 1));
        Tower t2 = new Tower(new Pos(0, 2));
        Pos[] posArray = {new Pos(0, 0), new Pos(20, 0)};
        Enemy enemy = new SlowEnemy(posArray, new WalkingStrategy() );

        t1.assignNewTarget(enemy);
        t2.assignNewTarget(enemy);

        for(int i = 0; i < 20; i++)
        {
            enemy.updateStatus();
            t1.updateStatus();
            t2.updateStatus();
        }

        //On verifie que l'enemie est mort est c'est  arreté
        assertTrue(enemy.isDead);
        assertTrue(enemy.HP < 1);
        assertEquals(4, enemy.position.x);

        //on verifie si les tourelles continue de recharger même si elle n'ont plus de target
        assertEquals(0, t1.reloadTimer);
        assertEquals(0, t2.reloadTimer);
    }
}
