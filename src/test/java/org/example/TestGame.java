package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGame {

    Game prepareTest()
    {
        Game game = Game.getInstance();
        game.resetLevel();
        game.loadTestLevel(1);
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

        for(int i = 0 ; i < 100; i++)
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

        for(int i = 0 ; i < 110; i++)
        {
            game.spawnNextEnemy();
            game.updateActiveEnemies();
            game.updateTower();
        }
        assertTrue(game.didPlayerLost());
        assertTrue(game.areAllEnemyDead());
    }
}
