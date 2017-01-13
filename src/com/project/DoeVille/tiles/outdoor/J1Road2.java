package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1Road2 extends Tile {

	public J1Road2(int id) {
		super(Assets.J1Road[2], id);
	}
	
	public boolean isWalkable(){
		return false;
	}

}