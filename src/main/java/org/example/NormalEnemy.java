package org.example;

/**
 * a normal enemy is an enemy with a normal amount speed and a normal amount of HP
 */
public class NormalEnemy extends Enemy{
    public NormalEnemy(Pos[] posArray, Strategy strat){
        super(2, 2, posArray, strat);
    }
}
