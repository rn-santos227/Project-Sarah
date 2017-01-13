package com.project.Doeville.entities.triggers;

import java.awt.Graphics;
import java.util.ArrayList;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.sounds.SoundEffect;
import com.project.Doeville.tiles.Tile;

public class ATM extends Entity {
	private ArrayList<String> options;
	private String message, recieve;
	private DisplayDialog dd;
	private HUD hud;
	private int mID, oID, cID;
	private double currentBalance;
	private float x, y;

	public ATM(Handler handler, HUD hud, DisplayDialog dd, float x, float y) {
		super(handler, x, y, Tile.t_Width/2, Tile.t_Height/2, EntityID.Object, MapAssignment.Map000);
		this.dd = dd; this.handler = handler; this.hud = hud; this.x = x; this.y = y;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = (Tile.t_Width/2) - 2;
		bounds.height = Tile.t_Height/2;
		loadScript = new LoadScript("Dialogues.lua");
		options = new ArrayList<String>();
		mID = 0; oID = 0; cID = 1; recieve = "false";
	}
	

	public void tick() {
		
	}

	public void render(Graphics g) {
		
	}

	public void examine() {
		currentBalance = handler.getWorld().getBankInformation().getCurrentBalance();
		dd.getNumBox().resetAmount();
		dd.getqBox().clearOptions(); dd.getqBox().content = ""; dd.getqBox().index = 0; 
		options.clear(); dd.getNumBox().setEntity(this);
		Player.condition = dd.getNumBox().isRecieveTransaction();
		recieve = String.valueOf(Player.condition);
		cID = Player.onHand.equals("ATM Card") ? 0 : 1;
		this.mID = Player.mID; this.oID = Player.oID;
		loadScript.runScript("getTriggerDialouge001", this);
		
		if(cID == 0) {
			if(mID == 0) {		
				SoundEffect.Confirm.play();
				dd.getqBox().ObjectQuestionBox = true;
				Player.dID = DialogID.question;
				dd.getqBox().addAllOptions(options);
				Player.messages = this.message;
			}
			else if(mID == 1) {
				if(oID == 0) {
					if(Player.condition) {
						hud.setDoellar(hud.getDoellar() + (int)dd.getNumBox().getConvertedAmount());
						handler.getWorld().getBankInformation().setCurrentBalance(handler.getWorld().getBankInformation().getCurrentBalance() - dd.getNumBox().getConvertedAmount());
						dd.getNumBox().setRecieveTransaction(false);
						dd.getNumBox().setConvertedAmount(0);
					} else SoundEffect.Confirm.play();
					
					dd.getqBox().ObjectQuestionBox = true;
					Player.dID = DialogID.question;
					dd.getqBox().addAllOptions(options);
					Player.messages = this.message;
				}
				else if(oID == 1) {
					if(handler.getWorld().getBankInformation().getCurrentBalance() > 200) {
						dd.getNumBox().setGetAmount(currentBalance);
						SoundEffect.Confirm.play();
						Player.dID = DialogID.numeric;
					}
					else {
						SoundEffect.Cancel.play();
						Player.dID = DialogID.information;
						Player.messages = "You cannot withdraw anymore";
						Player.oID = 0; Player.mID = 0;
					}
				}
				else if(oID == 2) {
					exitATM();
				}
			}
			
			else if(mID == 2) {
				if(oID == 0) { SoundEffect.Confirm.play(); Player.mID = 0; Player.oID = 0; this.examine(); }
				else if(oID == 1) exitATM();
			}
		}
		else {
			SoundEffect.Cancel.play();
			Player.dID = DialogID.information;
			Player.messages = this.message;
			Player.mID = 0;
			cID = 0;
		}
	}
	
	private void exitATM() {
		SoundEffect.Cancel.play();
		dd.getqBox().setEndPrint(false); dd.getqBox().content = ""; dd.getqBox().index = 0;
		Player.resetAll(); Player.dID = DialogID.empty;
	}
	
	public Entity clone() {
		Entity e = new ATM(handler, hud, dd, x, y);
		return e;
	}
	
	public void addOptions(String option) {
		options.add(option);
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
	
	public int getcID() {
		return cID;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}
	
	public String getRecieve() {
		return recieve;
	}

	public void resetOriginalState() {
		
	}
}
