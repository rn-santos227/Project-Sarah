package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1Road4 extends Tile {

	public J1Road4(int id) {
		super(Assets.J1Road[4], id);
	}
	
	public boolean isWalkable(){
		return false;
	}

}