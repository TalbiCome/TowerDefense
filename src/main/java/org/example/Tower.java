package org.example;

public class Tower extends Elements{
    int reloadTime;     //Time between shots
    int reloadTimer;    //Time left until next shot available;
    Enemy target = null;
    public Tower(Pos pos)
    {
        position = new Pos(pos);
        reloadTime = 2;
        reloadTimer = 0;
        damage = 1;
    }

    public boolean isReloading()
    {
        return reloadTimer > 0;
    }

    public boolean canShoot()
    {
        return reloadTimer <= 0;
    }

    /**
     * tire sur l'enemy passer que la tourelle vise actuellement
     */
    public void shootIfPossible()
    {
        if(canShoot())
        {
            target.applyDamageToSelf(damage);
            reloadTimer = reloadTime;
        }
        else
        {
            reloadTimer -= 1;
        }
    }
    public void shootAt()
    {
        if(target != null)
        {
            shootIfPossible();
            if(target.isDead)
            {
                target = null;
            }
        }
        else
        {
            if(isReloading())
            {
                reloadTimer -= 1;
            }
        }


    }

    public void assignNewTarget(Enemy newTarget)
    {
        if(newTarget.isDead)
        {
            throw new IllegalArgumentException("enemy must be alive to be assigned as target");
        }

        target = newTarget;


    }

    public void updateStatus()
    {
        shootAt();
    }
}
