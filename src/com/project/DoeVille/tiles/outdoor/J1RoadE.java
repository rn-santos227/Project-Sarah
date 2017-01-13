package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1RoadE extends Tile {

	public J1RoadE(int id) {
		super(Assets.J1Road[14], id);
	}
	
	public boolean isWalkable(){
		return false;
	}

}