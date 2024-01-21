package org.example.Scenes;

public enum GameStates {
    PLAYING, MENU;

    /**
     * Start the game on the MENU page
     */
    public static GameStates gameStates = MENU;

    /**
     * Change the gameStates to switch between scenes
     * @param gameStates the new scene we want to use
     */
    public static void setGameStates(GameStates gameStates) {
        GameStates.gameStates = gameStates;
    }
}
