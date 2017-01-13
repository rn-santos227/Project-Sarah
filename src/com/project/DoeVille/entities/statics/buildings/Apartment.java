package com.project.Doeville.entities.statics.buildings;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.Inventory.Inventory;
import com.project.Doeville.clock.DayNight;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.entities.statics.StaticEntity;
import com.project.Doeville.entities.triggers.doors.ApartmentDoor;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class Apartment extends StaticEntity {
	private ApartmentDoor door; 
	private HUD hud;
	private DisplayDialog dd;
	private Transition tran;
	private boolean tran_flag = false;
	private boolean isEntering = false;
	private float x, y;
	public static float prev_x, prev_y;
	
	public Apartment(Handler handler, HUD hud, DisplayDialog dd, Transition tran, float x, float y) {
		super(handler, x, y, (Tile.t_Height * 4) + 32, (Tile.t_Height * 4) + 32, EntityID.Building, MapAssignment.Map000);
		int width = (Tile.t_Width * 3) + 32, height = (Tile.t_Height * 4) + 32;
		this.hud = hud; this.dd = dd; this.tran = tran; this.x = x; this.y = y;
		
		bounds.x = 20;
		bounds.y = (int) (height / 1.5f) - 30;
		bounds.width = width + 5;
		bounds.height = (int) ((height - height / 1.5f) + 30);
		loadScript = new LoadScript("Dialogues.lua");
		door = new ApartmentDoor(handler, hud, dd, tran, 870, 928);		
	}
	
	public void tick() {
		if(isEntering) {
			if(!DayNight.indoors) {
				if(!tran_flag) { tran.setAppear(false); tran.setTransitioning(true);}
				tran_flag = true;
				Player.isStop = true;
			}
			if(tran.isAppear() && !DayNight.indoors) {
				DayNight.indoors = true;
				Player.isStop = false; DayNight.indoors = true; isEntering = false; 
				tran_flag = false; 
				openApartment();
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(Assets.Apartment, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		door.render(g);
	}

	public void examine() {
		if(door.getCollisionBounds(0f, 0f).intersects(Player.examineBox)) {
			isEntering = true;
		}
		else Player.dID = DialogID.empty;
	}
	
	private void openApartment() {
		handler.getWorld().loadWorld("res/maps/map001");
		
		Player.last_Xpos = handler.getWorld().getEntityManager().getPlayer().getX();
		Player.last_Ypos = handler.getWorld().getEntityManager().getPlayer().getY();
		
		handler.getWorld().getEntityManager().getPlayer().setX(handler.getWorld().getSpawnX());
		handler.getWorld().getEntityManager().getPlayer().setY(handler.getWorld().getSpawnY());
		DayNight.alpha = 0f;	
		door.examine();
	}

	public void resetOriginalState() {
		
	}

	public Entity clone() {
		Entity e = new Apartment(handler, hud, dd, tran, x, y);
		return e;
	}
}
