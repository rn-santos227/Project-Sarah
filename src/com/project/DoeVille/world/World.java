package com.project.Doeville.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import com.project.Doeville.Handler;
import com.project.Doeville.data.BankInformation;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityManager;
import com.project.Doeville.entities.dynamics.HotdogGuy;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.entities.dynamics.Sarah;
import com.project.Doeville.entities.statics.HotdogCart;
import com.project.Doeville.entities.statics.StreetLamp;
import com.project.Doeville.entities.statics.TrashBinA;
import com.project.Doeville.entities.statics.Tree;
import com.project.Doeville.entities.statics.WhiteFenceB;
import com.project.Doeville.entities.statics.WhiteFenceBL;
import com.project.Doeville.entities.statics.WhiteFenceBR;
import com.project.Doeville.entities.statics.WhiteFenceL;
import com.project.Doeville.entities.statics.WhiteFenceR;
import com.project.Doeville.entities.statics.WhiteFenceT;
import com.project.Doeville.entities.statics.WhiteFenceTL;
import com.project.Doeville.entities.statics.WhiteFenceTR;
import com.project.Doeville.entities.statics.buildings.Apartment;
import com.project.Doeville.entities.statics.buildings.ConvenienceStore;
import com.project.Doeville.entities.statics.buildings.ITWorkplace;
import com.project.Doeville.entities.statics.buildings.Library;
import com.project.Doeville.entities.statics.buildings.Pharmacy;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.ItemManager;
import com.project.Doeville.lights.Light;
import com.project.Doeville.tiles.Tile;
import com.project.Doeville.utils.Util;

public class World {

	protected ArrayList<Entity> worldObject;
	protected Handler handler;
	protected int width, height;
	protected int spawnX, spawnY;
	protected int[][] tiles;
	protected String path;
	protected DisplayDialog dd;
	protected EntityManager entityManager;
	protected ItemManager itemManager;
	protected Light light;

	
	protected BankInformation bankInformation;
	
	public World(Handler handler, HUD hud, DisplayDialog dd, Transition tran, String path) {
		this.handler = handler;
		this.path = path;
		this.dd = dd;
		
		worldObject = new ArrayList<Entity>();
		light = new Light(handler);
		entityManager = new EntityManager(handler, new Player(handler, hud, dd, 0, 0));
		itemManager = new ItemManager(handler);
		bankInformation = new BankInformation();
		
		addResidentialEntities(handler, hud, dd, tran);
		copyObjectsToEntityManager();
		
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		Player.displayDialog = true;
		Player.dID = DialogID.alert;;
		Player.messages = "Doeville Downtown";
	}

	public void tick() {
		entityManager.tick();
		itemManager.tick();
	}
	
	public void copyObjectsToEntityManager() {
		Iterator<Entity> it = worldObject.iterator();
		while(it.hasNext()) {
			entityManager.addEntity(it.next().clone());
		}

	}
	
	public void addResidentialEntities(Handler handler, HUD hud, DisplayDialog dd, Transition tran) {		
		
		worldObject.add(new Tree(handler, 420, 800));
		worldObject.add(new Tree(handler, 440, 735));
		worldObject.add(new Tree(handler, 1220, 735));
		worldObject.add(new Tree(handler, 1240, 800));
		worldObject.add(new Tree(handler, 435, 1250));
		worldObject.add(new Tree(handler, 415, 1320));
		worldObject.add(new Tree(handler, 795, 1250));
		worldObject.add(new Tree(handler, 815, 1320));
		
		worldObject.add(new WhiteFenceTL(handler, 440, 805));
		worldObject.add(new WhiteFenceT(handler, 472, 805));
		worldObject.add(new WhiteFenceT(handler, 504, 805));
		worldObject.add(new WhiteFenceT(handler, 536, 805));
		worldObject.add(new WhiteFenceL(handler, 440, 837));
		worldObject.add(new WhiteFenceL(handler, 440, 869));
		worldObject.add(new WhiteFenceL(handler, 440, 901));
		worldObject.add(new WhiteFenceBL(handler, 440, 933));
		worldObject.add(new WhiteFenceB(handler, 472, 933));
		worldObject.add(new WhiteFenceB(handler, 504, 933));
		worldObject.add(new WhiteFenceB(handler, 536, 933));		
		worldObject.add(new WhiteFenceTR(handler, 1320, 805));
		worldObject.add(new WhiteFenceT(handler,  1288, 805));
		worldObject.add(new WhiteFenceT(handler, 1256, 805));
		worldObject.add(new WhiteFenceT(handler, 1224, 805));
		worldObject.add(new WhiteFenceR(handler, 1320, 837));
		worldObject.add(new WhiteFenceR(handler, 1320, 869));
		worldObject.add(new WhiteFenceR(handler, 1320, 901));
		worldObject.add(new WhiteFenceBR(handler, 1320, 933));
		worldObject.add(new WhiteFenceB(handler, 1256, 933));
		worldObject.add(new WhiteFenceB(handler, 1224, 933));
		worldObject.add(new WhiteFenceB(handler, 1288, 933));	
		
		worldObject.add(new Pharmacy(handler, hud, dd, tran, 558, 768));
		worldObject.add(new Apartment(handler, hud, dd, tran, 758, 672));
		worldObject.add(new Library(handler, hud, dd, tran, 550, 1158));
		worldObject.add(new ITWorkplace(handler, hud, dd, tran, 1080, 1158));
		worldObject.add(new ConvenienceStore(handler, hud, dd, tran, 1085, 768));
		
		worldObject.add(new HotdogGuy(handler, hud, dd, 1060, 950));
		worldObject.add(new HotdogCart(handler, hud, 1030, 970));
		worldObject.add(new TrashBinA(handler, hud, 1060, 830));
		
		worldObject.add(new StreetLamp(handler, 355 , 665));
		worldObject.add(new StreetLamp(handler, 1405 , 665));
		
		worldObject.add(new StreetLamp(handler, 355 , 945));
		worldObject.add(new StreetLamp(handler, 565 , 945));
		worldObject.add(new StreetLamp(handler, 775 , 945));
		worldObject.add(new StreetLamp(handler, 985 , 945));
		worldObject.add(new StreetLamp(handler, 1195 , 945));
		worldObject.add(new StreetLamp(handler, 1405 , 945));
		
		worldObject.add(new StreetLamp(handler, 355 , 1465));
		worldObject.add(new StreetLamp(handler, 565 , 1465));
		worldObject.add(new StreetLamp(handler, 775 , 1465));
		worldObject.add(new StreetLamp(handler, 985 , 1465));
		worldObject.add(new StreetLamp(handler, 1195 , 1465));
		worldObject.add(new StreetLamp(handler, 1405 , 1465));
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public void render(Graphics g) {
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() / Tile.t_Width);
		int xEnd = (int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.t_Width + 1);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.t_Height);;  
		int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.t_Height + 1);;
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x ++) {
				getTile(x, y).render(g, (int)(x * Tile.t_Width - handler.getGameCamera().getxOffset()), (int)(y * Tile.t_Height - handler.getGameCamera().getyOffset()));		
			}
		}
		light.render(g);
		itemManager.render(g);
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) return Tile.grassTile;
		return t;
	}
	
	public void loadWorld(String path) {
		String file = Util.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Util.parseInt(tokens[0]);
		height = Util.parseInt(tokens[1]);
		spawnX = Util.parseInt(tokens[2]);
		spawnY = Util.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x ++) {
				tiles[x][y] = Util.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public Handler getHandler() { return handler; }
	public void setHandler(Handler handler) { this.handler = handler; }
	public ItemManager getItemManager() { return itemManager; }
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public EntityManager getEntityManager() { return entityManager; }

	public BankInformation getBankInformation() {
		return bankInformation;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}
}
