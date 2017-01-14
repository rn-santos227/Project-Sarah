package com.project.Doeville.items.list;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.gfx.ItemAssets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.Item;
import com.project.Doeville.items.ItemCategory;
import com.project.Doeville.scripts.LoadScript;

public class ATMCard extends Item {
	protected Handler handler;
	protected HUD hud;
	protected String Description;
	
	public ATMCard(Handler handler, HUD hud, float x, float y) {
		super(ItemAssets.ATMCard, x, y, "ATM Card", 6, ItemCategory.KeyItem, false, true, false, false);
		this.handler = handler; this.hud = hud;
		loadScript = new LoadScript("Dialogues.lua");
		loadScript.runScript("getItemDescription006", this);
	}

	public void use() {

	}

	public void check() {

	}

	public void render(Graphics g) {
		g.drawImage(texture, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), ITEM_W, ITEM_H, null);
	}
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
