package org.example.Input;

import java.awt.*;

public class MyButton {

    /**
     * x : coordinate x on the window
     * y : coordinate y on the window
     * width : width size of the button
     * height : height size of the button
     */
    public int x,y,width, height;
    /**
     * label : Text to write on the button
     */
    private String label;
    /**
     * HitBox/Boundary of the button;
     */
    private Rectangle bounds;

    /**
     * Constructor of the MyButton Class
     * @param label Text to write on the button
     * @param x coordinate x on the window
     * @param y coordinate y on the window
     * @param width width size of the button
     * @param height height size of the button
     */
    public MyButton(String label,int x, int y, int width, int height){
        this.label = label;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBound();
    }

    /**
     * Draw the button on the window when call
     * @param g
     */
    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,width,height);
        g.setColor(Color.GRAY);
        g.drawRect(x,y,width,height);
        
        drawText(g);
        

    }

    /**
     * Draw the text on the button
     * @param g
     */
    private void drawText(Graphics g){
        int w = g.getFontMetrics().stringWidth(label);
        int h = g.getFontMetrics().getHeight();
        g.drawString(label,x+width/2 - w/2,y+height/2 + h/4);
    }

    /**
     * Initialise and give the boundary of the button to know when we clicked if we are on it
     */
    private void initBound(){
        this.bounds = new Rectangle(x,y+32,width,height);
    }

    /**
     * Getter of the boundary
     * @return bounds a rectangle which is the hitbox of the button
     */
    public Rectangle getBounds(){return bounds;}


}
