package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX4 extends Tile {

	public PedX4(int id) {
		super(Assets.PedestrianLine[4], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
