package org.example.Input;

import java.awt.*;

public class MyButton {

    public int x,y,width, height;
    private String label;
    private Rectangle bounds;

    public MyButton(String label,int x, int y, int width, int height){
        this.label = label;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBound();
    }

    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,width,height);
        g.setColor(Color.GRAY);
        g.drawRect(x,y,width,height);
        
        drawText(g);
        

    }

    private void drawText(Graphics g){
        int w = g.getFontMetrics().stringWidth(label);
        int h = g.getFontMetrics().getHeight();
        g.drawString(label,x+width/2 - w/2,y+height/2 + h/4);
    }

    private void initBound(){
        this.bounds = new Rectangle(x,y+32,width,height);
    }

    public Rectangle getBounds(){return bounds;}


}
