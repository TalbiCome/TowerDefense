package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGame {

    Game prepareTest()
    {
        Game game = Game.getInstance();
        game.resetLevel();
        game.loadLevel(0);
        game.addEnemy(0);
        return game;
    }
    @Test
    void levelLoadingTest()
    {
        Game game = prepareTest();
        assertEquals(30, game.headQuarterHP);
        assertTrue(game.activeEnemies.isEmpty());
        assertTrue(game.activeTowers.isEmpty());
    }

    @Test
    void GameTest()
    {
        Game game = prepareTest();
        game.spawnTower(new Pos(0, 0));
        for(int i = 0 ; i < 10000; i++)
        {
            game.spawnNextEnemy();
            game.updateActiveEnemies();
            game.updateTower();
        }
        game.removeTower(new Pos(0, 0));
        assertFalse(game.didPlayerLost());
        assertTrue(game.areAllEnemyDead());
        assertTrue(game.activeTowers.isEmpty());
    }

    @Test
    void lostGameTest()
    {
        Game game = prepareTest();
        game.headQuarterHP = 4;

        //needed to have enough enemies
        game.loadLevel(0);
        game.addEnemy(0);
        game.loadLevel(0);
        game.addEnemy(0);
        game.loadLevel(0);
        game.addEnemy(0);
        game.loadLevel(0);

        for(int i = 0 ; i < 1100; i++)
        {
            game.spawnNextEnemy();
            game.updateActiveEnemies();
            game.updateTower();
        }
        assertTrue(game.didPlayerLost());
        assertTrue(game.areAllEnemyDead());
    }
}
