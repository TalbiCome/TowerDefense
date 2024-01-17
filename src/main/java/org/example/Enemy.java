package org.example;

import java.util.List;
import java.util.Stack;

public abstract class Enemy extends Elements {
    int speed; //nombre de pixels parcours par rafraichissemnt
    Strategy strategy;
    int HP;
    boolean isDead = false;
    boolean isAtEnd = false;
    Stack<Pos> trailStack = new Stack<Pos>();

    public Enemy(int speed, int HP, Pos[] posArray, Strategy strategy)
    {
        this.speed = speed;
        this.HP = HP;
        trailStack.addAll(List.of(posArray));
        if(!trailStack.isEmpty())
        {
            position = new Pos(trailStack.firstElement());
        }
        this.strategy = strategy;
    }

    public void moveToNextPos()
    {
        if(!isDead){ //on ne deplace pas un enemy mort
            strategy.moveToNextPos(this);
        }
    }

    protected boolean isAtNextPos()
    {
        return Pos.arePosesEquals(position, trailStack.firstElement());
    }

    protected boolean isAtEndPos()
    {
        return isAtEnd || trailStack.isEmpty();
    }

    public void applyDamageToSelf(int HPToRemove) {

        if(HPToRemove < 0) //Avoid giving HP
        {
            throw new IllegalArgumentException("Damage value must be >= 0");
        }

        if(!isDead) //To avoid cycling on it and obtaining a monster with 2147483647 HP
        {
            HP -= HPToRemove;
        }
        if(HP < 1)
        {
            isDead = true;
        }
    }

    public void updateStatus()
    {
        if(HP < 1)
        {
            isDead = true;
        }
        else if (isAtEndPos())
        {
            isAtEnd = true;
            isDead = true;
        }
        else
        {
            moveToNextPos();
        }
    }
}
