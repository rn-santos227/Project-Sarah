package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX2 extends Tile {

	public PedX2(int id) {
		super(Assets.PedestrianLine[2], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
