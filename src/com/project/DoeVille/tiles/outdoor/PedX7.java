package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class PedX7 extends Tile {

	public PedX7(int id) {
		super(Assets.PedestrianLine[7], id);
	}
	
	public boolean isWalkable(){
		return true;
	}

}
