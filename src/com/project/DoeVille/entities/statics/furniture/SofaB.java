package com.project.Doeville.entities.statics.furniture;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class SofaB extends Entity {
	private MapAssignment map;
	private float x, y;
	public SofaB(Handler handler, float x, float y, MapAssignment mapAssignment) {
		super(handler, x, y, Tile.t_Width * 2, Tile.t_Height, EntityID.Object, mapAssignment);
		this.x = x; this.y = y; this.map = mapAssignment;
		bounds.x = 0;
		bounds.y = 35;
		bounds.width = width;
		bounds.height = height - 45;	
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.SofaB, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);	
	}

	public void examine() {
		// TODO Auto-generated method stub
		
	}

	public Entity clone() {
		Entity e = new SofaB(handler, x, y, map);
		return e;
	}

	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
	}

}
