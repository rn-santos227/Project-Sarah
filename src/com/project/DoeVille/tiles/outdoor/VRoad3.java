package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad3 extends Tile{

	public VRoad3(int id) {
		super(Assets.VRoad[3], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}
