package org.example;

import javax.swing.JPanel;
import java.awt.Graphics;


public class TestJPanel extends JPanel {

    public TestJPanel(){

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int x =0; x < 20; x++){
            for(int y = 0; y < 20; y++){
                g.drawRect(x*32,y*32,32,32);
            }
        }

    }

}
