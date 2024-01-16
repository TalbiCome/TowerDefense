package org.example.Window;
import org.example.Input.*;
import org.example.Scenes.*;

import javax.swing.*;

public class Window extends JFrame implements Runnable {
    //Variables
    private Screen screen;

    private Thread gameThread;

    private Mouse MListener;
    private Keyboard KListener;

    private Render render;
    private Menu menu;
    private Playing playing;

    @Override
    public void run() {

    }

    public Window(){
        initWindow(640);
        initScenes();
        add(screen);


    }

    private void initWindow(int size){
        setSize(size,size);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initScenes(){

    }


}
