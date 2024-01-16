package org.example;

public class ElementsFactory {
    private static ElementsFactory instance = null;

    protected ElementsFactory(){}

    public static ElementsFactory getInstance()
    {
        if(instance == null)
        {
            instance = new ElementsFactory();
        }
        return instance;
    }


    public Enemy createEnemy(int type, Strategy strategy, Pos[] posArray)
    {
        return switch (type) {
            case 1 -> new SlowEnemy(posArray, strategy);
            case 2 -> new NormalEnemy(posArray, strategy);
            case 3 -> new FastEnemy(posArray, strategy);
            default -> throw new IllegalArgumentException("invalid int, not corresponding to an enemy type");
        };
    }

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

    public Tower createTower(Pos pos)
    {
        return new Tower(pos);
    }
}
