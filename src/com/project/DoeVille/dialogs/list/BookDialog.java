package com.project.Doeville.dialogs.list;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogUtil;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;

public class BookDialog extends DialogUtil {
	public String content;
	public String bookTitle;
	public boolean z_delay;
	public int index, cursorPos = 0;
	private boolean z_flag;
	protected Handler handler;
	
	public BookDialog(Handler handler) {
		this.handler = handler;
		timer = 0; lastTime = System.currentTimeMillis();
		content = ""; index = 0; endPrint = false;
		z_flag = false; z_delay = true;
	}
	
	public void tick() {
		if(!Player.paused) {
			if(!endPrint) cursorPos = (32 * 2) + 8;
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			if(content.length() < Player.messages.length()) {
			if(timer > 50) {
					content = content + Player.messages.charAt(index);
					index++; timer = 0;
				}
			} 
			if(Player.messages.equals(content)) { 
				endPrint = true;
			}
			else endPrint = false;
			if(endPrint) {
				if(timer > 100) {
					cursorPos++;
				if(cursorPos > ((32 * 2) + 8) + 4) cursorPos = (32 * 2) + 8;
					timer = 0;
				}
			}
			
			if(!handler.getKeyManager().button_Z) z_flag = false;
			if(z_flag) return;
			
			if(!endPrint) {
				if(handler.getKeyManager().button_Z) {
					if(!z_delay) { content = Player.messages; index = content.length(); }
					z_delay = false; z_flag = true; return;
				} 
			}
		}
	}
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));

		g.drawImage(Assets.dialogBox[0], 20, (32 * 2) + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[2], (32 * 13) + 20, (32 * 2) + 5, 32, 32, null);
		for(int i = 3; i < 9; i++) {
			g.drawImage(Assets.dialogBox[3], 20, (32 * i) + 5, 32, 32, null);
			g.drawImage(Assets.dialogBox[5], (32 * 13) + 20, (32 * i) + 5, 32, 32, null);
		}
		for(int i = 1; i < 13; i++){
			g.drawImage(Assets.dialogBox[1],(32 * i) + 20, (32 * 2) + 5, 32, 32, null);
			g.drawImage(Assets.dialogBox[7],(32 * i) + 20, (32 * 9) + 5, 32, 32, null);
			for(int j = 3; j < 9; j++) { g.drawImage(Assets.dialogBox[4],(32 * i) + 20, (32 * j) + 5, 32, 32, null); }
		}			
		g.drawImage(Assets.dialogBox[6], 20, (32 * 9) + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[8], (32 * 13) + 20, (32 * 9) + 5 , 32, 32, null);
		
		g2d.setComposite(makeTransparent(1));
		g.setColor(Color.WHITE);
		g.setFont(handler.getFF().menuFont1);
		g.drawString(bookTitle, 50, (32 * 2) + 40);
		g.setFont(handler.getFF().itemFont4);
		
	
		drawString(g, content, 50, (32 * 3) + 35, 410);
		
		if(endPrint) {
			
		}
	}
}
