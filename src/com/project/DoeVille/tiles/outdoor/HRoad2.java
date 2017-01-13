package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad2 extends Tile {

	public HRoad2(int id) {
		super(Assets.HRoad[2], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
