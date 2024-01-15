package org.example;

public class ElementsFactory {
    private static ElementsFactory instance = null;

    protected ElementsFactory(){};

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

    public Tower createTower(Pos pos)
    {
        return new Tower(pos);
    }
}
