package org.example;

public class Pos {
    int x;
    int y;
    static final int maxBoundX = 1920;
    static final int maxBoundY = 1080;
    static final int minBoundX = 0;
    static final int minBoundY = 0;

    public boolean isPosOutOfBoundX()
    {
        return x > maxBoundX || x  < 0;
    }

    public boolean isPosOutOfBoundY()
    {
        return y > maxBoundY || y < 0;
    }

    void move(int xMovement, int yMovement)
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
