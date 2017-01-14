package com.project.Doeville.items.list;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.ItemAssets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.Item;
import com.project.Doeville.items.ItemCategory;
import com.project.Doeville.scripts.LoadScript;

public class MilkCartonA extends Item {
	protected Handler handler;
	protected HUD hud;
	protected String Description;
		
	public MilkCartonA(Handler handler, HUD hud, float x, float y) {
		super(ItemAssets.Milk_A, x, y, "Cartoned Milk", 1, ItemCategory.Consumable, true, false, false, true);
		this.handler = handler; this.hud = hud;
		loadScript = new LoadScript("Dialogues.lua");
		loadScript.runScript("getItemDescription002", this);
	}

	public void use() {	
		Player.itemName = this.item_name;
		Player.Examining = true; 
		Player.messages = "You drunk some milk, it was refreshing";
		Player.dID = DialogID.item; Player.displayDialog = true;
		hud.getHunMeter().finishEatingTime = 0;
		Player.z_delay = true;
		
		Player.resetAll();
		hud.getHunMeter().isEating = true;
		hud.getHunMeter().amount = 0.35;
		hud.getHunMeter().finishEatingTime += 15;
		
		if(hud.getHeaMeter().getM_amount() > hud.getF_HEIGHT()) {
			hud.getHeaMeter().setM_amount(hud.getEngMeter().getM_amount() + 2);
			hud.getHeaMeter().setB_amount(hud.getEngMeter().getB_amount() - 2);
		}
		
		Item item = new EmptyMilkCarton(handler, hud, 0, 0);
		handler.getWorld().getItemManager().addItemToInventory(item);
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
