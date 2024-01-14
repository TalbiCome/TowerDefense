package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Purpose is to test if enemy base method are workin as intended
 */
public class TestEnemy {
    @Test
    void dyingTest()
    {
        Pos[] emptyPosArray = {};
        Strategy strategy = new WalkingStrategy();
        Enemy fastEnemy1 = new FastEnemy(emptyPosArray, strategy);
        Enemy fastEnemy2 = new FastEnemy(emptyPosArray, strategy);
        Enemy normalEnemy1 = new NormalEnemy(emptyPosArray, strategy);
        Enemy normalEnemy2 = new NormalEnemy(emptyPosArray, strategy);
        Enemy slowEnemy1 = new SlowEnemy(emptyPosArray, strategy);
        Enemy slowEnemy2 = new SlowEnemy(emptyPosArray, strategy);

        //Killing enemy1
        fastEnemy1.applyDamageToSelf(fastEnemy1.HP + 50);
        normalEnemy1.applyDamageToSelf(normalEnemy1.HP + 90);
        slowEnemy1.applyDamageToSelf(slowEnemy1.HP + 25089);

        //Keeping enemy2 alive at 1HP
        fastEnemy2.applyDamageToSelf( Math.abs(fastEnemy2.HP - 1));
        normalEnemy2.applyDamageToSelf( Math.abs(normalEnemy2.HP - 1));
        slowEnemy2.applyDamageToSelf( Math.abs(slowEnemy2.HP - 1));

        //verifying which enemy are dead
        assertTrue(fastEnemy1.isDead);
        assertTrue(normalEnemy1.isDead);
        assertTrue(slowEnemy1.isDead);
        assertFalse(fastEnemy2.isDead);
        assertFalse(normalEnemy2.isDead);
        assertFalse(slowEnemy2.isDead);

        //verifying HP amount of alive enemy
        assertEquals(1, fastEnemy2.HP);
        assertEquals(1, normalEnemy2.HP);
        assertEquals(1, slowEnemy2.HP);

        //verifying that an already dead enemy don't take anymore damage
        int before = slowEnemy1.HP;
        slowEnemy1.applyDamageToSelf(50);
        assertEquals(before, slowEnemy1.HP);

        before = normalEnemy1.HP;
        normalEnemy1.applyDamageToSelf(50);
        assertEquals(before, normalEnemy1.HP);

        before = fastEnemy1.HP;
        fastEnemy1.applyDamageToSelf(50);
        assertEquals(before, fastEnemy1.HP);

        //Testing of exception throw if negative value in parameter
        assertThrows(IllegalArgumentException.class, () -> fastEnemy1.applyDamageToSelf(-50));
    }

    @Test
    void movingWalkingTest1()
    {
        Pos pos1 = new Pos(0, 0);
        Pos pos2 = new Pos(0,50);
        Pos pos3 = new Pos(50,50);
        Pos[] posArray = {pos1, pos2, pos3};
        Strategy strategy = new WalkingStrategy();

        Enemy fastEnemy1 = new FastEnemy(posArray, strategy);
        Enemy normalEnemy1 = new NormalEnemy(posArray, strategy);
        Enemy slowEnemy1 = new SlowEnemy(posArray, strategy);

        int updateNumber = 0;
        for(; updateNumber < 10; updateNumber++)
        {
            fastEnemy1.moveToNextPos();
            normalEnemy1.moveToNextPos();
            slowEnemy1.moveToNextPos();
        }

        assertFalse(fastEnemy1.isAtEnd);
        assertFalse(normalEnemy1.isAtEnd);
        assertFalse(slowEnemy1.isAtEnd);

        for(; updateNumber < 110; updateNumber++)
        {
            fastEnemy1.moveToNextPos();
            normalEnemy1.moveToNextPos();
            slowEnemy1.moveToNextPos();
        }

        assertTrue(fastEnemy1.trailStack.isEmpty());
        assertTrue(normalEnemy1.trailStack.isEmpty());
        assertTrue(slowEnemy1.trailStack.isEmpty());
        assertTrue(fastEnemy1.isAtEnd);
        assertTrue(normalEnemy1.isAtEnd);
        assertTrue(slowEnemy1.isAtEnd);
        assertTrue(fastEnemy1.isDead);
        assertTrue(normalEnemy1.isDead);
        assertTrue(slowEnemy1.isDead);
    }

    @Test
    void movingWalkingTest2()
    {
        Pos pos1 = new Pos(0, 0);
        Pos pos2 = new Pos(0,50);
        Pos pos3 = new Pos(50,50);
        Pos[] posArray = {pos1, pos2, pos3};
        Strategy strategy = new WalkingStrategy();

        Enemy fastEnemy1 = new FastEnemy(posArray, strategy);
        int expectedValue = 0;
        for(int i = 1; fastEnemy1.position.y < 50; i++)
        {
            expectedValue = i*fastEnemy1.speed;
            fastEnemy1.moveToNextPos();
            if(expectedValue < 50)
            {
                assertEquals(expectedValue, fastEnemy1.position.y);
            }
            else
            {
                assertEquals(50, fastEnemy1.position.y);
            }
        }

        for(int i = 1; fastEnemy1.position.x < 50; i++)
        {
            expectedValue = i*fastEnemy1.speed;
            fastEnemy1.moveToNextPos();
            if(expectedValue < 50)
            {
                assertEquals(expectedValue, fastEnemy1.position.x);
            }
            else
            {
                assertEquals(50, fastEnemy1.position.x);
            }
        }
    }

    @Test
    void movingFlyingTest() {
        Pos pos1 = new Pos(0, 0);
        Pos pos2 = new Pos(0, 50);
        Pos pos3 = new Pos(50, 50);
        Pos pos4 = new Pos(50, 0);
        Pos[] posArray = {pos1, pos2, pos3, pos4};
        Strategy strategy = new FlyingStrategy();

        Enemy fastEnemy1 = new FastEnemy(posArray, strategy);
        int expectedValue = 0;
        for (int i = 1; !fastEnemy1.isAtEnd; i++) {
            expectedValue = i * fastEnemy1.speed;
            fastEnemy1.moveToNextPos();
            if (expectedValue < 50) {
                assertEquals(expectedValue, fastEnemy1.position.x);
            } else {
                assertEquals(50, fastEnemy1.position.x);
            }
        }
    }

    @Test
    void enemyUpdate()
    {
        Pos pos1 = new Pos(0, 0);
        Pos pos2 = new Pos(0, 50);
        Pos[] posArray = {pos1, pos2};
        Strategy strategy = new FlyingStrategy();

        Enemy fastEnemy1 = new FastEnemy(posArray, strategy);
        Enemy normalEnemy1 = new NormalEnemy(posArray, strategy);

        for(int i = 0; i < 10; i++)
        {
            fastEnemy1.updateStatus();
            normalEnemy1.updateStatus();
        }

        for(int i = 0; i < 10; i++)
        {
            fastEnemy1.updateStatus();
            normalEnemy1.applyDamageToSelf(1);
            normalEnemy1.updateStatus();

        }

        assertTrue(fastEnemy1.isAtEnd);
        assertFalse(normalEnemy1.isAtEnd);
        assertTrue(normalEnemy1.isDead);
        assertEquals(50, fastEnemy1.position.y);
        assertEquals(22, normalEnemy1.position.y);
    }
}
