package com.project.Doeville.entities.statics;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.tiles.Tile;

public class WhiteFenceL extends StaticEntity {
	public float x, y;
	public WhiteFenceL(Handler handler, float x, float y) {
		super(handler, x, y, Tile.t_Width / 2, Tile.t_Height / 2, EntityID.Barrier, MapAssignment.Map000);
		int width = Tile.t_Width / 2 , height = Tile.t_Height / 2;
		this.x = x; this.y = y;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width / 2;
		bounds.height = height;	
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.WhiteFence[3], (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	public void examine() {
		
	}

	@Override
	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Entity clone() {
		Entity e = new WhiteFenceL(handler, x, y);
		return e;
	}

}
