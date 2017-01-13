package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad2 extends Tile {

	public JRoad2(int id) {
		super(Assets.JRoad[2], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
