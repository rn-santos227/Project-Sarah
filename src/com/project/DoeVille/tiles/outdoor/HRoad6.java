package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad6 extends Tile {

	public HRoad6(int id) {
		super(Assets.HRoad[6], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
