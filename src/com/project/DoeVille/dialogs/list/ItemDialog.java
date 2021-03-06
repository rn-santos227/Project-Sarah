package com.project.Doeville.dialogs.list;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogUtil;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;

public class ItemDialog extends DialogUtil {
	public String content;
	public boolean z_delay;
	public int index, cursorPos = 0;
	private int x;
	private boolean z_flag;
	protected Handler handler;
	
	public ItemDialog(Handler handler) {
		this.handler = handler;
		timer = 0; lastTime = System.currentTimeMillis();
		content = ""; index = 0; endPrint = false;
		x = handler.getWidth(); z_flag = false; z_delay = true;
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
			
		g.drawImage(Assets.dialogBox[0], (x / 2) - (32 * 3), 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[3], (x / 2) - (32 * 3), 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[6], (x / 2) - (32 * 3), (32 * 2) + 5, 32, 32, null);
			
		g.drawImage(Assets.dialogBox[1], (x / 2) - (32 * 2), 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[4], (x / 2) - (32 * 2), 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[7], (x / 2) - (32 * 2), (32 * 2) + 5, 32, 32, null);	
			
		g.drawImage(Assets.dialogBox[1], (x / 2) - 32, 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[4], (x / 2) - 32, 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[7], (x / 2) - 32, (32 * 2) + 5, 32, 32, null);	
			
		g.drawImage(Assets.dialogBox[1], (x / 2), 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[4], (x / 2), 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[7], (x / 2), (32 * 2) + 5, 32, 32, null);
			
		g.drawImage(Assets.dialogBox[1], (x / 2) + 32, 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[4], (x / 2) + 32, 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[7], (x / 2) + 32, (32 * 2) + 5, 32, 32, null);
			
		g.drawImage(Assets.dialogBox[1], (x / 2) + (32 * 2), 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[4], (x / 2) + (32 * 2), 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[7], (x / 2) + (32 * 2), (32 * 2) + 5, 32, 32, null);	
		
		g.drawImage(Assets.dialogBox[2], (x / 2) + (32 * 3), 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[5], (x / 2) + (32 * 3), 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[8], (x / 2) + (32 * 3), (32 * 2) + 5, 32, 32, null);
			
		g2d.setComposite(makeTransparent(1));
		g.setFont(handler.getFF().customFont);
		g.setColor(Color.WHITE);
		
		drawStringLocal(g, content, ((640 / 2) - (32 * 3)) + 20, 35, 180);
		if(endPrint) { g.drawImage(Assets.vCursor, (640 / 2) + (32 * 3), cursorPos ,16, 16, null); }
	}
	
	public void drawStringLocal(Graphics g, String s, int x, int y, int width) {

		FontMetrics fm = g.getFontMetrics();
		int lineHeight = fm.getHeight() - 9;
		int curX = x;
		int curY = y;
		String[] words = s.split(" ");
		for (String word : words) {
			int wordWidth = fm.stringWidth(word + " ");
			if (curX + wordWidth >= x + width) {
				curY += lineHeight;
				curX = x;
			}
			if(Player.itemName.contains(word) && word.length() > 1) { g.setColor(new Color(255, 26, 255)); g.setFont(handler.getFF().customFont1);}
			else { g.setColor(Color.WHITE); g.setFont(handler.getFF().customFont); }
			g.drawString(word, curX, curY);		
			curX += wordWidth;
		}
		if(endPrint) { g.setColor(Color.WHITE); g.drawString(".", curX - 8, curY);}
	}
}
