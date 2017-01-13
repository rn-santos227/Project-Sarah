package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX0 extends Tile {

	public PedX0(int id) {
		super(Assets.PedestrianLine[0], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
