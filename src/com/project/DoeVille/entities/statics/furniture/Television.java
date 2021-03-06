package com.project.Doeville.entities.statics.furniture;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class Television extends Entity {
	private MapAssignment map;
	private float x, y;
	public Television(Handler handler, float x, float y, MapAssignment mapAssignment) {
		super(handler, x, y, (Tile.t_Width / 2) * 3, (Tile.t_Width / 2) * 3, EntityID.Object, mapAssignment);
		this.x = x; this.y = y; this.map = mapAssignment;
		bounds.x = 10;
		bounds.y = 60;
		bounds.width = width - 10;
		bounds.height = (height / 2) - 20;	
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.Television, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);	
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);			
	}

	public void examine() {
		// TODO Auto-generated method stub
		
	}

	public Entity clone() {
		Entity e = new Television(handler, x, y, map);
		return e;
	}

	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
	}

}
