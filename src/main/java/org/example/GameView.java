package org.example;

import org.example.Window.Window;

public class GameView {

    public Window window;

    public void launchWindow(){
        window = new Window();
        window.intiInput();
        window.startThread();
    }

}
