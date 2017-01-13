package com.project.Doeville.dialogs.list;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DialogUtil;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;

public class AlertDialog extends DialogUtil {
	private int boxSpeed = 2000;
	Handler handler;
	public AlertDialog(Handler handler) {
		this.handler = handler;
		timer = 0; lastTime = System.currentTimeMillis();
	}
	
	public void tick() { 
		if(!Player.paused) {
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			if(timer > boxSpeed) {
				Player.displayDialog = false;
				Player.messages = "";
				Player.dID = DialogID.empty;
				timer = 0;
			}
		}
	}
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.drawImage(Assets.dialogBox[0], 20, 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[6], 20, 32 + 5, 32, 32, null);
		
		for(int i = 1; i < 6; i++){
			g.drawImage(Assets.dialogBox[1],(32 * i) + 20, 5, 32, 32, null);
			g.drawImage(Assets.dialogBox[7],(32 * i) + 20, 32 + 5, 32, 32, null);
		}		
		g.drawImage(Assets.dialogBox[2], (32 * 6) + 20, 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[8], (32 * 6) + 20, 32 + 5, 32, 32, null);
		
		g2d.setComposite(makeTransparent(1));
		g.setFont(handler.getFF().customFont);
		g.setColor(Color.WHITE);
		drawString(g, Player.messages, 55, 40, 250);
	}
}
