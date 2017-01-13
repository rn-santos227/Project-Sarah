package com.project.Doeville.tiles.indoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class WoodStairA extends Tile {
	public WoodStairA(int id) {
		super(Assets.Floors[3], id);
	}
	
	@Override
	public boolean isWalkable(){
		return true;
	}
}
