package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class RedTile4 extends Tile {

	public RedTile4(int id) {
		super(Assets.RedBrickTile[4], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
