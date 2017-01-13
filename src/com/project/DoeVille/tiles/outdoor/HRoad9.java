package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad9 extends Tile {

	public HRoad9(int id) {
		super(Assets.HRoad[9], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
