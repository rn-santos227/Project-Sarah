package com.project.Doeville.tiles.indoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class WoodCarpetA extends Tile {
	public WoodCarpetA(int id) {
		super(Assets.Floors[5], id);
	}
	
	@Override
	public boolean isWalkable(){
		return true;
	}
}
