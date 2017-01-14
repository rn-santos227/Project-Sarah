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

public class EnergyDrinkA extends Item {
	protected Handler handler;
	protected HUD hud;
	protected String Description;
		
	public EnergyDrinkA(Handler handler, HUD hud, float x, float y) {
		super(ItemAssets.EnergyDrink_A, x, y, "Energy Drink", 8, ItemCategory.Consumable, true, false, false, true);
		this.handler = handler; this.hud = hud;
		loadScript = new LoadScript("Dialogues.lua");
		loadScript.runScript("getItemDescription008", this);
	}

	public void use() {
		Player.itemName = this.item_name;
		Player.Examining = true; 
		Player.messages = "You drank the energy drink, you felt slightly recharged.";
		Player.dID = DialogID.item; Player.displayDialog = true;
		Player.z_delay = true;
		
		Player.resetAll();
		
		if(hud.getEngMeter().getM_amount() < hud.getF_HEIGHT()) {
			hud.getEngMeter().setM_amount(hud.getEngMeter().getM_amount() + 5);
			hud.getEngMeter().setB_amount(hud.getEngMeter().getB_amount() - 5);
		}
		
		Item item = new EmptyCanA(handler, ItemAssets.EnergyDrink_A, hud, 0, 0);
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
