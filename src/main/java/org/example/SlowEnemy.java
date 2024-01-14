package org.example;

public class SlowEnemy extends Enemy{
    public SlowEnemy(Pos[] posArray, Strategy strat){
        super(1, 4, posArray, strat);
    }
}
