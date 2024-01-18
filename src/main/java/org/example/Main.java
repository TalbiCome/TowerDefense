package org.example;
import java.sql.Time;
import java.util.Scanner;
public class Main {

    public static int mainMenuUserInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter something: ");
        int userInput = scanner.nextInt();
        System.out.println("You entered: " + userInput);
        return userInput;
    }

    public static boolean mainGameLoop(GameController gameController,int level)
    {
        System.out.println("loading level " + level);
        gameController.initGameLevel(1);
        while (!gameController.game.didPlayerLost() || !gameController.game.areAllEnemyDead())
        {
            //coreler l'update avec l'image et la frequence d'update
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
        boolean gameResultPlayerLost = false;
        gameController.startWindow();
        int userInput = 0;
        while(userInput != 2)
        {
            System.out.println("Main menu : \n1) load level 1\n2) close game");
            userInput = mainMenuUserInput();

            switch (userInput)
            {
                case 1:
                    gameResultPlayerLost = mainGameLoop(gameController, 1);
                    break;
                case 2:
                    System.out.println("closing game");
                    return;
            }
            if(gameResultPlayerLost)
            {
                deathScreen();
            }
        }
    }


}