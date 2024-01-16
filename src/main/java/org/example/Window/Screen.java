package org.example.Window;

import org.example.Tiles.*;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {

    private Window window;

    private TilesManager TManager;

    public Screen(Window window){
        this.window = window;
        TManager = new TilesManager();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
