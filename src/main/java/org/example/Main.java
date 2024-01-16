package org.example;
public class Main {
    public static boolean mainGameLoop(GameController gameController,int level)
    {
        System.out.println("loading level " + level);
        gameController.initGameLevel(1);
        while (!gameController.game.didPlayerLost() || !gameController.game.areAllEnemyDead())
        {
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

        gameController.startWindow();
        gameResult = mainGameLoop(gameController, 1);

        if(gameResult)
        {
            deathScreen();
        }

    }


}