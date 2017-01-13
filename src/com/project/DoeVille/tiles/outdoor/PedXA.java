package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedXA extends Tile {

	public PedXA(int id) {
		super(Assets.PedestrianLine[10], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
