package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad8 extends Tile {

	public HRoad8(int id) {
		super(Assets.HRoad[8], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
