package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoadD extends Tile {

	public JRoadD(int id) {
		super(Assets.JRoad[13], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
