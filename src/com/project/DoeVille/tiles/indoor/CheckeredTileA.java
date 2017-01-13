package com.project.Doeville.tiles.indoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class CheckeredTileA extends Tile {
	public CheckeredTileA(int id) {
		super(Assets.Floors[7], id);
	}
	
	@Override
	public boolean isWalkable(){
		return true;
	}
}
