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

    @Override
    public void run() {
        timePerFrame = 1000000000.0/30.0; //Frame per second
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
        LManager = new LevelManager(1,screen.getTManager());
        menu = new Menu(this);
        playing = new Playing(this);
    }

    public void intiInput(){
        MListener = new Mouse();
        //KListener = new Keyboard();
        addMouseListener(MListener);
        addMouseMotionListener(MListener);
        MListener.setGrid(screen.getTManager());
        //addKeyListener(KListener);
        requestFocus();
    }

    ///////////////////////////////////////////

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
    }

    public void startThread(){
        gameThread = new Thread(this){};
        gameThread.start();
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
    //////////////////////////////////////////

    //Main

    public static void main(String[] args){
        Window window = new Window();
        window.intiInput();
        window.startThread();
    }

}
