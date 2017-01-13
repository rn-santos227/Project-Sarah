package com.project.Doeville.entities.triggers.doors;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.clock.DayNight;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class MainMapExit extends Entity {
	private MapAssignment map;
	private DisplayDialog dd;
	private HUD hud;
	private Transition tran;
	private boolean tran_flag = false;
	private boolean isExiting = false;
	private float x, y;
	
	public MainMapExit(Handler handler, HUD hud, DisplayDialog dd, Transition tran, MapAssignment mapAssignment, float x, float y) {
		super(handler, x, y, Tile.t_Width/2, Tile.t_Height/2, EntityID.Door, mapAssignment);
		this.dd = dd; this.hud = hud; this.tran = tran; this.map = mapAssignment; this.x = x; this.y = y;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Tile.t_Width - 2;
		bounds.height = Tile.t_Height/2;
		loadScript = new LoadScript("Dialogues.lua");
	}
	
	public void tick() {
		if(isExiting) {
			if(DayNight.indoors) {
				if(!tran_flag) { tran.setAppear(false); tran.setTransitioning(true);}
				tran_flag = true;
				Player.isStop = true;
			}
			if(tran.isAppear() && DayNight.indoors) {
				generateWorldMapObject();
				Player.isStop = false; DayNight.indoors = false; isExiting = false; 
				tran_flag = false; 				
			}
		}
	}
	
	public void render(Graphics g) {
		
	}

	public void examine() {
		if(this.getCollisionBounds(0f, 0f).intersects(Player.examineBox)) {
			isExiting = true;
			this.tick();
		}
		else Player.dID = DialogID.empty;
	}
	
	public void generateWorldMapObject() {
		if(dd.getaBox().getTimer() == 0) {
			handler.getWorld().loadWorld("res/maps/map000");
			handler.getWorld().getEntityManager().getPlayer().setX(Player.last_Xpos);
			handler.getWorld().getEntityManager().getPlayer().setY(Player.last_Ypos);
			
			for(Entity e: handler.getWorld().getEntityManager().entities) {
				if(e.getMapAssignment() != MapAssignment.Map000) {
					if(e.getID() != EntityID.Player) e.setActive(false);
				}
			}
			for(Entity e: handler.getWorld().getEntityManager().walls) {
				e.setActive(false);
			}
			
			handler.getWorld().copyObjectsToEntityManager();
			Player.running = false;
		}
	}

	public void resetOriginalState() {

	}

	public Entity clone() {
		Entity e = new MainMapExit(handler, hud, dd, tran, map, x, y);
		return e;
	}	
}
