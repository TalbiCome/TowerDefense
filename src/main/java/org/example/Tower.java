package org.example;

/**
 * Towers elements of the game
 */
public class Tower extends Elements{
    /** Time between shots*/
    int reloadTime;
    /** Time left until next shot is available*/
    int reloadTimer;

    /** the enemy target the tower will shoot at*/
    Enemy target = null;

    /**
     * create a new tower
     * @param pos the position the tower will use
     */
    public Tower(Pos pos)
    {
        position = new Pos(pos);
        reloadTime = 2;
        reloadTimer = 0;
        damage = 1;
    }

    /**
     * check if the tower need to reload
     * @return yes if the tower need to reload, else return false
     */
    public boolean isReloading()
    {
        return reloadTimer > 0;
    }

    /**
     * check if the tower can shoot
     * @return true if the tower can shoot, else false
     */
    public boolean canShoot()
    {
        return reloadTimer <= 0;
    }

    /**
     * fire on the actual target of the tower if not reloading else, reload
     */
    protected void shootIfPossible()
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

    /**
     * fire on the actual target of the tower if not reloading else, reload
     * if there is no valid target then reload or don't shoot
     */
    public void shootAtTarget()
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

    /**
     * assign a new valid target to the tower
     * @param newTarget an enemy to target
     */
    public void assignNewTarget(Enemy newTarget)
    {
        if(newTarget.isDead)
        {
            throw new IllegalArgumentException("enemy must be alive to be assigned as target");
        }
        target = newTarget;
    }

    public Pos getPos(){
        return position;
    }
}
