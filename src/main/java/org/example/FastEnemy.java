package org.example;

/**
 * a fast enemy is an enemy with a lot of speed and a small amount of HP
 */
public class FastEnemy extends Enemy{
    public FastEnemy(Pos[] posArray, Strategy strat)
    {
        super(4, 1, posArray, strat);
    }
}
