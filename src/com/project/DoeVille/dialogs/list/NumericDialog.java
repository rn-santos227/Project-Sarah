package com.project.Doeville.dialogs.list;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogUtil;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.sounds.SoundEffect;
import com.project.Doeville.utils.Util;

public class NumericDialog extends DialogUtil {
	private BufferedImage i_ones, i_tens, i_hundreds, i_thousands;
	private Entity entity;
	private Handler handler;
	private String header;
	private String totalAmount;
	private int x, placementValue;
	private boolean u_flag, d_flag, l_flag, r_flag, z_flag, x_flag;
	private boolean ones, tens, hundreds, thousands, recieveTransaction;
	public int A, B, C, D;
	public boolean z_delay;
	private double getAmount, convertedAmount;
	
	public NumericDialog(Handler handler) {
		timer = 0; lastTime = System.currentTimeMillis();
		this.handler = handler;
		x = handler.getWidth();

		i_ones = Assets.numberPanel2[0];
		i_tens = Assets.numberPanel1[0];
		i_hundreds = Assets.numberPanel1[0];
		i_thousands = Assets.numberPanel1[0];
		u_flag = false; d_flag = false; l_flag = false; r_flag = false; z_flag = false; x_flag = false; 
		z_delay = true;
		ones = true; tens = false; hundreds = false; thousands = false;
		A = 0; B = 0; C = 0; D = 0; 
		placementValue = 0; header = "Set Amount:";
		recieveTransaction = false;
	}
	
	public void tick() {
		if(!Player.paused) {
					
			if(!handler.getKeyManager().up) u_flag = false;
			if(!handler.getKeyManager().down) d_flag = false;
			if(!handler.getKeyManager().right) r_flag = false;
			if(!handler.getKeyManager().left) l_flag = false;
			if(!handler.getKeyManager().button_X) x_flag = false;
			if(!handler.getKeyManager().button_Z) z_flag = false;
			if(u_flag || d_flag || r_flag || l_flag || x_flag || z_flag) return;
			
				
			if(handler.getKeyManager().button_Z) {
				if(!this.z_delay) {
					totalAmount = String.valueOf(D) + String.valueOf(C) + String.valueOf(B) + String.valueOf(A);
					convertedAmount = Util.parseInt(totalAmount);
					if(convertedAmount < 100 ) { SoundEffect.Cancel.play(); header = "The Amount must not be less than 100."; }
					else if(convertedAmount > (getAmount - 100) && convertedAmount <= getAmount) { SoundEffect.Cancel.play(); header = "You must have at least 100 in your account."; }
					else if(convertedAmount >= getAmount) { SoundEffect.Cancel.play(); header = "You entered an Amount greater than in your balance."; }
					else {
						SoundEffect.PickUp.play();
						resetAmount();
						Player.mID = 1; Player.oID = 0;
						recieveTransaction = true;
						entity.examine();
					}
				}
				this.z_delay = false; z_flag = true; return; 
			}
			
			if(handler.getKeyManager().button_X) {
				header = "Set Amount:";
				Player.mID = 0;
				entity.examine();
				A = 0; B = 0; D = 0; C = 0;
				switchPlacements();
				x_flag = true; return;
			}
				
				
			if(handler.getKeyManager().right) {
				placementValue--;
				if(placementValue < 0) { placementValue = 0; SoundEffect.Cancel.play(); }
				else SoundEffect.CursorMove.play();
				switchPlacements();
				r_flag = true; return;
			}
			
			else if(handler.getKeyManager().left) {
				placementValue++;
				if(placementValue > 3) { placementValue = 3; SoundEffect.Cancel.play(); }
				else SoundEffect.CursorMove.play();
				switchPlacements();
				l_flag = true; return;
			}
				
			if(handler.getKeyManager().up) { NumericUpDown(1); switchPlacements(); u_flag = true; return; }				
			else if(handler.getKeyManager().down) {	NumericUpDown(-1); switchPlacements(); d_flag = true; return; }
		}
	}
	
	public void resetAmount() {
		header = "Set Amount:";
		ones = true; tens = false; hundreds = false; thousands = false;
		placementValue = 0;
		A = 0; B = 0; D = 0; C = 0;
		switchPlacements();
		z_delay = true;
	}
	
	public void switchPlacements() {
		switch(placementValue) {
		case 0: i_ones = Assets.numberPanel2[A]; i_tens = Assets.numberPanel1[B]; i_hundreds = Assets.numberPanel1[C]; i_thousands = Assets.numberPanel1[D]; 
		ones = true; tens = false; hundreds = false; thousands = false; break;
		case 1: i_ones = Assets.numberPanel1[A]; i_tens = Assets.numberPanel2[B]; i_hundreds = Assets.numberPanel1[C]; i_thousands = Assets.numberPanel1[D]; 
		ones = false; tens = true; hundreds = true;  thousands = false; break;
		case 2: i_ones = Assets.numberPanel1[A]; i_tens = Assets.numberPanel1[B]; i_hundreds = Assets.numberPanel2[C]; i_thousands = Assets.numberPanel1[D]; 
		ones = false; tens = false; hundreds = true; thousands = false; break;
		case 3: i_ones = Assets.numberPanel1[A]; i_tens = Assets.numberPanel1[B]; i_hundreds = Assets.numberPanel1[C]; i_thousands = Assets.numberPanel2[D]; 
		ones = false; tens = false; hundreds = false; thousands = true; break;
		}
	}
	
	public void NumericUpDown(int x) {
		if(ones) { A += x; if(A < 0) { A = 0; SoundEffect.Cancel.play(); } else if(A > 9) { A = 9; SoundEffect.Cancel.play(); } else SoundEffect.Confirm.play(); }
		else if(tens)  { B += x; if(B < 0) { B = 0; SoundEffect.Cancel.play(); } else if(B > 9) { B = 9; SoundEffect.Cancel.play(); } else SoundEffect.Confirm.play(); }
		else if(hundreds)  { C += x; if(C < 0) { C = 0; SoundEffect.Cancel.play(); } else if(C > 9) { C = 9; SoundEffect.Cancel.play(); } else SoundEffect.Confirm.play(); }
		else if(thousands)  { D += x; if(D < 0) { D = 0; SoundEffect.Cancel.play(); } else if(D > 9) { D = 9; SoundEffect.Cancel.play(); } else SoundEffect.Confirm.play(); }
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		buildFrame(g, Assets.dialogBox[0], Assets.dialogBox[3], Assets.dialogBox[6], (x / 2) - (32 * 4));
		for(int i = 3; i >= 0; i--) buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) - (32 * i));
		buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) + 32);
		buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) + (32 * 2));
		buildFrame(g, Assets.dialogBox[2], Assets.dialogBox[5], Assets.dialogBox[8], (x / 2) + (32 * 3));
		g2d.setComposite(makeTransparent(1));
		
		g.setFont(handler.getFF().customFont);
		drawString(g, header, (x / 2) - (32 * 3) - 15, 35, 230);
		
		g.drawImage(i_thousands, (x / 2) - ((32 * 2) + 10), 70, 32, 32, null);
		g.drawImage(i_hundreds, ((x / 2) - ((32 * 2) + 10)) + 40, 70, 32, 32, null);
		g.drawImage(i_tens, ((x / 2) - ((32 * 2) + 10)) + 80, 70, 32, 32, null);
		g.drawImage(i_ones, ((x / 2) - ((32 * 2) + 10)) + 120, 70, 32, 32, null);
	}
	
	private void buildFrame(Graphics g, BufferedImage bi1, BufferedImage bi2, BufferedImage bi3, int a) {
		g.drawImage(bi1, a, 5, 32, 32, null);
		for(int i = 1; i < 3; i++ ) g.drawImage(bi2, a, (32 * i) + 5, 32, 32, null);
		g.drawImage(bi3, a, (32 * 3) + 5, 32, 32, null);
	}

	public double getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(double getAmount) {
		this.getAmount = getAmount;
	}
	

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public boolean isRecieveTransaction() {
		return recieveTransaction;
	}

	public void setRecieveTransaction(boolean recieveTransaction) {
		this.recieveTransaction = recieveTransaction;
	}

}
