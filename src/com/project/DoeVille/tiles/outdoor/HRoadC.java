package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoadC extends Tile {

	public HRoadC(int id) {
		super(Assets.HRoad[12], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
