package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoadF extends Tile {

	public JRoadF(int id) {
		super(Assets.JRoad[15], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
