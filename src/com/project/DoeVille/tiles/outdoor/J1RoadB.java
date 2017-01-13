package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class J1RoadB extends Tile {

	public J1RoadB(int id) {
		super(Assets.J1Road[11], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}