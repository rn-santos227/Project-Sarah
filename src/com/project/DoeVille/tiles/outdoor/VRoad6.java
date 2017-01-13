package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad6 extends Tile{

	public VRoad6(int id) {
		super(Assets.VRoad[6], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}