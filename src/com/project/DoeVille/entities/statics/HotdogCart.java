package com.project.Doeville.entities.statics;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.tiles.Tile;

public class HotdogCart extends StaticEntity {
	private HUD hud;
	private float x, y;
	
	public HotdogCart(Handler handler, HUD hud, float x, float y) {
		super(handler, x, y, Tile.t_Width, Tile.t_Height, EntityID.Barrier, MapAssignment.Map000);
		int width = Tile.t_Width , height = Tile.t_Height;
		this.hud = hud; this.x = x; this.y = y;
		
		bounds.x = 0;
		bounds.y = (int) (height - height / 1.5f) + 20;
		bounds.width = width;
		bounds.height = (int) (height - height / 1.5f);	
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.hotdogcart, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);	
	}
	
	public void examine() {
		Player.dID = DialogID.empty;
	}

	@Override
	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entity clone() {
		Entity e = new HotdogCart(handler, hud, x, y);
		return e;
	}

}
