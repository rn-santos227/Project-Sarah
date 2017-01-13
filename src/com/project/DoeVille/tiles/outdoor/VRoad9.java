package com.project.Doeville.tiles.outdoor;


import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class VRoad9 extends Tile{

	public VRoad9(int id) {
		super(Assets.VRoad[9], id);
	}
	
	public boolean isWalkable(){
		return false;
	}
}