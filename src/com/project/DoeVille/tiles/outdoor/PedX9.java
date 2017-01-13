package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX9 extends Tile {

	public PedX9(int id) {
		super(Assets.PedestrianLine[9], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
