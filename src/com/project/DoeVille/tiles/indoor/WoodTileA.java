package com.project.Doeville.tiles.indoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class WoodTileA extends Tile {
	public WoodTileA(int id) {
		super(Assets.Floors[1], id);
	}
	
	@Override
	public boolean isWalkable(){
		return true;
	}
}
