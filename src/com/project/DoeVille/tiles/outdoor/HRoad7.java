package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad7 extends Tile {

	public HRoad7(int id) {
		super(Assets.HRoad[7], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
