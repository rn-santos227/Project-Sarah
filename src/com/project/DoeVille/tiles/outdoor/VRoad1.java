package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad1 extends Tile{

	public VRoad1(int id) {
		super(Assets.VRoad[1], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}
