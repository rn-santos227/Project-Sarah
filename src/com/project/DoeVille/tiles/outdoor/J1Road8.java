package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1Road8 extends Tile {

	public J1Road8(int id) {
		super(Assets.J1Road[8], id);
	}
	
	public boolean isWalkable(){
		return false;
	}

}