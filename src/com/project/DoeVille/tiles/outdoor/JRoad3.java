package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad3 extends Tile {

	public JRoad3(int id) {
		super(Assets.JRoad[3], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
