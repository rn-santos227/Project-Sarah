package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedXE extends Tile {

	public PedXE(int id) {
		super(Assets.PedestrianLine[14], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
