package com.project.Doeville.entities.triggers.doors;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.entities.dynamics.Sarah;
import com.project.Doeville.entities.statics.furniture.BookShelfA;
import com.project.Doeville.entities.statics.furniture.ClockA;
import com.project.Doeville.entities.statics.furniture.IndoorPlantA;
import com.project.Doeville.entities.statics.furniture.KeyBox;
import com.project.Doeville.entities.statics.furniture.SideTableA;
import com.project.Doeville.entities.statics.furniture.SofaA;
import com.project.Doeville.entities.statics.furniture.WoodCounterA0;
import com.project.Doeville.entities.statics.furniture.WoodCounterA1;
import com.project.Doeville.entities.statics.furniture.WoodCounterA2;
import com.project.Doeville.entities.statics.furniture.WoodCounterA3;
import com.project.Doeville.entities.statics.furniture.WoodCounterA4;
import com.project.Doeville.entities.statics.indoors.Wall01B0;
import com.project.Doeville.entities.statics.indoors.Wall01B1;
import com.project.Doeville.entities.statics.indoors.Wall01BL;
import com.project.Doeville.entities.statics.indoors.Wall01L0;
import com.project.Doeville.entities.statics.indoors.Wall01L1;
import com.project.Doeville.entities.statics.indoors.Wall01L2;
import com.project.Doeville.entities.statics.indoors.Wall01T0;
import com.project.Doeville.entities.statics.indoors.Wall01TL;
import com.project.Doeville.entities.statics.indoors.Wall01TR;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class ApartmentDoor extends Entity {
	private DisplayDialog dd;
	private HUD hud;
	private Transition tran;
	private float x, y;

	public ApartmentDoor(Handler handler, HUD hud, DisplayDialog dd, Transition tran, float x, float y) {
		super(handler, x, y, Tile.t_Width/2, Tile.t_Height/2, EntityID.Door, MapAssignment.Map000);
		this.dd = dd; this.hud = hud; this.tran = tran;  this.x = x; this.y = y;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = (Tile.t_Width/2) + 15;
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
		for(Entity e: handler.getWorld().getEntityManager().entities) if(e.getID() != EntityID.Player) e.setActive(false);
		for(Entity e: handler.getWorld().getEntityManager().walls) {
			e.setActive(false);
		}
		loadObjects();
		Player.running = false;
			
	}
	
	private void loadObjects() {
		MapAssignment Map = MapAssignment.Map001;
		
		//Construct Walls
		handler.getWorld().getEntityManager().addWall(new Wall01L0(handler, 64 * 2, 32 * 41, Map));
		constructWall01L1(41, 34, 64 * 2);
		handler.getWorld().getEntityManager().addWall(new Wall01TL(handler, 64 * 2, 32 * 34, Map));		
		constructWall01T0(32 * 34); //Segment 1		
		//Construct 2nd Floor Wall Segment
		handler.getWorld().getEntityManager().addWall(new Wall01L2(handler, 32 * 24, 32 * 34, Map));
		constructWall01L1(33, 27, 32 * 24);	
		handler.getWorld().getEntityManager().addEntity(new Wall01BL(handler, 32 * 24, 32 * 27, Map));
		constructWall01B0(32 * 27);
		handler.getWorld().getEntityManager().addEntity(new Wall01B1(handler, 64 * 2, 32 * 27, Map));
		constructWall01L1(26, 21, 64 * 2);		
		handler.getWorld().getEntityManager().addEntity(new Wall01TL(handler, 64 * 2, 32 * 20, Map));			
		constructWall01T0(32 * 20); //Segment 2		
		//Construct 3rd Floor Wall Segment
		handler.getWorld().getEntityManager().addWall(new Wall01L2(handler, 32 * 24, 32 * 20, Map));		
		constructWall01L1(19, 13, 32 * 24);
		handler.getWorld().getEntityManager().addEntity(new Wall01BL(handler, 32 * 24, 32 * 13, Map));
		constructWall01L1(41, 7, 64 * 14);
		handler.getWorld().getEntityManager().addEntity(new Wall01B1(handler, 64 * 2, 32 * 13, Map));
		constructWall01B0(32 * 13); 
		handler.getWorld().getEntityManager().addEntity(new Wall01L0(handler, 64 * 14, 32 * 41, Map));
		constructWall01L1(12, 7, 64 * 2);
		handler.getWorld().getEntityManager().addWall(new Wall01TL(handler, 64 * 2, 32 * 6, Map));
		handler.getWorld().getEntityManager().addWall(new Wall01TR(handler, (64 * 14) - 18, 32 * 6, Map));			
		for(int i = 5; i < 28; i++) handler.getWorld().getEntityManager().addWall(new Wall01T0(handler, 32 * i, 32 * 6, Map)); //Segment 3
		
		//Add Doors
		handler.getWorld().getEntityManager().addEntity(new ToCafeteria(handler, this, dd, hud, tran, 64 * 4, 1108, Map));
		handler.getWorld().getEntityManager().addEntity(new Door0(handler, 64 * 4, 660, Map));
		handler.getWorld().getEntityManager().addEntity(new Door0(handler, 64 * 9, 660, Map));
		handler.getWorld().getEntityManager().addEntity(new Door0(handler, 64 * 4, (64 * 3) + 20, Map));
		handler.getWorld().getEntityManager().addEntity(new ToHomeRoom(handler, this, dd, hud, tran, 64 * 9, (64 * 3) + 20, Map));	
		
		//Add Objects	
		handler.getWorld().getEntityManager().addEntity(new MainMapExit(handler, hud, dd, tran, Map, 480, 1410));
		handler.getWorld().getEntityManager().addEntity(new BookShelfA(handler, 32 * 6, 1131, Map));
		for(int i = 7; i < 9; i++) handler.getWorld().getEntityManager().addEntity(new WoodCounterA3(handler, 64 * i, 64 * 19, Map));
		handler.getWorld().getEntityManager().addEntity(new WoodCounterA4(handler, 64 * 9, 64 * 19, Map));
		handler.getWorld().getEntityManager().addEntity(new IndoorPlantA(handler, (64 * 6) - 32, (64 * 18) - 16, Map));
		handler.getWorld().getEntityManager().addEntity(new IndoorPlantA(handler, 64 * 10, (64 * 18) - 16, Map));
		handler.getWorld().getEntityManager().addEntity(new SideTableA(handler, (32 * 5) - 12, 1162, Map));
		handler.getWorld().getEntityManager().addEntity(new SofaA(handler, (64 * 2) + 16, 1190, Map));
		handler.getWorld().getEntityManager().addEntity(new SofaA(handler, (64 * 2) + 16, 1280, Map));
		handler.getWorld().getEntityManager().addEntity(new SideTableA(handler, (32 * 5) - 12, 1370, Map));		
		handler.getWorld().getEntityManager().addEntity(new WoodCounterA0(handler, 64 * 6, 64 * 18, Map));
		handler.getWorld().getEntityManager().addEntity(new WoodCounterA1(handler, 64 * 9, 64 * 18, Map));
		handler.getWorld().getEntityManager().addEntity(new WoodCounterA2(handler, 64 * 6, 64 * 19, Map));
		handler.getWorld().getEntityManager().addEntity(new ClockA(handler, (64 * 8) - 16, 1110, Map));
		handler.getWorld().getEntityManager().addEntity(new KeyBox(handler, 64 * 7, 1110, Map));	
		handler.getWorld().getEntityManager().addEntity(new IndoorPlantA(handler, 64 * 5, 680, Map));
		handler.getWorld().getEntityManager().addEntity(new IndoorPlantA(handler, 64 * 10, 680, Map));
		handler.getWorld().getEntityManager().addEntity(new IndoorPlantA(handler, 64 * 5, (64 * 3) + 35, Map));
		handler.getWorld().getEntityManager().addEntity(new IndoorPlantA(handler, 64 * 10, (64 * 3) + 35, Map));
	}
	
	public void constructWall01L1(int start, int end, int axis_x) {
		for(int i = start; i > end; i--) handler.getWorld().getEntityManager().addWall(new Wall01L1(handler, axis_x, 32 * i, MapAssignment.Map001));
	}
	
	public void constructWall01T0(int axis_y) {
		for(int i = 5; i < 24; i++) handler.getWorld().getEntityManager().addWall(new Wall01T0(handler, 32 * i, axis_y, MapAssignment.Map001));
	}
	
	public void constructWall01B0(int axis_y) {
		for(int i = 5; i < 24; i++) handler.getWorld().getEntityManager().addEntity(new Wall01B0(handler, 32 * i, axis_y, MapAssignment.Map001));
	}

	public void resetOriginalState() {

	}

	public Entity clone() {
		Entity e = new ApartmentDoor(handler, hud, dd, tran, x, y);
		return e;
	}

}
