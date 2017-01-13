package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX6 extends Tile {

	public PedX6(int id) {
		super(Assets.PedestrianLine[6], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
