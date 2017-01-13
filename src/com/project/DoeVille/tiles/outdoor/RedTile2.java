package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class RedTile2 extends Tile {

	public RedTile2(int id) {
		super(Assets.RedBrickTile[2], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
