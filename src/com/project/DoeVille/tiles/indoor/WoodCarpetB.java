package com.project.Doeville.tiles.indoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class WoodCarpetB extends Tile {
	public WoodCarpetB(int id) {
		super(Assets.Floors[6], id);
	}
	
	@Override
	public boolean isWalkable(){
		return true;
	}
}
