package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX1 extends Tile {

	public PedX1(int id) {
		super(Assets.PedestrianLine[1], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
