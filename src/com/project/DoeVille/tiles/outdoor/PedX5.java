package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX5 extends Tile {

	public PedX5(int id) {
		super(Assets.PedestrianLine[5], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
