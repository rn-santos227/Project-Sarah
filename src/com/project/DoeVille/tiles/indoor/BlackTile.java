package com.project.Doeville.tiles.indoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class BlackTile extends Tile {
	public BlackTile(int id) {
		super(Assets.Floors[0], id);
	}
	
	@Override
	public boolean isWalkable(){
		return false;
	}
}
