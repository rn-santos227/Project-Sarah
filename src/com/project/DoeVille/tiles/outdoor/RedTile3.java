package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class RedTile3 extends Tile {

	public RedTile3(int id) {
		super(Assets.RedBrickTile[3], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
