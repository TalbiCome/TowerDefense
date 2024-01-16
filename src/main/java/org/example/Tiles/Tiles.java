package org.example.Tiles;

public class Tiles {
    private int x;
    private int y;
    private int typeID;

    public Tiles(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getColumn(){
        return this.x;
    }

    public int getRow(){
        return this.y;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
}
