package org.example;

import org.example.Input.Keyboard;
import org.example.Window.Window;

public class GameView {

    public Window window;
    public Keyboard KListener;

    public void launchWindow(){
        window = new Window();
        window.intiInput();
        window.startThread();
        KListener = new Keyboard(this);
        window.addKeyListener(KListener);

    }

    public void switchLevel(int i){
        window.getLManager().levelSwitch(i);
    }

}
