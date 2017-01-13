package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad7 extends Tile {

	public JRoad7(int id) {
		super(Assets.JRoad[7], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
