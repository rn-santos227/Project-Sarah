package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoadE extends Tile{

	public VRoadE(int id) {
		super(Assets.VRoad[14], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}