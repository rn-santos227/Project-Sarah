package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class RedTile7 extends Tile {

	public RedTile7(int id) {
		super(Assets.RedBrickTile[7], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
