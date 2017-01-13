package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1Road3 extends Tile {

	public J1Road3(int id) {
		super(Assets.J1Road[3], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}