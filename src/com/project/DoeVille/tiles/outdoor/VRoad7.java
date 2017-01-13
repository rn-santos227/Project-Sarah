package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad7 extends Tile{

	public VRoad7(int id) {
		super(Assets.VRoad[7], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}