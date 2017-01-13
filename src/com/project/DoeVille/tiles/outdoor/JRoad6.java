package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad6 extends Tile {

	public JRoad6(int id) {
		super(Assets.JRoad[6], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
