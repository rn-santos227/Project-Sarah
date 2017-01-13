package com.project.Doeville.dialogs.list;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogUtil;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;

public class NPCDialog extends DialogUtil {
	public static String NPCName;
	public String content;
	public boolean z_delay;
	public int index, cursorPos = 0;
	private int x;
	private boolean z_flag;
	protected Handler handler;
	
	public NPCDialog(Handler handler) {
		this.handler = handler;
		NPCName = "";
		timer = 0; lastTime = System.currentTimeMillis();
		content = ""; index = 0; endPrint = false;
		x = handler.getWidth(); z_flag = false; z_delay = true;
	}
	
	public void tick() {
		if(!Player.paused) {
			if(!endPrint) cursorPos = (32 * 3);
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
				if(cursorPos > (32 * 3)  + 4) cursorPos = (32 * 3);
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
		
		buildFrame(g, Assets.dialogBox[0], Assets.dialogBox[3], Assets.dialogBox[6], (x / 2) - (32 * 7));
		for(int i = 6; i >= 0; i--) buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) - (32 * i));
		buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) + 32);
		buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) + (32 * 2));
		buildFrame(g, Assets.dialogBox[2], Assets.dialogBox[5], Assets.dialogBox[8], (x / 2) + (32 * 3));
		
		g2d.setComposite(makeTransparent(1));
		g.setFont(handler.getFF().customFont);
		g.setColor(new Color(24, 196, 65));
		g.drawString(NPCName + ":", ((640 / 2) - (32 * 7)) + 20, 35);
		g.setColor(Color.WHITE);
		drawString(g, content, ((640 / 2) - (32 * 7)) + 25, 55, 315);
		if(endPrint) {
			g.drawImage(Assets.vCursor, (640 / 2) + (32 * 3), cursorPos ,16, 16, null);
		}
	}
	
	private void buildFrame(Graphics g, BufferedImage bi1, BufferedImage bi2, BufferedImage bi3, int a) {
		g.drawImage(bi1, a, 5, 32, 32, null);
		for(int i = 1; i < 3; i++ ) g.drawImage(bi2, a, (32 * i) + 5, 32, 32, null);
		g.drawImage(bi3, a, (32 * 3) + 5, 32, 32, null);
	}
}
