package com.project.Doeville.dialogs.list;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DialogUtil;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.Item;
import com.project.Doeville.sounds.SoundEffect;

public class VendingMachineDialog extends DialogUtil {
	public static String NPCName;
	public boolean z_delay;
	private Handler handler;
	private HUD hud;
	private ArrayList<Item> options;
	private ArrayList<Integer> prices;
	public int index, cursorPos = 0, cursorYPos = 0, optionYPos;
	private int x, option_index, font_height, first, last, lenghtBar, posBar;
	private boolean u_flag, d_flag, x_flag, z_flag;
	private int def_pos = 50;

	
	public VendingMachineDialog(Handler handler, HUD hud) {
		 this.handler = handler; x = handler.getWidth();
		 this.hud = hud;
		 timer = 0; lastTime = System.currentTimeMillis(); 
		 index = 0; endPrint = false;
		 options = new ArrayList<Item>(); prices = new ArrayList<Integer>();
		 optionYPos = 32 * 2;
		 cursorPos = ((x / 2) - (32 * 5)) - 15;
		 u_flag = false; d_flag = false; x_flag = false; z_flag = false; z_delay = true;
		 option_index = 0; cursorYPos = optionYPos - 14;
		 first = 0; last = 3;
	}
	
	
	public void tick() {
		if(!Player.paused) {
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			
			if(timer > 100) {
				cursorPos++;
				if(cursorPos > (((x / 2) - (32 * 5)) - 15) + 5) cursorPos = ((x / 2) - (32 * 5)) - 15;
				timer = 0;
			}			
			
			if(!handler.getKeyManager().up) u_flag = false;
			if(!handler.getKeyManager().down) d_flag = false;
			if(!handler.getKeyManager().button_X) x_flag = false;
			if(!handler.getKeyManager().button_Z) z_flag = false;
			if(u_flag || d_flag || x_flag || z_flag) return;
			

			if(handler.getKeyManager().button_Z) {
				if(!z_delay) {
					Player.dID = DialogID.message; 
					if(hud.getDoellar() >= prices.get(option_index)) {
						SoundEffect.PickUp.play();
						handler.getWorld().getItemManager().addItemToInventory(options.get(option_index));
						Player.messages = "You picked up a " + options.get(option_index).getItem_name() + ".";
						hud.setDoellar(hud.getDoellar() - prices.get(option_index));
					}
					else Player.messages = "You don't have enough money.";
						
					reset(); Player.resetAll(); z_flag = true; z_delay = true;					
					return;
				}
				z_flag = true; z_delay = false; return;
			}
			
			if(handler.getKeyManager().button_X) {
				SoundEffect.Cancel.play();
				Player.dID = DialogID.empty;
				Player.displayDialog = false; Player.Examining = false;
				Player.messages = "";
				Player.resetAll();
				reset();
				x_flag = true; return;
			}
				
			if(handler.getKeyManager().down) {
				option_index++;
				if(option_index >= options.size()) { option_index = options.size() - 1; d_flag = true; return; }
				if(option_index >= last) {
					 def_pos += 5; last++; first++;
				} else cursorYPos += font_height;	
				
				SoundEffect.CursorMove.play();
				System.out.println(option_index);
				d_flag = true; return;
			}
				
			else if(handler.getKeyManager().up) { 
				option_index--; 
				if(option_index < 0) { option_index = 0; u_flag = true; return; }
				if(option_index < first) {
					 def_pos -= 5; last--; first--;
				} else cursorYPos -= font_height;
				SoundEffect.CursorMove.play();
				System.out.println(option_index);
				u_flag = true; return;
			}
		}
	}
	
	public void reset() {
		optionYPos = 32 * 2; cursorPos = ((x / 2) - (32 * 5)) - 15; 
		cursorYPos = optionYPos - 14;
		option_index = 0; def_pos = 50; lenghtBar = 60; 
		first = 0; last = 3;
		clearOptions();
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		FontMetrics fm = g.getFontMetrics();
		posBar = def_pos; lenghtBar = 60;
		if(options.size() > 3) {
			for(int i = options.size() - 4; i >= 0; i--) {
				lenghtBar -= 5;
				if(lenghtBar < 5) lenghtBar = 5;
			}
		}

		g2d.setComposite(makeTransparent(alpha));
		buildFrame(g, Assets.dialogBox[0], Assets.dialogBox[3], Assets.dialogBox[6], (x / 2) - (32 * 6));
		for(int i = 5; i >= 0; i--) buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) - (32 * i));
		buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) + 32);
		buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) + (32 * 2));
		buildFrame(g, Assets.dialogBox[2], Assets.dialogBox[5], Assets.dialogBox[8], (x / 2) + (32 * 3));		
		g2d.setComposite(makeTransparent(1));
		
		
		drawString(g, "Select an item to buy:", ((x / 2) - (32 * 6)) + 25, 40, 220);
		for(int i_pos = first; i_pos < last; i_pos++) {
			drawString(g, options.get(i_pos).getItem_name(), ((x / 2) - (32 * 5)) + 10, optionYPos, 300);
			drawString(g, prices.get(i_pos).toString(), (x / 2) + (32 * 2), optionYPos, 300);
			font_height = fm.getHeight();
			optionYPos += fm.getHeight();
		}
		optionYPos = 32 * 2;
		drawString(g, "Press 'X' to Cancel.", ((x / 2) - (32 * 5)) + 10, (32 * 4) + 10, 220);
		g.drawImage(Assets.hCursor, cursorPos, cursorYPos, 16, 16, null);
		g.fillRect((x / 2) + (32 * 3), 50, 10, 60);
		g.setColor(new Color(187, 83, 23));
		g.drawRect((x / 2) + (32 * 3), 50, 10, 60);
		g.fillRect((x / 2) + (32 * 3), posBar, 10, lenghtBar);
	}
		
	private void buildFrame(Graphics g, BufferedImage bi1, BufferedImage bi2, BufferedImage bi3, int a) {
		g.drawImage(bi1, a, 5, 32, 32, null); 
		for(int i = 1; i < 4; i++ ) g.drawImage(bi2, a, (32 * i) + 5, 32, 32, null);
		g.drawImage(bi3, a, (32 * 4) + 5, 32, 32, null);
	}
	
	public void addOptions(Item option, int price){
		options.add(option);
		prices.add(price);
	}
	
	public void clearOptions() {
		options.clear();
		prices.clear();
	}
	
	public int getOptionIndex() {
		return option_index;
	}

}
