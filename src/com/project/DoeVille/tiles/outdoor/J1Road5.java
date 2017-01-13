package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1Road5 extends Tile {

	public J1Road5(int id) {
		super(Assets.J1Road[5], id);
	}
	
	public boolean isWalkable(){
		return false;
	}

}