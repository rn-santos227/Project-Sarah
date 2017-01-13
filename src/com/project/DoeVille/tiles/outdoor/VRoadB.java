package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoadB extends Tile{

	public VRoadB(int id) {
		super(Assets.VRoad[11], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}