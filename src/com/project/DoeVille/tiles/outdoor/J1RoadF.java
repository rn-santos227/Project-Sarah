package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1RoadF extends Tile {

	public J1RoadF(int id) {
		super(Assets.J1Road[15], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}