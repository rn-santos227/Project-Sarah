package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoadF extends Tile {

	public HRoadF(int id) {
		super(Assets.HRoad[15], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
