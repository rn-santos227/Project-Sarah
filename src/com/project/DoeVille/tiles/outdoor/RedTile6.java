package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class RedTile6 extends Tile {

	public RedTile6(int id) {
		super(Assets.RedBrickTile[6], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
