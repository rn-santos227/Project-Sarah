package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad8 extends Tile{

	public VRoad8(int id) {
		super(Assets.VRoad[8], id);
	}
	
	public boolean isWalkable(){
		return true;
	}
}