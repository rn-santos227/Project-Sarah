package com.project.Doeville.entities.triggers.doors;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.entities.statics.buildings.Apartment;
import com.project.Doeville.entities.statics.furniture.Bed;
import com.project.Doeville.entities.statics.furniture.IndoorPlantA;
import com.project.Doeville.entities.statics.furniture.KitchenSink;
import com.project.Doeville.entities.statics.furniture.KitchenStove;
import com.project.Doeville.entities.statics.furniture.Refrigerator;
import com.project.Doeville.entities.statics.furniture.SofaB;
import com.project.Doeville.entities.statics.furniture.Television;
import com.project.Doeville.entities.statics.furniture.WallDecoration1;
import com.project.Doeville.entities.statics.indoors.Wall01JL;
import com.project.Doeville.entities.statics.indoors.Wall01L0;
import com.project.Doeville.entities.statics.indoors.Wall01L1;
import com.project.Doeville.entities.statics.indoors.Wall01L3;
import com.project.Doeville.entities.statics.indoors.Wall01T0;
import com.project.Doeville.entities.statics.indoors.Wall01TL;
import com.project.Doeville.entities.statics.indoors.Wall01TR;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class ToHomeRoom extends Entity {
	private Entity entity;
	private DisplayDialog dd;
	private HUD hud;
	private Transition tran;
	private MapAssignment Map;
	private boolean isEntering = false, tran_flag = false, isLoading = false;
	private float x, y;
	public ToHomeRoom(Handler handler, Entity entity, DisplayDialog dd, HUD hud, Transition tran, float x, float y, MapAssignment mapAssignment) {
		super(handler, x, y, Tile.t_Width, Tile.t_Height, EntityID.Door, mapAssignment);
		this.dd = dd; this.hud = hud; this.entity = entity; this.tran = tran; this.x = x; this.y = y;
		bounds.x = 12;
		bounds.y = (Tile.t_Height/2) - 5;
		bounds.width = Tile.t_Width - 22;
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
				loadObjects();
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(Assets.Doors[0], (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);			
	}

	public void examine() {
		if(this.getCollisionBounds(0f, 0f).intersects(Player.examineBox)) {
			isEntering = true; isLoading = true;
		}
		else Player.dID = DialogID.empty;	
	}
	
	private void loadObjects() {
		System.out.print("Hit me!");
		Apartment.prev_x = handler.getWorld().getEntityManager().getPlayer().getX();
		Apartment.prev_y = handler.getWorld().getEntityManager().getPlayer().getY();
		
		handler.getWorld().getEntityManager().getPlayer().setX(483f);
		handler.getWorld().getEntityManager().getPlayer().setY(64 * 43);		
		
		for(Entity e: handler.getWorld().getEntityManager().entities) {
			if(e.getID() != EntityID.Player) e.setActive(false);
		}
		for(Entity e: handler.getWorld().getEntityManager().walls) {
			e.setActive(false);
		}
		
		//Construct Room Walls
		handler.getWorld().getEntityManager().addWall(new Wall01L0(handler, 64 * 4, 32 * 85, Map));
		handler.getWorld().getEntityManager().addWall(new Wall01L0(handler, 64 * 11, 32 * 85, Map));
		handler.getWorld().getEntityManager().addWall(new Wall01TL(handler, 64 * 4, 32 * 79, Map));
		handler.getWorld().getEntityManager().addWall(new Wall01TR(handler, (64 * 11) - 18, 32 * 79, Map));
		constructWall01L1(84, 80, 64 * 4);
		constructWall01L1(84, 80, 64 * 11);
		handler.getWorld().getEntityManager().addWall(new Wall01JL(handler, 64 * 7, 32 * 79, Map));
		handler.getWorld().getEntityManager().addWall(new Wall01L0(handler, 64 * 7, (32 * 81) + 2, Map));
		handler.getWorld().getEntityManager().addEntity(new Wall01L3(handler, 64 * 7, (32 * 85) - 16, Map));
		handler.getWorld().getEntityManager().addWall(new Wall01L0(handler, 64 * 7, 32 * 85, Map));
		for(int i = 9; i < 14; i++) handler.getWorld().getEntityManager().addWall(new Wall01T0(handler, 32 * i, 32 * 79, Map)); 
		for(int i = 15; i < 22; i++) handler.getWorld().getEntityManager().addWall(new Wall01T0(handler, 32 * i, 32 * 79, Map)); 
	
		//Create Exit
		handler.getWorld().getEntityManager().addEntity(new BackMainRoom(handler, entity, tran, Map, 483, 64 * 44));
		
		//Generate Objects
		handler.getWorld().getEntityManager().addEntity(new SofaB(handler, (64 * 9) - 16, 64 * 43, Map));
		handler.getWorld().getEntityManager().addEntity(new Television(handler, 64 * 9, (32 * 83) - 20, Map));
		handler.getWorld().getEntityManager().addEntity(new IndoorPlantA(handler, (64 * 10) + 25, (32 * 83) + 5, Map));
		
		handler.getWorld().getEntityManager().addEntity(new ToBathroom(handler, (64 * 7) + 16, (32 * 80) - 12, Map));
		handler.getWorld().getEntityManager().addEntity(new KitchenSink(handler, (64 * 8) + 8, (32 * 81) - 22 , Map));
		handler.getWorld().getEntityManager().addEntity(new KitchenStove(handler, (64 * 9) + 8, (32 * 81) - 22, Map));
		handler.getWorld().getEntityManager().addEntity(new Refrigerator(handler, 64 * 10, (32 * 80) - 21, Map));
		handler.getWorld().getEntityManager().addEntity(new WallDecoration1(handler, (64 * 9) + 5, 32 * 79, Map));
		
		handler.getWorld().getEntityManager().addEntity(new Window0(handler, (64 * 5) + 8, 32 * 79, Map));
		handler.getWorld().getEntityManager().addEntity(new Bed(handler, hud, dd, (64 * 4) + 14, (32 * 80), Map));
	}
	
	public void constructWall01L1(int start, int end, int axis_x) {
		for(int i = start; i > end; i--) handler.getWorld().getEntityManager().addWall(new Wall01L1(handler, axis_x, 32 * i, MapAssignment.Map001));
	}

	public Entity clone() {
		Entity e = new ToHomeRoom(handler, entity, dd, hud, tran, x, y, mapAssignment);
		return e;
	}

	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
	}
}
