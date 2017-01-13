package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoadB extends Tile {

	public JRoadB(int id) {
		super(Assets.JRoad[11], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
