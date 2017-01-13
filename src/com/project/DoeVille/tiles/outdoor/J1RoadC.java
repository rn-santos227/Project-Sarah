package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1RoadC extends Tile {

	public J1RoadC(int id) {
		super(Assets.J1Road[12], id);
	}
	
	public boolean isWalkable(){
		return false;
	}

}