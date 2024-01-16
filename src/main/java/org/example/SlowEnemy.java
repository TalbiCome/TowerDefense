package org.example;
/**
 * a slow enemy is an enemy with a lot of HP and a small amount of speed
 */
public class SlowEnemy extends Enemy{
    public SlowEnemy(Pos[] posArray, Strategy strat){
        super(1, 4, posArray, strat);
    }
}
