package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoadA extends Tile {

	public HRoadA(int id) {
		super(Assets.HRoad[10], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
