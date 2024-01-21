package org.example.Scenes;

public enum GameStates {
    PLAYING, MENU;

    public static GameStates gameStates = MENU;

    public static void setGameStates(GameStates gameStates) {
        GameStates.gameStates = gameStates;
    }
}
