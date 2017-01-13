package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class HRoad0 extends Tile {

	public HRoad0(int id) {
		super(Assets.HRoad[0], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
