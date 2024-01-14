package org.example;

import java.util.Stack;

public class FlyingStrategy implements Strategy{
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
