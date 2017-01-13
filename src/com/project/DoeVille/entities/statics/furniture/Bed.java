package com.project.Doeville.entities.statics.furniture;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.dialogs.list.NPCDialog;
import com.project.Doeville.dialogs.list.QuestionDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class Bed extends Entity {
	private BufferedImage image;
	private HUD hud;
	private DisplayDialog dd;
	private String message;
	private MapAssignment map;
	private int mID, oID;
	private float x, y;

	public Bed(Handler handler, HUD hud, DisplayDialog dd, float x, float y, MapAssignment mapAssignment) {
		super(handler, x, y, Tile.t_Width, Tile.t_Height * 2, EntityID.Object, mapAssignment);
		this.hud = hud; this.dd = dd; this.x = x; this.y = y; this.map = mapAssignment;
		image = Assets.Bed;
		loadScript = new LoadScript("Dialogues.lua");
		bounds.x = 0;
		bounds.y = 4;
		bounds.width = width;
		bounds.height = height - 10;	
		mID = 0; oID = 0;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.drawImage(image, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);		
		
	}

	public void examine() {

	}

	public Entity clone() {
		Entity e = new Bed(handler, hud, dd, x, y, map);
		return e;
	}

	public void resetOriginalState() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getmID() {
		return mID;
	}

	public int getoID() {
		return oID;
	}

}
