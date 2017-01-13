package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad1 extends Tile {

	public HRoad1(int id) {
		super(Assets.HRoad[1], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
