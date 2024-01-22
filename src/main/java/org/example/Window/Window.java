package org.example.Window;
import org.example.Input.*;
import org.example.Scenes.*;
import org.example.Tiles.LevelManager;

import javax.swing.*;

public class Window extends JFrame implements Runnable {
    //Variables
    /**
     * the only screen we use
     */
    private Screen screen;

    /**
     * The thread for the view and the game
     */
    private Thread gameThread;

    /**
     * The listener for the action of the mouse
     */
    private Mouse MListener;

    /**
     * The Render to show what we change on the screen
     */
    private Render render;
    /**
     * The levelManager to change level
     */
    private LevelManager LManager;
    /**
     * Scene Menu to get the menu of the game
     */
    private Menu menu;
    /**
     * Scene Playing to show the element when the game is starting
     */
    private Playing playing;

    /**
     * the number of frame we need to have each second
     */
    private double timePerFrame;
    /**
     * the last time the screen has been refreshed
     */
    private long lastFrame;

    /**
     * the number of time we update the view each second
     */
    private double timePerUpdate;
    /**
     * the last time the game has been updated
     */
    private long lastUpdate;


    private int updates;
    /**
     * The last time the game has been updated in the second
     */
    private long lastTimeUPS;
    /**
     * the timer of the game
     */
    public int timer;

    /**
     * Loop for the game to run at 120 frame per second and 60 update per second
     */
    @Override
    public void run() {
        timePerFrame = 1000000000.0/120.0; //Frame per second
        timePerUpdate = 1000000000.0/60.0;

        while(true) {
            //Render
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                lastFrame = System.nanoTime();
                repaint();
            }

            if(System.nanoTime() - lastUpdate >= timePerUpdate){
                updateGame();
            }

            callUPS();
        }

    }

    /**
     * Constructor of the Window Class
     * Initialise all the components it needs to work properly
     */
    public Window(){
        initWindow(640);
        initScenes();
        add(screen);

        setVisible(true);

    }


    //Init

    /**
     * Create the window with the size we want
     * @param size of the window
     */
    private void initWindow(int size){
        setSize(size,size);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Create all Scene we need to change what we show to the user
     */
    private void initScenes(){
        screen = new Screen(this);
        render = new Render(this);
        LManager = new LevelManager(screen.getTManager());
        menu = new Menu(this);
        playing = new Playing(this);
    }

    /**
     * Create all the input we want to use with the mouse
     */
    public void intiInput(){
        MListener = new Mouse();
        addMouseListener(MListener);
        addMouseMotionListener(MListener);
        MListener.setGrid(screen.getTManager());
        requestFocus();
    }

    ///////////////////////////////////////////

    /**
     * Make sure we have 60 update per second
     */
    private void callUPS(){
        if(System.currentTimeMillis() - lastTimeUPS >= 1000){
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
            timer++;
        }
    }

    /**
     * Count the number of update
     */
    private void updateGame() {
        updates++;
        lastUpdate = System.nanoTime();
    }

    /**
     * Start the thread of the game and initialise the timer
     */
    public void startThread(){
        gameThread = new Thread(this){};
        gameThread.start();
        timer = 0;
    }

    //Getter/Setter

    /**
     * getter of the Render
     * @return render
     */
    public Render getRender(){
        return render;
    }

    /**
     * getter of the Playing scene
     * @return playing
     */
    public Playing getPlaying() {
        return playing;
    }

    /**
     * getter of the Menu scene
     * @return menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * getter of the Screen
     * @return screen
     */
    public Screen getScreen(){return screen;}

    /**
     * getter of the LevelManager
     * @return LManager
     */
    public LevelManager getLManager(){return LManager;}

    /**
     * getter of the Mouse
     * @return MListener
     */
    public Mouse getMouse() {return MListener;}

    /**
     * Reset the timer at the beginning of each level
     */
    public void beginTimer() {
        timer = 0;
    }
    //////////////////////////////////////////
}
