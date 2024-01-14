package org.example;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class TestJPanel extends JPanel {

    private Random random;
    private long lastTime;
    private int frame;



    public TestJPanel(){
        random = new Random();



    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int x =0; x < 20; x++){
            for(int y = 0; y < 20; y++){
                g.setColor(randomColor());
                g.fillRect(x*32,y*32,32,32);
            }
        }


        FPSCounter();


    }

    private void FPSCounter(){
        frame++;
        if(System.currentTimeMillis() - lastTime >= 1000){
            System.out.println("FPS : " + frame);
            frame = 0;
            lastTime = System.currentTimeMillis();
        }
    }

    public Color randomColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r,g,b);

    }


}
