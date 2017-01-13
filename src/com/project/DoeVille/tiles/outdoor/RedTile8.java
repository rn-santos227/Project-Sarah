package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class RedTile8 extends Tile {

	public RedTile8(int id) {
		super(Assets.RedBrickTile[8], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
