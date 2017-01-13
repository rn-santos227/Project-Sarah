package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX3 extends Tile {

	public PedX3(int id) {
		super(Assets.PedestrianLine[3], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
