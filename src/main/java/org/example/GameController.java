package org.example;

/**
 * controller of the MVC design pattern
 */
public class GameController {
    /**
     * instance of the Game singleton
     */
    Game game = Game.getInstance();
    GameView gameView = new GameView(this);

    /**number of updates between monster spawn*/
    int monsterSpawnDelay = 5; //updates number between monster spawn

    /**number of updates until the next monster spawn*/
    int monsterSpawnDelayCounter = 5;

    /**
     * load a level in the game model
     * @param levelNum number of the desired level to load
     */
    public void initGameLevel(int levelNum)
    {
        game.resetLevel();
        game.loadLevel(levelNum);
    }

    /**
     * add a tower to the game model
     * @param x coordinate
     * @param y coordinate
     */
    public void addTower(int x, int y)
    {
        if(game.money >= Tower.towerCost) {
            game.spawnTower(new Pos(x, y));
            game.money -= Tower.towerCost;
        }
        else
        {
            System.out.println("not enough cash");
        }
    }

    /**
     * spawn an enemy if the delay is at 0, else decrement it
     * update each element from the active towers and enemy List
     */
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

        game.updateActiveEnemies();
        game.updateTower();
    }

    public void startWindow(){
        gameView.launchWindow();
    }

    public Game getGame() {
        return game;
    }
}
