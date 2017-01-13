package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1Road7 extends Tile {

	public J1Road7(int id) {
		super(Assets.J1Road[7], id);
	}
	
	public boolean isWalkable(){
		return false;
	}

}