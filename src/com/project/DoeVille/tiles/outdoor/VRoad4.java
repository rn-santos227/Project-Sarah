package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad4 extends Tile{

	public VRoad4(int id) {
		super(Assets.VRoad[4], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
