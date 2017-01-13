package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class RedTile1 extends Tile {

	public RedTile1(int id) {
		super(Assets.RedBrickTile[1], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
