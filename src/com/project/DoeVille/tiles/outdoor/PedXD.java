package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedXD extends Tile {

	public PedXD(int id) {
		super(Assets.PedestrianLine[13], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
