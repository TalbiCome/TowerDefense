package org.example;

import java.util.List;
import java.util.Stack;

/**
 * Enemy class contain the Enemy data and its logic
 * enemy move in straight lines, walking or flying
 */
public abstract class Enemy extends Elements {
    /**
     * the number of pixels the enemy will travel in one position update
     */
    int speed; //nombre de pixels parcours par rafraichissemnt
    /**
     * Walking or flying, walking enemy follow the path whereas flying enemy go in straight line to the main base
     */
    Strategy strategy;
    /**
     * contain the remaining HP of the enemy
     */
    int HP;
    /**
     * indicate if an enemy is dead or not
     */
    boolean isDead = false;
    /**
     * indicate if an enemy as arrived at the main base
     */
    boolean isAtEnd = false;

    /**
     * contain the path the enemy will take. The enemy will go to the position of the first elements of this Stack
     */
    Stack<Pos> trailStack = new Stack<Pos>();

    /**
     *
     * @param speed the number of pixels the enemy will travel in one position update
     * @param HP contain the remaining HP of the enemy
     * @param posArray contain the path the enemy will take. The enemy will go to the position of the first elements of it
     * @param strategy Walking or flying, walking enemy follow the path whereas flying enemy go in straight line to the main base
     */
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

    /**
     * will move the enemy toward the next first elements of its movement list
     * the speed define the number of pixels the enemy will travel
     */
    public void moveToNextPos()
    {
        if(!isDead){ //on ne deplace pas un enemy mort
            strategy.moveToNextPos(this);
        }
    }

    /**
     * check if the enemy position is the same as the first position of its position list
     * @return true if the enemy as arrived at its next pos, else return false
     */
    protected boolean isAtNextPos()
    {
        return Pos.arePosesEquals(position, trailStack.firstElement());
    }

    /**
     * check if the enemy as finished to move, is at the main base if he finished
     * @return true if the enemy as arrived
     */
    protected boolean isAtEndPos()
    {
        return isAtEnd || trailStack.isEmpty();
    }

    /**
     * will reduce actual HP of the enemy, and check if the enemy is still alive and update its status
     * @param HPToRemove remove this amount of HP
     */
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

    /**
     * update boolean values of the enemy -> isDead, isAtEnd
     * if the enemy is still alive and not at the end the enemy move
     */
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
