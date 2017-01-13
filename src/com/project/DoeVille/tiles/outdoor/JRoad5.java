package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad5 extends Tile {

	public JRoad5(int id) {
		super(Assets.JRoad[5], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
