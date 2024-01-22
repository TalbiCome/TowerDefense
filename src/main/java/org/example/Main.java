package org.example;

import org.example.LevelBuilder.FileReading;

import java.io.File;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Main {
    public static boolean mainGameLoop(GameController gameController,int level)
    {
        System.out.println("loading level " + level);
        gameController.initGameLevel(level);
        while (!gameController.game.didPlayerLost() && !gameController.game.areAllEnemyDead())
        {
            try {
                TimeUnit.MICROSECONDS.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //regarder clique souris
            gameController.updateGameStatus();
        }

        return gameController.game.didPlayerLost();
    }

    public static void deathScreen()
    {
        System.out.println("you lost");
    }
    public static void main(String[] args)
    {

        GameController gameController = new GameController();
        boolean gameResult;

        int levelNum = 0;
        int maxLevelNum = 10;
        gameController.startWindow();
        while (levelNum <= maxLevelNum )
        {
            File f = new File("src/main/java/org/example/LevelBuilder/LevelFiles/enemyList_"+ levelNum +  ".txt");
            if(f.exists() && f.isFile())
            {
                gameResult = mainGameLoop(gameController, levelNum);
                if(gameResult)
                {
                    deathScreen();
                    break;
                }
                else
                {
                    System.out.println("you won");
                    levelNum++;
                }
            }
            else
            {
                break;
            }
        }

        System.out.println("gg you finished the game");
        System.exit(0);



    }


}