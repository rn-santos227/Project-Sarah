package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoadC extends Tile{

	public VRoadC(int id) {
		super(Assets.VRoad[12], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}