package com.project.Doeville.gamemenus;

import java.awt.Color;
import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.list.PausedDialog;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.sounds.SoundEffect;
import com.project.Doeville.utils.FontFactory;

public class QuitGame extends GameMenu {
	private int x, y, xPos;
	private boolean l_flag, r_flag, z_flag, answer;
	private Handler handler;
	
	public static boolean onQuit;
	
	public QuitGame(Handler handler) {
		this.handler = handler; onQuit = false;
		x = handler.getWidth(); y = handler.getHeight();
		ff = new FontFactory();
		l_flag = false; r_flag = false; z_flag = true;
		answer = true;
		xPos = (x / 2) - 50;
	}

	public void tick() {
		if(onQuit) {
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			
			if(answer) {
				if(timer > 100) {
					xPos++;
					if(xPos == ((x / 2) - 50) + 4) xPos = (x / 2) - 50;
					timer = 0;
				}
			}
			else {
				if(timer > 100) {
					xPos++;
					if(xPos == (((x / 2) - 50) + 4) + 70) xPos = ((x / 2) - 50) + 70;
					timer = 0;
				}
			}
			
			if(!handler.getKeyManager().left) l_flag = false;
			if(!handler.getKeyManager().right) r_flag = false;
			
			if(l_flag || r_flag) return;
			
			if(xPos < ((x / 2) - 50) + 65) { if(handler.getKeyManager().right) { SoundEffect.CursorMove.play(); xPos += 70; r_flag = true; answer = false; }}
			if(xPos > (x / 2) - 45) { if(handler.getKeyManager().left) { SoundEffect.CursorMove.play(); xPos -= 70; l_flag = true; answer = true; }}
			
			if(!handler.getKeyManager().button_Z) z_flag = false;
			if(z_flag) return;
			if(handler.getKeyManager().button_Z) {
				if(!answer) {
					SoundEffect.Cancel.play();
					PausedDialog.menu_flag = false;
					Player.menu = false; onQuit = false;
					xPos = (x / 2) - 50; answer = true;
				}
				else { SoundEffect.Confirm.play(); System.exit(1); }
				z_flag = true;	
			}
		}
	}

	public void render(Graphics g) {		
		if(onQuit) { 
			g.drawImage(Assets.dialogBox[0], ((x / 2) - (32 * 3)) + 16, (y / 2) - (32 * 3), 32, 32, null);
			g.drawImage(Assets.dialogBox[3], ((x / 2) - (32 * 3)) + 16, (y / 2) - (32 * 2), 32, 32, null);
			g.drawImage(Assets.dialogBox[3], ((x / 2) - (32 * 3)) + 16, (y / 2) - 32, 32, 32, null);
			g.drawImage(Assets.dialogBox[6], ((x / 2) - (32 * 3)) + 16, (y / 2), 32, 32, null);
			
			g.drawImage(Assets.dialogBox[1], ((x / 2) - (32 * 2)) + 16, (y / 2) - (32 * 3), 32, 32, null);
			g.drawImage(Assets.dialogBox[1], ((x / 2) - 32) + 16, (y / 2) - (32 * 3), 32, 32, null);
			g.drawImage(Assets.dialogBox[1], (x / 2) + 16, (y / 2) - (32 * 3), 32, 32, null);
			g.drawImage(Assets.dialogBox[1], ((x / 2) + 32) + 16, (y / 2) - (32 * 3), 32, 32, null);	
			
			g.drawImage(Assets.dialogBox[4], ((x / 2) - 32) + 16, (y / 2) - (32 * 2), 32, 32, null);
			g.drawImage(Assets.dialogBox[4], ((x / 2) - (32 * 2)) + 16, (y / 2) - (32 * 2), 32, 32, null);
			g.drawImage(Assets.dialogBox[4], ((x / 2) - (32 * 2)) + 16, (y / 2) - 32, 32, 32, null);
			g.drawImage(Assets.dialogBox[4], ((x / 2) - 32) + 16, (y / 2) - 32, 32, 32, null);
			g.drawImage(Assets.dialogBox[4], (x / 2) + 16, (y / 2) - 32, 32, 32, null);
			g.drawImage(Assets.dialogBox[4], ((x / 2) + 32) + 16, (y / 2) - 32, 32, 32, null);	
			g.drawImage(Assets.dialogBox[4], ((x / 2) + 32) + 16, (y / 2) - (32 * 2), 32, 32, null);
			g.drawImage(Assets.dialogBox[4], (x / 2) + 16, (y / 2) - (32 * 2), 32, 32, null);
			
			g.drawImage(Assets.dialogBox[7], ((x / 2) - 32) + 16, (y / 2), 32, 32, null);
			g.drawImage(Assets.dialogBox[7], (x / 2) + 16, (y / 2), 32, 32, null);
			g.drawImage(Assets.dialogBox[7], ((x / 2) + 32) + 16, (y / 2), 32, 32, null);
			g.drawImage(Assets.dialogBox[7], ((x / 2) - (32 * 2)) + 16, (y / 2), 32, 32, null);
			
			g.drawImage(Assets.dialogBox[2], ((x / 2) + (32 * 2)) + 16, (y / 2) - (32 * 3), 32, 32, null);
			g.drawImage(Assets.dialogBox[5], ((x / 2) + (32 * 2)) + 16, (y / 2) - (32 * 2), 32, 32, null);
			g.drawImage(Assets.dialogBox[5], ((x / 2) + (32 * 2)) + 16, (y / 2) - 32, 32, 32, null);
			g.drawImage(Assets.dialogBox[8], ((x / 2) + (32 * 2)) + 16, (y / 2), 32, 32, null);
			
			g.setFont(ff.menuFont1);
			g.setColor(Color.WHITE);
			drawString(g, "Do you want to quit Doeville?", (x / 2) - 60, (y / 2) - 55, 200);
			
			g.setColor(new Color(24, 196, 65));
			g.drawString("Yes", (x / 2) - 30, (y / 2));
			
			g.drawString("No", (x / 2) + 40, (y / 2));
			
			g.drawImage(Assets.hCursor, xPos, (y / 2) - 15, 16, 16, null);
		}
	}
}
