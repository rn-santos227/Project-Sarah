package com.project.Doeville.entities.statics;


import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.clock.GameClock;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class StreetLamp extends StaticEntity {
	protected String message, lighten;
	private float x, y;
	
	public StreetLamp(Handler handler, float x, float y) {
		super(handler, x, y, Tile.t_Width/2, (Tile.t_Height * 3)/2, EntityID.StreetLamp, MapAssignment.Map000);
		int width = Tile.t_Width/2, height = (Tile.t_Height * 3)/2;
		this.x = x; this.y = y;
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
		loadScript = new LoadScript("Dialogues.lua");
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.streetlamp, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	public void examine() {
		Player.dID = DialogID.information;
		this.lighten = String.valueOf(GameClock.isDark);
		loadScript.runScript("getMessage01", this);
		Player.messages = this.message;
		Player.mID = 0;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLighten() {
		return lighten;
	}

	public void resetOriginalState() {

	}

	@Override
	public Entity clone() {
		Entity e = new StreetLamp(handler, x, y);
		return e;
	}
}
