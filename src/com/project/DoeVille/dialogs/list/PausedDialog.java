package com.project.Doeville.dialogs.list;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.project.Doeville.Handler;
import com.project.Doeville.Inventory.Inventory;
import com.project.Doeville.dialogs.DialogUtil;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gamemenus.QuitGame;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.profile.Profile;
import com.project.Doeville.sounds.SoundEffect;

public class PausedDialog extends DialogUtil{
	public static boolean menu_flag, tran_flag, interior_flag = false;
	public static int index;
	private Handler handler;
	private float alpha;
	private int x = 31, y = 70;
	private boolean d_flag, u_flag, z_flag, esc_flag;
	
	private Transition tran;
	private Inventory inventory;
	private Profile profile;
	private QuitGame quit;
	
	public PausedDialog(Handler handler, HUD hud, Transition tran) {
		this.handler = handler; this.tran = tran;
		alpha = 0.50f;
		d_flag = false; u_flag = false; z_flag = false; tran_flag = false; esc_flag = false;
		menu_flag = false;
		
		quit = new QuitGame(handler);

		profile = new Profile(handler, hud);
		inventory = new Inventory(handler, hud);
	}
	
	public void tick() {
		if(Player.paused) {
			if(!menu_flag) {
				timer += System.currentTimeMillis() - lastTime;
				lastTime = System.currentTimeMillis();
				if(timer > 100) {
					x++;
					if(x > 35) x = 31;
					timer = 0;
				}
				if(!handler.getKeyManager().up) u_flag = false;
				if(!handler.getKeyManager().down) d_flag = false;
				if(!handler.getKeyManager().button_Z) z_flag = false;
				if(!handler.getKeyManager().button_ESC) esc_flag = false;
				if(d_flag || u_flag || z_flag || esc_flag) return;
				
				if(y < 265) { if(handler.getKeyManager().down) { SoundEffect.CursorMove.play(); index++; y += 30; d_flag = true; return; }}		
				if(y > 70) { if(handler.getKeyManager().up) { SoundEffect.CursorMove.play(); index--; y -= 30; u_flag = true; return; }}
				if(handler.getKeyManager().button_ESC) { 
					y = 70; index = 0; tran_flag = false; 
					Inventory.onInventory = false;
					interior_flag = false;
					esc_flag = true; 
					return;
				}
				
				if(handler.getKeyManager().button_Z) { SoundEffect.Confirm.play(); Player.menu = true; menu_flag = true; z_flag = true; return; }
			}
			else {
				switch(index) {
				case 0:
					if(!Profile.onProfile) { 
						if(!tran_flag) { tran.setAppear(false); tran.setTransitioning(true); }
						tran_flag = true;
					}

					if(tran.isAppear() && !Profile.onProfile) { Profile.onProfile = true; tran_flag = false; } 
					if(Profile.onProfile) inventory.tick(); 
					break;
				case 3:
					if(!Inventory.onInventory) { 
						if(!tran_flag) { tran.setAppear(false); tran.setTransitioning(true); }
						tran_flag = true;
					}

					if(tran.isAppear() && !Inventory.onInventory) { Inventory.onInventory = true; tran_flag = false; } 
					if(Inventory.onInventory) inventory.tick(); 
					break;
				case 7:
					quit.tick(); QuitGame.onQuit = true; break;
				default:
					menu_flag = false;
				}
			}
		}
	}
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g2d.setComposite(makeTransparent(1));
		
		if(!menu_flag) {
			g.drawImage(Assets.dialogBox[0], 20, 5, 32, 32, null);
			g.drawImage(Assets.dialogBox[2], (32 * 5) + 20, 5, 32, 32, null);
			for(int i = 1; i < 9; i++) {
				g.drawImage(Assets.dialogBox[3], 20, (32 * i) + 5, 32, 32, null);
				g.drawImage(Assets.dialogBox[5], (32 * 5) + 20, (32 * i) + 5, 32, 32, null);
			}
			for(int i = 1; i < 5; i++){
				g.drawImage(Assets.dialogBox[1],(32 * i) + 20, 5, 32, 32, null);
				g.drawImage(Assets.dialogBox[7],(32 * i) + 20, (32 * 9) + 5, 32, 32, null);
				for(int j = 1; j < 9; j++) { g.drawImage(Assets.dialogBox[4],(32 * i) + 20, (32 * j) + 5, 32, 32, null); }
			}			
			g.drawImage(Assets.dialogBox[6], 20, (32 * 9) + 5, 32, 32, null);
			g.drawImage(Assets.dialogBox[8], (32 * 5) + 20, (32 * 9) + 5 , 32, 32, null);
			
			g2d.setComposite(makeTransparent(1));
			g.setFont(handler.getFF().menuFont);
			
			g.setColor(new Color(24, 196, 65));		
			g.drawString("Menu", 80, 50);
			
			g.setFont(handler.getFF().menuFont1);
			g.setColor(Color.WHITE);
			g.drawString("Character", 55, 85);
			g.drawString("Career", 55, 115);
			g.drawString("Skill List", 55, 145);
			g.drawString("Inventory", 55, 175);
			g.drawString("Journal", 55, 205);
			g.drawString("Setting", 55, 235);
			g.drawString("Load Game", 55, 265);
			g.drawString("Quit Game", 55, 295);
			
			g.drawImage(Assets.hCursor, x, y, 16, 16, null);
		}
		else {
			switch(index) {
			case 0: profile.render(g); break;
			case 3: inventory.render(g); break;
			case 7: quit.render(g); break;
			default: return;
			}
		}
	}
}
