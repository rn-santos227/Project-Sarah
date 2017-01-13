package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoadF extends Tile{

	public VRoadF(int id) {
		super(Assets.VRoad[15], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}