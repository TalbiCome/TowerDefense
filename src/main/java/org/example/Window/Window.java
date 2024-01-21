package org.example.Window;
import org.example.Input.*;
import org.example.Scenes.*;
import org.example.Tiles.LevelManager;

import javax.swing.*;

public class Window extends JFrame implements Runnable {
    //Variables
    private Screen screen;

    private Thread gameThread;

    private Mouse MListener;
    private Keyboard KListener;

    private Render render;
    private LevelManager LManager;
    private Menu menu;
    private Playing playing;

    private double timePerFrame;
    private long lastFrame;

    private double timePerUpdate;
    private long lastUpdate;

    private int updates;
    private long lastTimeUPS;
    public int timer;

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

    public Window(){
        initWindow(640);
        initScenes();
        add(screen);

        setVisible(true);

    }

    //Init
    private void initWindow(int size){
        setSize(size,size);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initScenes(){
        screen = new Screen(this);
        render = new Render(this);
        LManager = new LevelManager(screen.getTManager());
        menu = new Menu(this);
        playing = new Playing(this);
    }

    public void intiInput(){
        MListener = new Mouse();
        addMouseListener(MListener);
        addMouseMotionListener(MListener);
        MListener.setGrid(screen.getTManager());
        requestFocus();
    }

    ///////////////////////////////////////////

    private void callUPS(){
        if(System.currentTimeMillis() - lastTimeUPS >= 1000){
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
            timer++;
        }
    }

    private void updateGame() {
        updates++;
        lastUpdate = System.nanoTime();
    }

    public void startThread(){
        gameThread = new Thread(this){};
        gameThread.start();
        timer = 0;
    }

    //Getter/Setter
    public Render getRender(){
        return render;
    }
    public Playing getPlaying() {
        return playing;
    }
    public Menu getMenu() {
        return menu;
    }
    public Screen getScreen(){return screen;}
    public LevelManager getLManager(){return LManager;}
    public Mouse getMouse() {return MListener;}

    public void beginTimer(){
        timer = 0;
    }
    public int getTimer() {
        return timer;
    }

    //////////////////////////////////////////
}
