package org.example;

import java.util.Stack;

/**
 * Flying strategy allow an enemy to move directly to the end of the path in a straight line
 */
public class FlyingStrategy implements Strategy{
    /**
     * move the enemy to the next position place at index 0 of the trailStack in a straight line by an increments of Enemy.speed
     * If the enemy as no more position to go then update its boolean value isAtEnd end isDead to True
     * If the enemy is not at the last position of the position stack then move the enemy
     * Flying strategy defile the whole list and only keep the last position.
     * @param enemy the enemy we want to move
     */
    @Override
    public void moveToNextPos(Enemy enemy)
    {
        if(enemy.trailStack.isEmpty())// the enemy as arrived at its final destination
        {
            enemy.isAtEnd = true;
            enemy.isDead = true;
        }
        else
        {
            if(enemy.trailStack.size() > 1){
                Pos toKeep = enemy.trailStack.pop();
                enemy.trailStack.clear();
                enemy.trailStack.add(toKeep);
            }
            if(enemy.isAtNextPos()) //Il est arrivé a la position en tete de pile
            {
                enemy.trailStack.remove(0);
                if(enemy.trailStack.isEmpty())// il est a destionation
                {
                    enemy.isAtEnd = true;
                    enemy.isDead = true;
                }else
                {
                    enemy.position.moveTo(enemy.trailStack.firstElement(), enemy.speed);
                }
            }
            else
            {
                enemy.position.moveTo(enemy.trailStack.firstElement(), enemy.speed);
            }
        }
    }
}
