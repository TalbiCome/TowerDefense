package org.example;

/**
 * Elements class, for moving elements of the game, Tower and enemy
 */
public abstract class Elements {
    /**
     * position of the elements
     */
    Pos position;
    /**
     * damage the elements will do to its enemy
     */
    int damage;

    public Pos getPosition() {
        return position;
    }
}
