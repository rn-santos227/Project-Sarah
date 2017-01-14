package com.project.Doeville.items.list;

import java.awt.Graphics;
import java.util.Random;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.ItemAssets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.Item;
import com.project.Doeville.items.ItemCategory;
import com.project.Doeville.scripts.LoadScript;

public class PotatoChips extends Item {
	protected Handler handler;
	protected HUD hud;
	protected String Description;
	protected String Message;
	protected Random ran;
		
	public PotatoChips(Handler handler, HUD hud, float x, float y) {
		super(ItemAssets.PotatoChips, x, y, "Potato Chips", 10, ItemCategory.Consumable, true, false, false, true);
		this.handler = handler; this.hud = hud;
		loadScript = new LoadScript("Dialogues.lua");
		loadScript.runScript("getItemDescription010", this);
	}

	public void use() {
		Player.itemName = this.item_name;
		ran = new Random();
		int trigger = ran.nextInt(10);
		
		if(trigger == 5) {
			Player.Examining = true; 
			Player.messages = "Somehow you didn't feel good after eating this. Too salty.";
			Player.dID = DialogID.item; Player.displayDialog = true;
			Player.z_delay = true;
			
			Player.resetAll();
			hud.getHunMeter().isEating = true;
			hud.getHunMeter().amount = 0.65;
			hud.getHunMeter().finishEatingTime += 20;
			
			hud.getHeaMeter().setM_amount(hud.getHeaMeter().getM_amount() - 2);
			hud.getHeaMeter().setB_amount(hud.getHeaMeter().getB_amount() + 2);
		}
		
		else {
			Player.Examining = true; 
			Player.messages = "You ate some potato chips, yes it is really quite salty";
			Player.dID = DialogID.item; Player.displayDialog = true;
			Player.z_delay = true;			
			Player.resetAll();
			hud.getHunMeter().isEating = true;
			hud.getHunMeter().amount = 0.65;
			hud.getHunMeter().finishEatingTime += 20;
		}
		
		Item item = new EmptyBag(handler, hud, 0, 0);
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
