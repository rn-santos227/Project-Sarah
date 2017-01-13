package com.project.Doeville.entities.statics.indoors;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.statics.StaticEntity;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class Wall01R0 extends StaticEntity {
	private MapAssignment map;
	private float x, y;
	public Wall01R0(Handler handler, float x, float y, MapAssignment mapAssignment) {
		super(handler, x, y, Tile.t_Width / 2, (Tile.t_Height * 3) / 2, EntityID.Wall, mapAssignment);
		int width = Tile.t_Width / 2, height = (Tile.t_Height * 3) / 2;
		this.map = mapAssignment; this.x = x; this.y = y;
		bounds.x = width / 2;
		bounds.y = 0;
		bounds.width = (width / 2) - 3;
		bounds.height = height;	
		this.active = true;
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.Wall01[2], (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);	
	}
	
	public void examine() {
		
	}

	@Override
	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Entity clone() {
		Entity e = new Wall01R0(handler, x, y, map);
		return e;
	}

}
