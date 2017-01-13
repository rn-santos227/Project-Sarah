package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad2 extends Tile{

	public VRoad2(int id) {
		super(Assets.VRoad[2], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
