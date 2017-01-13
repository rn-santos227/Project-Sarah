package com.project.Doeville.entities.dynamics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.dialogs.list.NPCDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.gfx.Animation;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;

public class Johnny extends DynamicEntity {
	private BufferedImage NPCfacing;
	private String message;
	private int messageID;
	private Random ran;
	private HUD hud;
	private DisplayDialog dd;
	private float x, y;

	public Johnny(Handler handler, HUD hud, DisplayDialog dd, float x, float y) {
		super(handler, x, y, DynamicEntity.DEFAULT_W, DynamicEntity.DEFAULT_H, EntityID.NonPlayable, MapAssignment.Map000);
		this.hud = hud; this.dd = dd; this.x = x; this.y = y;
		bounds.x = 16;
		bounds.y = 40;
		bounds.width = 35;
		bounds.height = 30;
		loadScript = new LoadScript("Dialogues.lua");
		NPCfacing = Assets.Johnny[0];
	}
	
	public void tick() {

	}
	
	public void render(Graphics g) {
		g.drawImage(NPCfacing, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	public void resetOriginalState() {

	}

	public void examine() {
		
		dd.getNpcBox();
		NPCDialog.NPCName = "Johnny";
		
		Player.dID = DialogID.npc;
		ran = new Random();
		messageID = ran.nextInt(5);
		Player.messages = message;
		Player.mID = 0;

		
		if(hud.getMooMeter().getM_amount() < hud.getF_HEIGHT()) {
			hud.getMooMeter().setM_amount(hud.getMooMeter().getM_amount() + 3);
			hud.getMooMeter().setB_amount(hud.getMooMeter().getB_amount() - 3);
		}
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Entity clone() {
		Entity e = new Johnny(handler, hud, dd, x, y);
		return e;
	}


}
