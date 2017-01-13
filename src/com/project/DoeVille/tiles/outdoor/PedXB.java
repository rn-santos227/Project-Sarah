package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedXB extends Tile {

	public PedXB(int id) {
		super(Assets.PedestrianLine[11], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
