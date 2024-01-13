package org.example;

public class Pos {
    /*** x-axis value of the position*/
    int x;
    /*** y-axis value of the position*/
    int y;
    /*** maxBound corresponding to the screen size in pixels*/
    static final int maxBoundX = 1920;
    /*** maxBound corresponding to the screen size in pixels*/
    static final int maxBoundY = 1080;
    /*** minBound corresponding to the screen size in pixels*/
    static final int minBoundX = 0;
    /*** minBound corresponding to the screen size in pixels*/
    static final int minBoundY = 0;

    /**
     * is x value out of bound
     * @return true if yes, else return false
     */
    protected boolean isPosOutOfBoundX()
    {
        return x > maxBoundX || x  < 0;
    }

    /**
     * is y value out of bound
     * @return true if yes, else return false
     */
    protected boolean isPosOutOfBoundY()
    {
        return y > maxBoundY || y < 0;
    }

    /**
     * Move the actual position by adding the value in parameters to each axis. If the value exceed
     * the max/min bound the set the value on the according bound
     * @param xMovement will be added to the actual x-axis position
     * @param yMovement will be added to the actual y-axis position
     */
    public void move(int xMovement, int yMovement)
    {
        x += xMovement;
        y += yMovement;
        if(isPosOutOfBoundX())
        {
            x = x < 0 ?  minBoundX :  maxBoundX;    //x out of bound because x < 0 if yes then x = lower bound
        }
        if(isPosOutOfBoundY())
        {
            y = y < 0 ?  minBoundY :  maxBoundY;    //y out of bound because y < 0 if yes then y = lower bound
        }
    }

}
