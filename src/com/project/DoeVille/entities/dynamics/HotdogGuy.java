package com.project.Doeville.entities.dynamics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.dialogs.list.NPCDialog;
import com.project.Doeville.dialogs.list.QuestionDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.Item;
import com.project.Doeville.items.list.Hotdog;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.sounds.SoundEffect;

public class HotdogGuy extends DynamicEntity {
	private ArrayList<String> options;
	private DisplayDialog dd;
	private BufferedImage NPCfacing;
	private HUD hud;
	private String message;
	private int mID, oID;
	private float x, y;

	public int messageIndex = 0;

	public HotdogGuy(Handler handler, HUD hud, DisplayDialog dd, float x, float y) {
		super(handler, x, y, DynamicEntity.DEFAULT_W, DynamicEntity.DEFAULT_H, EntityID.NonPlayable, MapAssignment.Map000);
		this.dd = dd; this.hud = hud; this.x = x; this.y = y;
		options = new ArrayList<String>();
		loadScript = new LoadScript("Dialogues.lua");
		mID = 0; oID = 0;

		bounds.x = 16;
		bounds.y = 40;
		bounds.width = 35;
		bounds.height = 30;
		NPCfacing = Assets.HotdogGuy[0];
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(NPCfacing, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);	
	}

	public void examine() {
		dd.getqBox().clearOptions();
		if(Player.tu) NPCfacing = Assets.HotdogGuy[0];
		else if(Player.td) { Player.dID = DialogID.empty; return; }
		else if(Player.tl) NPCfacing = Assets.HotdogGuy[1];
		else if(Player.tr) NPCfacing = Assets.HotdogGuy[3];
		
		options.clear();
		mID = Player.mID; 
		oID = Player.oID;
		
		if(Player.mID == 0) {
			dd.getqBox().NPCQuestionBox = true;
			Player.dID = DialogID.question;
			QuestionDialog.NPCName = "Hotdog Vendor";
			loadScript.runScript("getNPCDialog001", this);
			Player.messages = message;
			dd.getqBox().addAllOptions(options);
			Player.Examining = true; 
			Player.displayDialog = true;
		}
		
		else if(Player.mID == 1) {
			Player.dID = DialogID.npc;
			NPCDialog.NPCName = "Hotdog Vendor";
			loadScript.runScript("getNPCDialog001", this);
			Player.displayDialog = true;
			Player.Examining = true;
			if(Player.oID == 0) {
				if(hud.getDoellar() >= 10) {
						if(handler.getWorld().getItemManager().uniqueItemID.size() <= 30) {
							SoundEffect.PickUp.play();
							Item item = new Hotdog(handler, hud, 0, 0);
							handler.getWorld().getItemManager().addItemToInventory(item);
							hud.setDoellar(hud.getDoellar() - 10);
						} else  { SoundEffect.Cancel.play(); message = "Seems that you cannot carry anymore."; }
					} else { SoundEffect.Cancel.play(); message = "Seems that you don't have enough money."; }
			}
			if(Player.oID == 2) {
				if(hud.getMooMeter().getM_amount() < hud.getF_HEIGHT()) {
					hud.getMooMeter().setM_amount(hud.getMooMeter().getM_amount() + 3);
					hud.getMooMeter().setB_amount(hud.getMooMeter().getB_amount() - 3);
				}
			}
			Player.messages = message;
			Player.resetAll();
		}
	}

	public Entity clone() {
		Entity e = new HotdogGuy(handler, hud, dd, x, y);
		return e;
	}
	
	public void resetOriginalState() {
		NPCfacing = Assets.HotdogGuy[0];
	}
	
	public void addOptions(String option) {
		options.add(option);
	}

	public int getMessageIndex() {
		return messageIndex;
	}

	public void setMessageIndex(int messageIndex) {
		this.messageIndex = messageIndex;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getmID() {
		return mID;
	}

	public int getoID() {
		return oID;
	}
}
