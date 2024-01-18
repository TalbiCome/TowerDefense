package org.example;

public class WalkingStrategy implements Strategy{
    /**
     * move the enemy to the next position place at index 0 of the trailStack in a straight line by an increments of Enemy. Speed
     * If the enemy as no more position to go then update its boolean value isAtEnd end isDead to True
     * If the enemy is not at the last position of the position stack then move the enemy
     * If the enemy is at the position on top of the stack, defile it and make the enemy move to the next one
     * @param enemy the enemy we want to move
     */
    @Override
    public void moveToNextPos(Enemy enemy)
    {
        if(enemy.trailStack.isEmpty())// il est a destionation
        {
            enemy.isAtEnd = true;
            enemy.isDead = true;
        }
        else
        {
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
