package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoadE extends Tile {

	public JRoadE(int id) {
		super(Assets.JRoad[14], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
