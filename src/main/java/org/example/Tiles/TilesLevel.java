package org.example.Tiles;

import org.example.Game;
import org.example.LevelBuilder.Level;
import org.example.Pos;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class TilesLevel {

    private TilesManager TManager;
    private ArrayList<Pos> path;
    public TilesLevel(TilesManager tilesManager){
        TManager = tilesManager;
        path = new ArrayList<>();
    }

    public int[][] level(){
        setTylesType(Game.getInstance().getLevel().map);
        ArrayList<Tiles> pos = setPath(TManager.grid.get(9).get(0));
        convertToPos(pos);

        return Game.getInstance().getLevel().map;
    }
    private void setTylesType(int[][] level){
        for(int x=0; x < 20; x++){
            for(int y=0; y <20; y++){
                TManager.grid.get(x).get(y).setTypeID(level[x][y]);
                TManager.grid.get(x).get(y).setNext(null);
                TManager.grid.get(x).get(y).setPrevious(null);
            }
        }

    }

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

        System.out.println("Size of the path :" + path.size());
        return path;
    }

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

    private boolean limitMovement(Tiles tile1, Tiles tile2){
        if(tile1.getRow() == tile2.getRow() && tile1.getColumn() != tile2.getColumn()){
            return true;
        } else if (tile1.getColumn() == tile2.getColumn() && tile1.getRow() != tile2.getRow()) {
            return true;
        }
        return false;
    }

    private void convertToPos(ArrayList<Tiles> tile){
        path.clear();
        for(int x = 0; x < tile.size();x++){
            path.add(new Pos(tile.get(x).getRow(), tile.get(x).getColumn()));
        }
    }

    public ArrayList<Pos> getPath(){
        return path;
    }
}
