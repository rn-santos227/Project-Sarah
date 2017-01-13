package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad4 extends Tile {

	public JRoad4(int id) {
		super(Assets.JRoad[4], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
