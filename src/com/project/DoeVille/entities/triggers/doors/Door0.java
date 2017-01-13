package com.project.Doeville.entities.triggers.doors;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class Door0 extends Entity {
	private DisplayDialog dd;
	private float x, y;
	public Door0(Handler handler, float x, float y, MapAssignment mapAssignment) {
		super(handler, x, y, Tile.t_Width, Tile.t_Height, EntityID.Door, mapAssignment);
		this.x = x; this.y = y;
		bounds.x = 12;
		bounds.y = (Tile.t_Height/2) - 5;
		bounds.width = Tile.t_Width - 22;
		bounds.height = Tile.t_Height/2;
		loadScript = new LoadScript("Dialogues.lua");
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.Doors[0], (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);			
	}

	public void examine() {
		// TODO Auto-generated method stub
		
	}

	public Entity clone() {
		Entity e = new Door0(handler, x, y, mapAssignment);
		return e;
	}

	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
	}
}
