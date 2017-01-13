package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoadB extends Tile {

	public HRoadB(int id) {
		super(Assets.HRoad[11], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
