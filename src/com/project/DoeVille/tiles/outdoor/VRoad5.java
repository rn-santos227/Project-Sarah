package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad5 extends Tile{

	public VRoad5(int id) {
		super(Assets.VRoad[5], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}