package com.project.Doeville.dialogs.list;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogUtil;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.sounds.SoundEffect;

public class QuestionDialog extends DialogUtil {
	public static String NPCName;
	public boolean z_delay, NPCQuestionBox, ObjectQuestionBox;
	public String content;
	private Handler handler;
	private ArrayList<String> options;
	public int index, cursorPos = 0, cursorYPos = 0, optionYPos;
	private int x, option_index, font_height;
	private boolean u_flag, d_flag, z_flag;

	
	public QuestionDialog(Handler handler) {
		 this.handler = handler; x = handler.getWidth();
		 timer = 0; lastTime = System.currentTimeMillis();
		 content = ""; index = 0; endPrint = false;
		 options = new ArrayList<String>(); optionYPos = 32 * 3;
		 cursorPos = ((x / 2) - (32 * 6)) - 15;
		 u_flag = false; d_flag = false; z_flag = false; z_delay = true;
		 option_index = 0; cursorYPos  = optionYPos - 14; NPCQuestionBox = false; ObjectQuestionBox = false;
	}
	
	
	public void tick() {
		if(!Player.paused) {
			if(!endPrint) {
				if(NPCQuestionBox) cursorPos = ((x / 2) - (32 * 6)) - 15;
				else if(ObjectQuestionBox) cursorPos = ((x / 2) - (32 * 3)) - 15;
			}
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			if(content.length() < Player.messages.length()) {
			if(timer > 50) {
					content = content + Player.messages.charAt(index);
					index++; timer = 0; 
				}
			} 
			if(Player.messages.equals(content)) { endPrint = true; }
			else endPrint = false;
			
			if(!handler.getKeyManager().up) u_flag = false;
			if(!handler.getKeyManager().down) d_flag = false;
			if(!handler.getKeyManager().button_Z) z_flag = false;
			if(u_flag || d_flag || z_flag) return;
			
			if(!endPrint) {
				if(handler.getKeyManager().button_Z) {
					if(!z_delay) { content = Player.messages; index = content.length(); }
					z_delay = false; z_flag = true; return;
				} 
			}
			
			else {
				if(NPCQuestionBox) {
					if(timer > 100) {
						cursorPos++;
						if(cursorPos > (((x / 2) - (32 * 6)) - 15) + 4) cursorPos = ((x / 2) - (32 * 6)) - 15;
						timer = 0;
					}
				}
				
				else if(ObjectQuestionBox) {
					if(timer > 100) {
						cursorPos++;
					if(cursorPos > (((x / 2) - (32 * 3)) - 15) + 4) cursorPos = ((x / 2) - (32 * 3)) - 15;
						timer = 0;
					}
				}
				
				if(handler.getKeyManager().button_Z) {
					System.out.println("Z is pressed!");
					Player.mID++; 
					Player.oID = option_index;
					Player.Examining = false; endPrint = false;
					option_index = 0; cursorYPos  = optionYPos - 14;
					NPCQuestionBox = false; ObjectQuestionBox = false;
					z_flag = true; return;
				}
				
				if(handler.getKeyManager().down) {
					option_index++;
					if(option_index >= options.size()) { option_index = options.size() - 1; d_flag = true; return; }
					SoundEffect.CursorMove.play();
					System.out.println(option_index);
					cursorYPos += font_height;
					d_flag = true; return;
				}
				
				else if(handler.getKeyManager().up) { 
					option_index--;
					if(option_index < 0) { option_index = 0; u_flag = true; return; }
					SoundEffect.CursorMove.play();
					System.out.println(option_index);
					cursorYPos -= font_height;
					u_flag = true; return;
				}
			}
		}
	}


	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		FontMetrics fm = g.getFontMetrics();
		if(NPCQuestionBox) {
			
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
				for(String s : options) {
					drawString(g, s, ((x / 2) - (32 * 6)) + 10, optionYPos, 300);
					font_height = fm.getHeight();
					optionYPos += fm.getHeight();
				}
				optionYPos = 32 * 3;
				g.drawImage(Assets.hCursor, cursorPos, cursorYPos, 16, 16, null);
			}
		}
		
		else if(ObjectQuestionBox) {
			
			g2d.setComposite(makeTransparent(alpha));
			buildFrame(g, Assets.dialogBox[0], Assets.dialogBox[3], Assets.dialogBox[6], (x / 2) - (32 * 4));
			for(int i = 3; i >= 0; i--) buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) - (32 * i));
			buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) + 32);
			buildFrame(g, Assets.dialogBox[1], Assets.dialogBox[4], Assets.dialogBox[7], (x / 2) + (32 * 2));
			buildFrame(g, Assets.dialogBox[2], Assets.dialogBox[5], Assets.dialogBox[8], (x / 2) + (32 * 3));
			g2d.setComposite(makeTransparent(1));
			
			g.setFont(handler.getFF().customFont);
			g.setColor(Color.WHITE);
			drawString(g, content, ((x / 2) - (32 * 4)) + 25, 40, 220);
			
			if(endPrint) {
				for(String s : options) {
					drawString(g, s, ((x / 2) - (32 * 3)) + 10, optionYPos, 300);
					font_height = fm.getHeight();
					optionYPos += fm.getHeight();
				}
				optionYPos = 32 * 3;
				g.drawImage(Assets.hCursor, cursorPos, cursorYPos, 16, 16, null);
			}
		}
	}
	
	private void buildFrame(Graphics g, BufferedImage bi1, BufferedImage bi2, BufferedImage bi3, int a) {
		g.drawImage(bi1, a, 5, 32, 32, null);
		for(int i = 1; i < 4; i++ ) g.drawImage(bi2, a, (32 * i) + 5, 32, 32, null);
		g.drawImage(bi3, a, (32 * 4) + 5, 32, 32, null);
	}
	
	public void addAllOptions(ArrayList<String> list){
		options.addAll(list);
	}
	
	public void clearOptions() {
		options.clear();
	}

}
