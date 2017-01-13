package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1RoadA extends Tile {

	public J1RoadA(int id) {
		super(Assets.J1Road[10], id);
	}
	
	public boolean isWalkable(){
		return false;
	}

}