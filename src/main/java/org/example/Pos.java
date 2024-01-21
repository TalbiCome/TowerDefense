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
     * create the POS if the coordinates are not out of bounds of the screen
     * @param x coordinate
     * @param y coordinate
     */
    public Pos(int x, int y)
    {
        if(x > maxBoundX || x < minBoundX || y > maxBoundY || y < minBoundY) { //avoid position out of screen
            throw new IllegalArgumentException("a position can only be created if in the frame boundaries");
        }

        this.x = x;
        this.y = y;
    }

    /**
     * create a new pos from an already existing one to avoid using the same reference to an object
     * @param pos the created pos will have the same coordinates
     */
    public Pos(Pos pos)
    {
        this.x = pos.x;
        this.y = pos.y;
    }

    /**
     * is x value out of bound
     * @return true if yes, else return false
     */
    protected boolean isPosOutOfBoundX(int val)
    {
        return val > maxBoundX || val  < 0;
    }

    /**
     * is y value out of bound
     * @return true if yes, else return false
     */
    protected boolean isPosOutOfBoundY(int val)
    {
        return val > maxBoundY || val < 0;
    }

    /**
     * Move the actual position by adding the value in parameters to each axis. If the value exceed
     * the max/min bound them the set the value on the according bound
     * @param target the position the enemy will move to
     * @param moveDistance the distance in pixels the enemy will travel
     */
    public void moveTo(Pos target, int moveDistance)
    {
        if(isPosOutOfBoundX(target.x) || isPosOutOfBoundY(target.y))
        {
            throw new IllegalArgumentException("Target to move to is not in screen boundary");
        }

        int distXFromTarget = Math.abs(target.x - x);
        int distYFromTarget = Math.abs(target.y - y);

        if(distXFromTarget != 0)
        {
            if(distXFromTarget < moveDistance) //Si la cible est dans la porté de deplacement, on s'arrete dessus
            {
                x = target.x;
            }
            else
            {
                if(target.x < x) //cas ou la target est a gauche
                {
                    x = x - moveDistance;
                }
                else
                {
                    x = x + moveDistance;
                }

            }
        } else if (distYFromTarget != 0)        //Si la cible est dans la porté de deplacement, on s'arrete dessus
        {
            if(distYFromTarget < moveDistance)
            {
                y = target.y;
            }
            else
            {
                if(target.y < y) //cas ou la target est a gauche
                {
                    y = y - moveDistance;
                }
                else
                {
                    y = y + moveDistance;
                }
            }
        }
    }

    /**
     * check if two position have the same coordinates
     * @param pos1
     * @param pos2
     * @return true if pos1 == pos2
     */
    public static boolean arePosesEquals(Pos pos1, Pos pos2)
    {
        return pos1.x == pos2.x && pos1.y == pos2.y;
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}

}
