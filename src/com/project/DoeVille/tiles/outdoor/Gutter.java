package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;


public class Gutter extends Tile{

	public Gutter(int id) {
		super(Assets.gutter, id);
	}
	
	@Override
	public boolean isWalkable(){
		return true;
	}

}
