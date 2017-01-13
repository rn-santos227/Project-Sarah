package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoadE extends Tile {

	public HRoadE(int id) {
		super(Assets.HRoad[14], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
