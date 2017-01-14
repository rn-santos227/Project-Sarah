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

public class HealthCapsuleA extends Item {
	protected Handler handler;
	protected HUD hud;
	protected String Description;
		
	public HealthCapsuleA(Handler handler, HUD hud, float x, float y) {
		super(ItemAssets.HealthCapsule, x, y, "Mefenamic Acid", 13, ItemCategory.Medicine, true, false, false, false);
		this.handler = handler; this.hud = hud;
		loadScript = new LoadScript("Dialogues.lua");
		loadScript.runScript("getItemDescription013", this);
	}

	public void use() {
		Player.itemName = this.item_name;
		Player.Examining = true; 
		if(hud.getHeaMeter().getM_amount() >= (hud.getF_HEIGHT() * 0.50)) Player.messages = "You swallowed the capsule, it wasn't effective";
		else Player.messages = "You swallowed the capsule, you felt that the pain have disappeared instatly";
		Player.dID = DialogID.item; Player.displayDialog = true;
		Player.z_delay = true;
		Player.resetAll();
		
		if(hud.getHeaMeter().getM_amount() < (hud.getF_HEIGHT() * 0.50)) {
			hud.getHeaMeter().setM_amount(hud.getHeaMeter().getM_amount() + (hud.getF_HEIGHT() * 0.45));
			hud.getHeaMeter().setB_amount(hud.getHeaMeter().getB_amount() - (hud.getF_HEIGHT() * 0.45));
		}
		
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
