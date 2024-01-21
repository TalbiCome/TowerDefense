package org.example.Tiles;

import java.util.ArrayList;

public class Tiles {
    private int x;
    private int y;
    private int typeID;
    private ArrayList<Tiles> neighbours;
    private Tiles next;
    private Tiles previous;
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

    public void setNeighbours(ArrayList<Tiles> neighbours){
        this.neighbours = neighbours;
    }

    public ArrayList<Tiles> getNeighbours() {
        return neighbours;
    }

    public Tiles getNext() {
        return next;
    }

    public Tiles getPrevious() {
        return previous;
    }

    public void setNext(Tiles next) {
        this.next = next;
    }

    public void setPrevious(Tiles previous) {
        this.previous = previous;
    }
}
