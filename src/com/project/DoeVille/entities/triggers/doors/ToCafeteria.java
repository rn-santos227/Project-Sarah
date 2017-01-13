package com.project.Doeville.entities.triggers.doors;

import java.awt.Graphics;
import java.util.Random;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.CafeteriaLady;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.entities.dynamics.Sarah;
import com.project.Doeville.entities.statics.buildings.Apartment;
import com.project.Doeville.entities.statics.furniture.CafeteriaBox0;
import com.project.Doeville.entities.statics.furniture.CafeteriaBox1;
import com.project.Doeville.entities.statics.furniture.CafeteriaBox2;
import com.project.Doeville.entities.statics.furniture.CafeteriaBox3;
import com.project.Doeville.entities.statics.furniture.CafeteriaCounterA0;
import com.project.Doeville.entities.statics.furniture.CafeteriaCounterA2;
import com.project.Doeville.entities.statics.furniture.CafeteriaCounterA3;
import com.project.Doeville.entities.statics.furniture.CashRegister0;
import com.project.Doeville.entities.statics.furniture.IndoorPlantA;
import com.project.Doeville.entities.statics.furniture.PlasticTable;
import com.project.Doeville.entities.statics.furniture.VendingMachineA;
import com.project.Doeville.entities.statics.furniture.VendingMachineB;
import com.project.Doeville.entities.statics.furniture.WallDecoration0;
import com.project.Doeville.entities.statics.furniture.WhiteChair0;
import com.project.Doeville.entities.statics.furniture.WhiteChair1;
import com.project.Doeville.entities.statics.furniture.WhiteChair2;
import com.project.Doeville.entities.statics.furniture.WhiteChair3;
import com.project.Doeville.entities.statics.indoors.Wall01L0;
import com.project.Doeville.entities.statics.indoors.Wall01L1;
import com.project.Doeville.entities.statics.indoors.Wall01T0;
import com.project.Doeville.entities.statics.indoors.Wall01TL;
import com.project.Doeville.entities.statics.indoors.Wall01TR;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class ToCafeteria extends Entity {
	private Entity entity;
	private DisplayDialog dd;
	private HUD hud;
	private Transition tran;
	private Random ran;
	private MapAssignment Map;
	private boolean isEntering = false, tran_flag = false, isLoading = false;
	private float x, y;
	
	public ToCafeteria(Handler handler, Entity entity, DisplayDialog dd, HUD hud, Transition tran, float x, float y, MapAssignment mapAssignment) {
		super(handler, x, y, (Tile.t_Width / 2) * 3, Tile.t_Height, EntityID.Door, mapAssignment);
		this.dd = dd; this.hud = hud; this.entity = entity; this.tran = tran; this.x = x; this.y = y; this.Map = mapAssignment;
		loadScript = new LoadScript("Dialogues.lua");
		ran = new Random();
		
		bounds.x = 12;
		bounds.y = (Tile.t_Height/2) - 5;
		bounds.width = Tile.t_Width - 6;
		bounds.height = Tile.t_Height/2;
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
		g.drawImage(Assets.Doors[1], (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	public void examine() {
		if(this.getCollisionBounds(0f, 0f).intersects(Player.examineBox)) {
			isEntering = true; isLoading = true;
		}
		else Player.dID = DialogID.empty;		
	}
	
	private void loadObjects() {
		int chance = ran.nextInt(20);
		System.out.print("Hit me!");
		Apartment.prev_x = handler.getWorld().getEntityManager().getPlayer().getX();
		Apartment.prev_y = handler.getWorld().getEntityManager().getPlayer().getY();
		
		for(Entity e: handler.getWorld().getEntityManager().entities) {
			if(e.getID() != EntityID.Player) e.setActive(false);
		}
		for(Entity e: handler.getWorld().getEntityManager().walls) {
			e.setActive(false);
		}
		
		handler.getWorld().getEntityManager().getPlayer().setX(483f);
		handler.getWorld().getEntityManager().getPlayer().setY(2048f);
		
		//Construct Cafeteria Walls
		handler.getWorld().getEntityManager().addWall(new Wall01L0(handler, 64 * 4, 32 * 63, Map));
		handler.getWorld().getEntityManager().addWall(new Wall01L0(handler, 64 * 12, 32 * 63, Map));
		handler.getWorld().getEntityManager().addWall(new Wall01TL(handler, 64 * 4, 32 * 54, Map));
		handler.getWorld().getEntityManager().addWall(new Wall01TR(handler, (64 * 12) - 18, 32 * 54, Map));
		constructWall01L1(63, 55, 64 * 4);
		constructWall01L1(63, 55, 64 * 12);
		for(int i = 9; i < 24; i++) handler.getWorld().getEntityManager().addWall(new Wall01T0(handler, 32 * i, 32 * 54, Map)); 
		
		//Create Exit
		handler.getWorld().getEntityManager().addEntity(new BackMainRoom(handler, entity, tran, Map, 483, 64 * 33));
		
		//Generate Objects
		handler.getWorld().getEntityManager().addEntity(new Door0(handler, (64 * 10) + 16, (32 * 55) - 12, Map));
		handler.getWorld().getEntityManager().addEntity(new VendingMachineB(handler, hud, dd, 64 * 5, (32 * 55) - 12, Map));
		handler.getWorld().getEntityManager().addEntity(new VendingMachineA(handler, hud, dd, chance, 64 * 6, (32 * 55) - 12, Map));
		handler.getWorld().getEntityManager().addEntity(new IndoorPlantA(handler, (64 * 4) + 20  , (32 * 55) + 10, Map));
		handler.getWorld().getEntityManager().addEntity(new CafeteriaCounterA0(handler, 64 * 7,  32 * 56, Map));
		handler.getWorld().getEntityManager().addEntity(new CafeteriaCounterA2(handler, 64 * 7,  32 * 58, Map));
		for(int i = 16; i < 23; i++) handler.getWorld().getEntityManager().addEntity(new CafeteriaCounterA3(handler, 32 * i,  32 * 58, Map));
		handler.getWorld().getEntityManager().addEntity(new CashRegister0(handler, 32 * 16, 32 * 57, Map));
		handler.getWorld().getEntityManager().addEntity(new CafeteriaBox0(handler, 32 * 19, 32 * 57, Map));
		handler.getWorld().getEntityManager().addEntity(new CafeteriaBox1(handler, 32 * 20, 32 * 57, Map));
		handler.getWorld().getEntityManager().addEntity(new CafeteriaBox1(handler, 32 * 21, 32 * 57, Map));
		handler.getWorld().getEntityManager().addEntity(new CafeteriaBox2(handler, 32 * 22, 32 * 57, Map));
		handler.getWorld().getEntityManager().addEntity(new CafeteriaBox3(handler, 32 * 23, 32 * 57, Map));
		handler.getWorld().getEntityManager().addEntity(new WallDecoration0(handler, (64 * 8) + 16, (32 * 55) - 20, Map));
		handler.getWorld().getEntityManager().addEntity(new CafeteriaLady(handler, hud, dd, (64 * 8) + 16, (32 * 57) - 20));
		
		handler.getWorld().getEntityManager().addEntity(new WhiteChair0(handler, (64 * 5) - 16, (32 * 60) + 40, Map));
		handler.getWorld().getEntityManager().addEntity(new WhiteChair0(handler, (64 * 5) - 16, (32 * 62) + 20, Map));	
		handler.getWorld().getEntityManager().addEntity(new WhiteChair1(handler, (64 * 6) + 17, (32 * 60) + 40, Map));
		handler.getWorld().getEntityManager().addEntity(new WhiteChair1(handler, (64 * 6) + 17, (32 * 62) + 20, Map));
		handler.getWorld().getEntityManager().addEntity(new WhiteChair2(handler, (64 * 5) + 32, (32 * 59) + 40, Map));
		handler.getWorld().getEntityManager().addEntity(new WhiteChair3(handler, (64 * 5) + 32, (32 * 63) + 20, Map));
		handler.getWorld().getEntityManager().addEntity(new PlasticTable(handler, (64 * 5) + 16, 32 * 61, Map));
		
		handler.getWorld().getEntityManager().addEntity(new WhiteChair0(handler, (64 * 9) + 16, (32 * 60) + 40, Map));
		handler.getWorld().getEntityManager().addEntity(new WhiteChair0(handler, (64 * 9) + 16, (32 * 62) + 20, Map));	
		handler.getWorld().getEntityManager().addEntity(new WhiteChair1(handler, (64 * 11) - 16, (32 * 60) + 40, Map));
		handler.getWorld().getEntityManager().addEntity(new WhiteChair1(handler, (64 * 11) - 16, (32 * 62) + 20, Map));
		handler.getWorld().getEntityManager().addEntity(new WhiteChair2(handler, 64 * 10, (32 * 59) + 40, Map));
		handler.getWorld().getEntityManager().addEntity(new Sarah(handler, hud, dd, (64 * 10) - 16, (32 * 60) - 10));
		handler.getWorld().getEntityManager().addEntity(new WhiteChair3(handler, 64 * 10, (32 * 63) + 20, Map));
		handler.getWorld().getEntityManager().addEntity(new PlasticTable(handler, (64 * 10) - 16, 32 * 61, Map));
	}
	
	public void constructWall01L1(int start, int end, int axis_x) {
		for(int i = start; i > end; i--) handler.getWorld().getEntityManager().addWall(new Wall01L1(handler, axis_x, 32 * i, MapAssignment.Map001));
	}

	public Entity clone() {
		Entity e = new ToCafeteria(handler, entity, dd, hud, tran, x, y, mapAssignment);
		return e;
	}

	public void resetOriginalState() {

	}
}
