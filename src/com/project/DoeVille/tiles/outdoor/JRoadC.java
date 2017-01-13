package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoadC extends Tile {

	public JRoadC(int id) {
		super(Assets.JRoad[12], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
