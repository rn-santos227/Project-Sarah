package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad9 extends Tile {

	public JRoad9(int id) {
		super(Assets.JRoad[9], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
