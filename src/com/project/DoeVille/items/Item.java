package com.project.Doeville.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;

public abstract class Item {
	
	//Handler
	public static Item[] items = new Item[256];

	
	//Class
	public static final int ITEM_W = 24, ITEM_H = 24;
	protected final int id;
	protected LoadScript loadScript;
	protected Handler handler;
	protected BufferedImage texture;
	protected String item_name;
	protected Rectangle bounds;
	protected ItemCategory category;
	protected String description;
	
	protected float x, y;
	protected int count;
	protected double price;
	protected boolean picked_up = false;
	protected boolean canUse, canEquip, canCheck, canDrop;
	protected boolean Equipped;

	public Item(BufferedImage texture, float x, float y, String item_name, int id, ItemCategory category, boolean canUse, boolean canEquip, boolean canCheck, boolean canDrop) {
		this.texture= texture; this.item_name = item_name; this.id = id;
		this.category = category; this.x = x; this.y = y;
		this.canUse = canUse; this.canEquip = canEquip; this.canCheck = canCheck; this.canDrop = canDrop;
		Equipped = false;
		count = 1; 
		items[id] = this;
		bounds = new Rectangle(0, 0, ITEM_W, ITEM_H);
	}
	

	public abstract void use();
	public abstract void check();
	public void drop(Handler handler) {
		String article;
		
		handler.getWorld().getItemManager().addItem(this);
		this.setPicked_up(false);
		Player.itemName = this.item_name;
				
		if(Player.tu) this.setPosition((int)((handler.getWorld().getEntityManager().getPlayer().getX()) + 20),(int)((handler.getWorld().getEntityManager().getPlayer().getY())) + 25);
		else if(Player.td) this.setPosition((int)((handler.getWorld().getEntityManager().getPlayer().getX()) + 20),(int)((handler.getWorld().getEntityManager().getPlayer().getY())) + 65);
		else if(Player.tr) this.setPosition((int)((handler.getWorld().getEntityManager().getPlayer().getX()) + 45),(int)((handler.getWorld().getEntityManager().getPlayer().getY())) + 40);
		else if(Player.tl) this.setPosition((int)(handler.getWorld().getEntityManager().getPlayer().getX()) - 5,(int)((handler.getWorld().getEntityManager().getPlayer().getY())) + 40);
		
		switch(this.item_name.charAt(0)) {
		case 'A': case 'a': case 'E': case 'e': case 'I': case 'i': case 'O': case 'o': case 'U': case 'u': article = "an"; break;
		default: article = "a";
		}

		Player.Examining = true;
		Player.messages = article + " " + this.item_name + " has been dropped";
		Player.dID = DialogID.item;
		Player.displayDialog = true;
		Player.resetAll();
		Player.z_delay = true;
	}
	
	public void hold(Handler handler, HUD hud) {
		if(!this.Equipped) { 
			for(Item i : handler.getWorld().getItemManager().inventory) { if(i.texture == hud.onHandItem) { i.setEquipped(false); } }
			hud.onHandItem = this.texture; this.Equipped = true; Player.onHand = this.item_name;
			Player.Examining = true; Player.itemName = this.item_name;
			Player.messages = "The " + this.item_name + " has been equiped";	
			Player.dID = DialogID.item; Player.displayDialog = true;
			Player.resetAll();
		}
		else { 
			hud.onHandItem = null; this.Equipped = false; Player.onHand = "Nothing"; Player.itemName = this.item_name;
			Player.Examining = true; Player.messages = "The " + this.item_name + " has been unequiped";	
			Player.dID = DialogID.item; Player.displayDialog = true;
			Player.resetAll();
		}
		Player.z_delay = true;
	}
	
	public abstract void render(Graphics g);
	
	public static int getIndexFromCollisions(Handler handler, float xOffset, float yOffset, Entity e){
		for(Item i : handler.getWorld().getItemManager().items) {
			if(i.getCollisionBounds(0f, 0f).intersects(e.getCollisionBounds(xOffset, yOffset))) return handler.getWorld().getItemManager().items.indexOf(i);
		}
		return (int) 0;
	}
	
	public static boolean checkItemCollisions(Handler handler, float xOffset, float yOffset, Entity e){
		for(Item i : handler.getWorld().getItemManager().items) {
			if(i.getCollisionBounds(0f, 0f).intersects(e.getCollisionBounds(xOffset, yOffset))) return true;
		}
		return false;
	}
	
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	public void setPosition(int x, int y) {
		this.x = x; this.bounds.x = 0;
		this.y = y; this.bounds.y = 0;
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getId() {
		return id;
	}

	public ItemCategory getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
		 
	public boolean isPicked_up() {
		return picked_up;
	}

	public void setPicked_up(boolean picked_up) {
		this.picked_up = picked_up;
	}
	
	public boolean isEquipped() {
		return Equipped;
	}

	public void setEquipped(boolean equipped) {
		Equipped = equipped;
	}

	public boolean isCanUse() {
		return canUse;
	}

	public boolean isCanEquip() {
		return canEquip;
	}

	public boolean isCanCheck() {
		return canCheck;
	}

	public boolean isCanDrop() {
		return canDrop;
	}
}
