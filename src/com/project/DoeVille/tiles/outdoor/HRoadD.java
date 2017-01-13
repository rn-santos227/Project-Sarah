package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoadD extends Tile {

	public HRoadD(int id) {
		super(Assets.HRoad[13], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
