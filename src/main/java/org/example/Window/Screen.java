package org.example.Window;

import org.example.Tiles.*;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {

    /**
     * The window we use
     */
    private Window window;
    /**
     * TilesManager to get the grid
     */
    private TilesManager TManager;


    /**
     * Constructor of the Screen Class
     * @param window the unique window we use
     */
    public Screen(Window window){
        this.window = window;
        TManager = new TilesManager();
    }

    /**
     * Make sure we can show what we want on the screen
     * @param g the Graphics
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        window.getRender().render(g);
    }

    /**
     * getter of the TilesManager
     * @return TManager
     */
    public TilesManager getTManager() {
        return TManager;
    }
}
