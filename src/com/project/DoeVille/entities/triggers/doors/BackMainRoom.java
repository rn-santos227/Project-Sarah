package com.project.Doeville.entities.triggers.doors;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.entities.statics.buildings.Apartment;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class BackMainRoom extends Entity {
	private Entity entity;
	private Transition tran;
	private MapAssignment map;
	private boolean isEntering = false, isLoading = false, tran_flag = false;
	private float x, y;
	
	public BackMainRoom(Handler handler, Entity entity, Transition tran, MapAssignment mapAssignment, float x, float y) {
		super(handler, x, y, Tile.t_Width/2, Tile.t_Height/2, EntityID.Door, mapAssignment);
		this.entity = entity; this.tran = tran; this.map = mapAssignment; this.x = x; this.y = y;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Tile.t_Width - 2;
		bounds.height = Tile.t_Height/2;
		loadScript = new LoadScript("Dialogues.lua");
	}
	
	public void tick() {
		if(isEntering) {
			if(isLoading) {
				if(!tran_flag) { tran.setAppear(false); tran.setTransitioning(true);}
				if(tran.isTransitioning()) isLoading = false;
				tran_flag = true;
				Player.isStop = true;
			}
			if(tran.isAppear() && !isLoading) {
				Player.isStop = false; isEntering = false; tran_flag = false;
				loadObject();
			}
		}
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);			
	}

	public void examine() {
		if(this.getCollisionBounds(0f, 0f).intersects(Player.examineBox)) {
			isEntering = true; isLoading = true;
		}
		else Player.dID = DialogID.empty;
	}
	
	public void loadObject() {
		handler.getWorld().getEntityManager().getPlayer().setX(Apartment.prev_x);
		handler.getWorld().getEntityManager().getPlayer().setY(Apartment.prev_y);
		entity.examine();
	}
	
	public void generateWorldMapObject() {

	}

	public void resetOriginalState() {

	}

	public Entity clone() {
		Entity e = new BackMainRoom(handler, entity, tran, map, x, y);
		return e;
	}	
}
