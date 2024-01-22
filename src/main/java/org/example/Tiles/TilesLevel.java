package org.example.Tiles;

import org.example.Game;
import org.example.Pos;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class TilesLevel {

    /**
     * TilesManager to get the same everywhere
     */
    private TilesManager TManager;
    /**
     * The path in an Array of Pos
     */
    private ArrayList<Pos> path;

    /**
     * Constructor of TilesLevel Class
     * @param tilesManager is the same as everywhere else
     */
    public TilesLevel(TilesManager tilesManager){
        TManager = tilesManager;
        path = new ArrayList<>();
    }

    /**
     * set typesID, the right number for each tile and give back the map we currently use
     * @return the map we use for our current level
     */
    public int[][] level(){
        setTylesType(Game.getInstance().getLevel().map);
        setTylesType(Game.getInstance().getLevel().chemin);
        ArrayList<Tiles> pos = setPath(TManager.grid.get(9).get(0));
        convertToPos(pos);
        Pos[] give = new Pos[path.size()];
        for(int x = 0; x < path.size(); x++){
            give[x] = path.get(x);
        }
        Game.getInstance().getLevel().path = give;
        return Game.getInstance().getLevel().map;
    }

    /**
     * set the typeID of each tile to render them after with the right color
     * @param level the level we want to use
     */
    private void setTylesType(int[][] level){
        for(int x=0; x < 20; x++){
            for(int y=0; y <20; y++){
                if(level[x][y] != 3) {
                    TManager.grid.get(x).get(y).setTypeID(level[x][y]);
                    TManager.grid.get(x).get(y).setNext(null);
                    TManager.grid.get(x).get(y).setPrevious(null);
                }
            }
        }

    }

    /**
     * set the path from the first tile to the end of the path
     * stop if it is the last tile.
     * @param start the tile from where we want to start the path
     * @return ArrayList of each tile of the path in the right order
     */
    private ArrayList<Tiles> setPath(Tiles start ){
        ArrayList<Tiles> path = new ArrayList<>();
        start.setPrevious(null);
        path.add(start);

        boolean verif = true;
        int nextcheck = 0;
        while(verif){
            Tiles tile = getNextTiles(path.get(nextcheck),nextcheck);
            for(int x = 0; x < path.size(); x++){
                if(path.get(x) == tile){
                    verif = false;
                    break;
                }
            }
            if(verif == true){
                path.add(tile);
                nextcheck++;
            }
        }

        //System.out.println("Size of the path :" + path.size());
        return path;
    }

    /**
     * set the next and previous of each tile which compose the path
     * @param tiles the tile we want to check the neighbour
     * @param i only use for the first tile because it has no previous
     * @return the tile we need to add to our path with next and previous set for it
     */
    private Tiles getNextTiles(Tiles tiles,int i){
        for(int x=0; x < tiles.getNeighbours().size(); x++){
            if(tiles.getNeighbours().get(x).getTypeID() == 2 && i == 0){
                tiles.setNext(tiles.getNeighbours().get(x));
                tiles.getNeighbours().get(x).setPrevious(tiles);
                return tiles.getNeighbours().get(x);
            }
            else {
                if (tiles.getNeighbours().get(x).getTypeID() == 2 &&
                        tiles.getNeighbours().get(x).getNext() == null &&
                        limitMovement(tiles, tiles.getNeighbours().get(x))
                ) {
                    tiles.setNext(tiles.getNeighbours().get(x));
                    tiles.getNeighbours().get(x).setPrevious(tiles);
                    return tiles.getNeighbours().get(x);
                }
            }
        }

        return tiles;

    }

    /**
     * Make sure we can only go up and down and not diagonally on the grid
     * @param tile1 a tile
     * @param tile2 a tile we want to check where it is from tile1
     * @return true if it is accessible with one movement, false if it goes beyond or diagonally
     */
    private boolean limitMovement(Tiles tile1, Tiles tile2){
        if(tile1.getRow() == tile2.getRow() && tile1.getColumn() != tile2.getColumn()){
            return true;
        } else if (tile1.getColumn() == tile2.getColumn() && tile1.getRow() != tile2.getRow()) {
            return true;
        }
        return false;
    }

    /**
     * Convert the ArrayList of Tile in an Arraylist of Pos to give our enemy the correct position of each tile
     * @param tile an ArrayList of Tile
     */
    private void convertToPos(ArrayList<Tiles> tile){
        path.clear();
        for(int x = 0; x < tile.size();x++){
            path.add(new Pos(tile.get(x).getRow(), tile.get(x).getColumn()));
        }
    }

    /**
     * getter of the path
     * @return the path we need to take to follow our grid
     */
    public ArrayList<Pos> getPath(){
        return path;
    }
}
