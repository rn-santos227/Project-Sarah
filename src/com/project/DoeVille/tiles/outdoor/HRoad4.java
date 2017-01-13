package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad4 extends Tile {

	public HRoad4(int id) {
		super(Assets.HRoad[4], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
