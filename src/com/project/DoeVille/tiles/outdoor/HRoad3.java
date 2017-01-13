package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad3 extends Tile {

	public HRoad3(int id) {
		super(Assets.HRoad[3], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
