package org.example;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class TestJframe extends JFrame{

    private TestJPanel jpanel;
    private double timePerFrame;
    private long lastFrame;

    public TestJframe() {

        setSize(640, 640);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jpanel = new TestJPanel();
        add(jpanel);

        timePerFrame = 1000000000.0 / 60.0; // 1 000 000 000 can change FPS for the game

        setVisible(true);
    }

    private void loopGame(){
        while(true) {
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                lastFrame = System.nanoTime();
                repaint();
            } else {
                //Do nothing
            }
        }
    }

    public static void main(String[] args){
        TestJframe jframe = new TestJframe();
        jframe.loopGame();


    }

}
