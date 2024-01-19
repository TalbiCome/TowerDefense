package org.example.LevelBuilder;

public class LevelDirector {

    public Level createLevel(LevelBuilderInterface builder, int levelNum)
    {
        builder.buildLevel();

        builder.buildMap(levelNum);
        builder.buildPath(levelNum);
        builder.buildEnemiesList(levelNum);
        return builder.getLevel();
    }
}
