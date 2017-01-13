package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad8 extends Tile {

	public JRoad8(int id) {
		super(Assets.JRoad[8], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
