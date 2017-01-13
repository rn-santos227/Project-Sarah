package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1RoadD extends Tile {

	public J1RoadD(int id) {
		super(Assets.J1Road[13], id);
	}
	
	public boolean isWalkable(){
		return false;
	}

}