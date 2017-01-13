package com.project.Doeville.tiles.outdoor;

import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad0 extends Tile {

	public VRoad0(int id) {
		super(Assets.VRoad[0], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
