package com.project.Doeville.entities.statics;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.tiles.Tile;

public class TrashBinA extends StaticEntity {
	private HUD hud;
	private float x, y;
	
	public TrashBinA(Handler handler, HUD hud, float x, float y) {
		super(handler, x, y, (Tile.t_Width / 2), (Tile.t_Width / 2), EntityID.Object, MapAssignment.Map000);
		this.hud = hud; this.x = x; this.y = y;
		
		bounds.x = 0;
		bounds.y = (int) (this.height - this.height / 1.5f) + 10;
		bounds.width = this.width;
		bounds.height = (int) (this.height - this.height / 1.5f);	
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.trashBinA, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);	
	}
	
	public void examine() {

	}

	public void resetOriginalState() {
		
	}

	public Entity clone() {
		Entity e = new TrashBinA(handler, hud, x, y);
		return e;
	}

}
