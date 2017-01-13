package com.project.Doeville.entities.statics.buildings;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.entities.statics.StaticEntity;
import com.project.Doeville.entities.triggers.ATM;
import com.project.Doeville.entities.triggers.doors.ConvenienceStoreDoor;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class ConvenienceStore extends StaticEntity {
	private ATM atm;
	private ConvenienceStoreDoor door;
	private HUD hud;
	private DisplayDialog dd;
	private Transition tran;
	private float x, y;
	
	public ConvenienceStore(Handler handler, HUD hud, DisplayDialog dd,  Transition tran, float x, float y) {
		super(handler, x, y, (Tile.t_Height / 2) * 5, (Tile.t_Height / 2) * 6, EntityID.Building, MapAssignment.Map000);
		int width = (Tile.t_Height / 2) * 5, height = (Tile.t_Height / 2) * 6;
		this.hud = hud; this.dd = dd; this.tran = tran; this.x = x; this.y = y;	
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f) - 65;
		bounds.width = width - 34;
		bounds.height = (int) ((height - height / 1.5f) + 65);
		loadScript = new LoadScript("Dialogues.lua");
		atm = new ATM(handler, hud, dd, 1167, 928);
		door = new ConvenienceStoreDoor(handler, hud, dd, 1114, 928);
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.ConvienceStore, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		atm.render(g);
		door.render(g);
	}

	public void examine() {
		if(atm.getCollisionBounds(0f, 0f).intersects(Player.examineBox)) atm.examine();
		else if(door.getCollisionBounds(0f, 0f).intersects(Player.examineBox)) door.examine();
		else Player.dID = DialogID.empty;
	}

	public void resetOriginalState() {

	}

	public Entity clone() {
		Entity e = new ConvenienceStore(handler, hud, dd, tran, x, y);
		return e;
	}
}
