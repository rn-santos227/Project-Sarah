package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoadD extends Tile{

	public VRoadD(int id) {
		super(Assets.VRoad[13], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}