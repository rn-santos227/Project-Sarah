package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoadA extends Tile{

	public VRoadA(int id) {
		super(Assets.VRoad[10], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}