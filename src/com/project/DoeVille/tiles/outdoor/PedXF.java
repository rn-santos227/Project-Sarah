package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedXF extends Tile {

	public PedXF(int id) {
		super(Assets.PedestrianLine[15], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
