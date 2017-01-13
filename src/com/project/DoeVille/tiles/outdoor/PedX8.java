package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX8 extends Tile {

	public PedX8(int id) {
		super(Assets.PedestrianLine[8], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
