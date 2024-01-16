package org.example;

public class GameController {
    Game game = Game.getInstance();
    int monsterSpawnDelay = 5; //updates number between monster spawn
    int monsterSpawnDelayCounter = 5; //updates number before next monster spawn

    public void initGameLevel(int levelNum)
    {
        game.resetLevel();
        game.loadLevel(levelNum);
    }

    public void addTower(int x, int y)
    {
        game.spawnTower(new Pos(x, y));
    }

    public void updateGameStatus()
    {
        if(monsterSpawnDelayCounter < 1)
        {
            game.spawnNextEnemy();
            monsterSpawnDelayCounter = monsterSpawnDelay;
        }
        else
        {
            monsterSpawnDelayCounter -= 1;
        }

        game.updateActiveEnemys();
        game.updateTower();
    }

}
