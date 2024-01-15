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

        int deathTime = -1;
        for(int i = 0; i < 20; i++)
        {
            enemy.updateStatus();
            if(enemy.isDead && deathTime == -1)
            {
                deathTime = i;
            }
            t1.updateStatus();
            t2.updateStatus();
        }

        //We verify that the enemy is dead and as stopped at the right time
        assertTrue(enemy.isDead);
        assertTrue(enemy.HP < 1);
        assertEquals(deathTime*enemy.speed, enemy.position.x);

        //We verify that tower keep reloading even if enemy is dead
        assertEquals(0, t1.reloadTimer);
        assertEquals(0, t2.reloadTimer);

        //We verify that assigning a dead enemy to a tower is not possible
        assertThrows(IllegalArgumentException.class, () -> t1.assignNewTarget(enemy));
    }
}
