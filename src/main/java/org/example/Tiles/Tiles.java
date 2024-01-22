package org.example.Tiles;

import java.util.ArrayList;

public class Tiles {

    /**
     * coordinate x,y of the tiles
     */
    private int x, y;
    /**
     * type of the tile
     */
    private int typeID;
    /**
     * the list of its neighbours
     */
    private ArrayList<Tiles> neighbours;
    /**
     * The next tile to form a path
     */
    private Tiles next;
    /**
     * The previous tile of the current one which form a path
     */
    private Tiles previous;

    /**
     * Constructor
     * @param x coordinate x on the window
     * @param y coordinate y on the window
     */
    public Tiles(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * get x
     * @return x position on the window
     */
    public int getColumn(){
        return this.x;
    }

    /**
     * getter of y
     * @return y position on the window
     */
    public int getRow(){
        return this.y;
    }

    /**
     * return the type of the tile
     * @return type of the tile between 0,1,2
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * Setter of the tile type
     * @param typeID an int between 0,1,2
     */
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    /**
     * set the neighbours of the tile
     * @param neighbours is a list of all neighbours of the tile
     */
    public void setNeighbours(ArrayList<Tiles> neighbours){
        this.neighbours = neighbours;
    }

    /**
     * getter of the neighbours list of the tile
     * @return the list of neighbours of the tile
     */
    public ArrayList<Tiles> getNeighbours() {
        return neighbours;
    }

    /**
     * getter of the next tile
     * @return give the tile after the current one to form a path
     */
    public Tiles getNext() {
        return next;
    }

    /**
     * getter of the previous tile of the current one
     * @return the tile before the current one
     */
    public Tiles getPrevious() {
        return previous;
    }

    /**
     * set the next tile of the current one
     * @param next is the tile we want to be next and form a path with the current tile
     */
    public void setNext(Tiles next) {
        this.next = next;
    }

    /**
     * set the previous tile of the current one
     * @param previous is the tile before the current tile to form a path
     */
    public void setPrevious(Tiles previous) {
        this.previous = previous;
    }
}
