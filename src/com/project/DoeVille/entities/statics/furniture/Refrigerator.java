package com.project.Doeville.entities.statics.furniture;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class Refrigerator extends Entity {
	private MapAssignment map;
	private float x, y;
	public Refrigerator(Handler handler, float x, float y, MapAssignment mapAssignment) {
		super(handler, x, y, Tile.t_Width, (Tile.t_Height / 2) * 3, EntityID.Object, mapAssignment);
		this.x = x; this.y = y; this.map = mapAssignment;
		bounds.x = 0;
		bounds.y = 4;
		bounds.width = width;
		bounds.height = height - 10;	
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.Refrigerator, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);		
		
	}

	public void examine() {
		// TODO Auto-generated method stub
		
	}

	public Entity clone() {
		Entity e = new Refrigerator(handler, x, y, map);
		return e;
	}

	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
	}

}
