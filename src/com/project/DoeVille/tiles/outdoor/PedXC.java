package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedXC extends Tile {

	public PedXC(int id) {
		super(Assets.PedestrianLine[12], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
