package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad1 extends Tile {

	public JRoad1(int id) {
		super(Assets.JRoad[1], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
