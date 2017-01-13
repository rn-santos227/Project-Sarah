package com.project.Doeville.tiles.indoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class WoodTileB extends Tile {
	public WoodTileB(int id) {
		super(Assets.Floors[2], id);
	}
	
	@Override
	public boolean isWalkable(){
		return true;
	}
}
