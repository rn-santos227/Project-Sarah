package com.project.Doeville.entities.triggers.doors;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class ConvenienceStoreDoor extends Entity {
	private HUD hud;
	private DisplayDialog dd;
	private float x, y;
	public ConvenienceStoreDoor(Handler handler, HUD hud, DisplayDialog dd, float x, float y) {
		super(handler, x, y, Tile.t_Width/2, Tile.t_Height/2, EntityID.Door, MapAssignment.Map000);
		this.hud = hud; this.dd = dd; this.x = x; this.y = y;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = (Tile.t_Width/2) + 4;
		bounds.height = Tile.t_Height/2;
		loadScript = new LoadScript("Dialogues.lua");
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);			
	}

	public void examine() {
		if(dd.getaBox().getTimer() == 0) {
			Player.running = false;
		} else {
			dd.getaBox().setTimer(0);
			Player.dID = DialogID.empty;
		}
	}

	public void resetOriginalState() {

	}

	public Entity clone() {
		Entity e = new ConvenienceStoreDoor(handler, hud, dd, x, y);
		return e;
	}
}
