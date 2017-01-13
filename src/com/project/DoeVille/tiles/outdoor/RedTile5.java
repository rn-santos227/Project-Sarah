package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class RedTile5 extends Tile {

	public RedTile5(int id) {
		super(Assets.RedBrickTile[5], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
