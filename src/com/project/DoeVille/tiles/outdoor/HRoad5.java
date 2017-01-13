package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad5 extends Tile {

	public HRoad5(int id) {
		super(Assets.HRoad[5], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
