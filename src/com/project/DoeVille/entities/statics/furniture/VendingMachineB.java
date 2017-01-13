package com.project.Doeville.entities.statics.furniture;

import java.awt.Graphics;
import java.util.ArrayList;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.dialogs.list.QuestionDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.list.Snack0;
import com.project.Doeville.items.list.Snack1;
import com.project.Doeville.items.list.Snack2;
import com.project.Doeville.items.list.Snack3;
import com.project.Doeville.items.list.Snack4;
import com.project.Doeville.items.list.Snack5;
import com.project.Doeville.items.list.Snack6;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.sounds.SoundEffect;
import com.project.Doeville.tiles.Tile;

public class VendingMachineB extends Entity {
	public int messageIndex;
	
	private ArrayList<String> options;
	private HUD hud;
	private DisplayDialog dd;
	private String message;
	private MapAssignment map;
	private int mID, oID;
	private float x, y;

	public VendingMachineB(Handler handler, HUD hud, DisplayDialog dd, float x, float y, MapAssignment mapAssignment) {
		super(handler, x, y, Tile.t_Width, (Tile.t_Height / 2) * 3, EntityID.Object, mapAssignment);
		this.hud = hud; this.dd = dd; this.x = x; this.y = y; this.map = mapAssignment;
		options = new ArrayList<String>();
		loadScript = new LoadScript("Dialogues.lua");
		bounds.x = 10;
		bounds.y = 40;
		bounds.width = width - 20;
		bounds.height = height - 40;	
		mID = 0; oID = 0;
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.VendingMachineB, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);		
		
	}

	public void examine() {
		dd.getqBox().clearOptions();
		options.clear(); mID = Player.mID; oID = Player.oID;
		if(Player.mID == 0) {
			dd.getqBox().NPCQuestionBox = true;
			Player.dID = DialogID.question;
			QuestionDialog.NPCName = "Vending Machine";
			loadScript.runScript("getVendingManchineOptionB", this);
			dd.getqBox().addAllOptions(options);
			Player.messages = message;
			Player.Examining = true; 
			Player.displayDialog = true;			
		}
		else if(Player.mID == 1) {
			dd.getqBox().clearOptions();
			if(oID == 0) {
				if(handler.getWorld().getItemManager().uniqueItemID.size() < 30) {
					SoundEffect.Confirm.play();
					dd.getvmBox().addOptions(new Snack0(handler, hud, 0, 0), 25);
					dd.getvmBox().addOptions(new Snack1(handler, hud, 0, 0), 25);
					dd.getvmBox().addOptions(new Snack2(handler, hud, 0, 0), 25);
					dd.getvmBox().addOptions(new Snack3(handler, hud, 0, 0), 30);
					dd.getvmBox().addOptions(new Snack4(handler, hud, 0, 0), 20);
					dd.getvmBox().addOptions(new Snack5(handler, hud, 0, 0), 20);
					dd.getvmBox().addOptions(new Snack6(handler, hud, 0, 0), 25);
					
					Player.dID = DialogID.vending_machine;
					Player.displayDialog = true;
					Player.Examining = true;
				} else {
					Player.dID = DialogID.message;			
					Player.displayDialog = true;
					Player.Examining = true;

					Player.messages = "Seems that you cannot carry anymore.";
				}
				Player.resetAll();
			}
			else {
				Player.dID = DialogID.message;			
				loadScript.runScript("getVendingManchineOptionB", this);
				Player.displayDialog = true;
				Player.Examining = true;

				Player.messages = message;
				Player.resetAll();
			}
		}
	}

	public Entity clone() {
		Entity e = new VendingMachineB(handler, hud, dd, x, y, map);
		return e;
	}

	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
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
