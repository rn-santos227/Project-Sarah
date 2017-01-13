package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class RedTile0 extends Tile {

	public RedTile0(int id) {
		super(Assets.RedBrickTile[0], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
