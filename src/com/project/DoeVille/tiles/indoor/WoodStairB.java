package com.project.Doeville.tiles.indoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class WoodStairB extends Tile {
	public WoodStairB(int id) {
		super(Assets.Floors[4], id);
	}
	
	@Override
	public boolean isWalkable(){
		return true;
	}
}
