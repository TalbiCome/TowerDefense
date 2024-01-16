package org.example;

/**
 * Singleton used to generate Elements -> Enemy or Tower
 */
public class ElementsFactory {
    /**
     * contain the only allowed instance of ElementsFactory
     */
    private static ElementsFactory instance = null;

    protected ElementsFactory(){};

    /**
     * method to use instead of creating a new instance, will give the already existing one
     * @return the factory instance
     */
    public static ElementsFactory getInstance()
    {
        if(instance == null)
        {
            instance = new ElementsFactory();
        }
        return instance;
    }

    /**
     * generate a new enemy with the specified parameter and returns it
     * @param type the encode type of the enemy, 1 = slow, 2 = normal, 3 = fast
     * @param strategy the strategy used by the enemy, either WalkingStrategy or FlyingStrategy
     * @param posArray  the path that the enemy will follow
     * @return the created enemy
     */
    public Enemy createEnemy(int type, Strategy strategy, Pos[] posArray)
    {
        return switch (type) {
            case 1 -> new SlowEnemy(posArray, strategy);
            case 2 -> new NormalEnemy(posArray, strategy);
            case 3 -> new FastEnemy(posArray, strategy);
            default -> throw new IllegalArgumentException("invalid int, not corresponding to an enemy type");
        };
    }

    /**
     * generate a new enemy with the specified parameter and returns it, do not need a strategy instead 1 to 3 = Walking and 4 to 6 = flying
     * @param type the encode type of the enemy, 1 = WalkingSlow, 2 = WalkingNormal, 3 = WalkingFast, 4 = FlyingSlow, 5 = FlyingNormal, 6 = FlyingFast
     * @param posArray  the path that the enemy will follow
     * @return the created enemy
     */
    public Enemy createEnemy(int type, Pos[] posArray)
    {
        return switch (type) {
            case 1 -> new SlowEnemy(posArray, new WalkingStrategy());
            case 2 -> new NormalEnemy(posArray, new WalkingStrategy());
            case 3 -> new FastEnemy(posArray, new WalkingStrategy());
            case 4 -> new SlowEnemy(posArray, new FlyingStrategy());
            case 5 -> new NormalEnemy(posArray, new FlyingStrategy());
            case 6 -> new FastEnemy(posArray, new FlyingStrategy());
            default -> throw new IllegalArgumentException("invalid int, not corresponding to an enemy type");
        };
    }

    /**
     * generate and return a new tower
     * @param pos the position of the tower to create
     * @return a tower
     */
    public Tower createTower(Pos pos)
    {
        return new Tower(pos);
    }
}
