package org.example;

import javax.swing.JFrame;

public class GameWindow extends JFrame{

    private GameView gameView;
    private double timePerFrame;
    private long lastFrame;
    private double timePerUpdate;
    private long lastUpdate;

    private int updates;
    private long lastTimeUPS;

    public GameWindow(){
        setSize(700,700); //640 because it gives us 20 column and row of 32x32 squares
        setDefaultCloseOperation(EXIT_ON_CLOSE); // To stop the programme when we close the window
        setLocationRelativeTo(null); //The window is created at the center of the screen

        gameView = new GameView();
        add(gameView);

        timePerFrame = 1000000000.0/30.0; //Frame per second
        timePerUpdate = 1000000000.0/60.0;

        setVisible(true);
    }

    private void loopGame(){
        while (true) {
            if(System.nanoTime() - lastUpdate >= timePerUpdate){
                updateGame();
                callUPS();
            }

            if (System.nanoTime() - lastFrame >= timePerFrame) {
                lastFrame = System.nanoTime();
                repaint();
            }
        }
    }

    private void callUPS(){
        if(System.currentTimeMillis() - lastTimeUPS >= 1000){
            System.out.println("UPS : " + updates);
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
        }
    }
    private void updateGame() {
        updates++;
        lastUpdate = System.nanoTime();
        //System.out.println("Game updated");
    }



    public static void main(String[] args){
        GameWindow gameWindow = new GameWindow();
        gameWindow.loopGame();

    }

}
