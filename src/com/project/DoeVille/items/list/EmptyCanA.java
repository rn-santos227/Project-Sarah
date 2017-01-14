package com.project.Doeville.items.list;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.project.Doeville.Handler;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.Item;
import com.project.Doeville.items.ItemCategory;
import com.project.Doeville.scripts.LoadScript;

public class EmptyCanA extends Item {
	protected BufferedImage image;
	protected Handler handler;
	protected HUD hud;
	protected String Description;
		
	public EmptyCanA(Handler handler, BufferedImage image, HUD hud, float x, float y) {
		super(image, x, y, "Empty Can", 9, ItemCategory.Equipment, false, false, false, true);
		this.handler = handler; this.hud = hud;
		loadScript = new LoadScript("Dialogues.lua");
		loadScript.runScript("getItemDescription009", this);
	}

	public void use() {		

	}
	
	public void check() {
		
	}

	public void render(Graphics g) {
		g.drawImage(image, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), ITEM_W, ITEM_H, null);
	}
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
