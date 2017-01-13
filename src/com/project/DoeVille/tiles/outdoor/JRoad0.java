package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class JRoad0 extends Tile {

	public JRoad0(int id) {
		super(Assets.JRoad[0], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
