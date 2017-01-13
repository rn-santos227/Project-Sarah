package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoadA extends Tile {

	public JRoadA(int id) {
		super(Assets.JRoad[10], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
