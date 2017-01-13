package com.project.Doeville.hud;

import java.awt.Color;
import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;

public class HungerMeter extends NeedMeter {
	public double amount;
	public boolean isEating;
	public int eatingTime, finishEatingTime;
	public HungerMeter(Handler handler, int bar_X, int bar_Y, Color color) {
		super(handler, bar_X, bar_Y, color);
		amount = 0.00; isEating = false; eatingTime = 0;
	}

	public void tick() {
		
		if(!isEating) {	
			Player.eating = false;
			if(!Player.isTired) {
				if(Player.running) this.amount = 0.0015;
				else this.amount = 0.0005;
			} else this.amount = 0.0016;
			
			this.b_amount += this.amount;
			this.m_amount -= this.amount;	
			eatingTime = 0;
		}
		
		else {
			Player.eating = true;	
			if(this.b_amount != F_POSITION && (int)this.m_amount != F_HEIGHT - 1) { this.b_amount -= amount; this.m_amount += amount; } 
			else isEating = false;
			eatingTime++;
			if(eatingTime >= finishEatingTime) isEating = false;			
		}
		
		handler.clamp((int)m_amount, (int)b_amount, (int)m_amount);
		Player.isHungry = this.m_amount <= (F_HEIGHT * 0.15) ? true : false;
		if(this.m_amount <= 0) { this.m_amount = 0; this.b_amount = F_POSITION + F_HEIGHT; }
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect((bar_X - 1), (int)(F_POSITION - 1), (ICON_W + 1), (int)(F_HEIGHT + 1));
		g.setColor(Color.GRAY);
		g.fillRect(bar_X, (int)F_POSITION, ICON_W, (int)F_HEIGHT);
		g.setColor(color);
		g.fillRect(bar_X, (int)b_amount, ICON_W, (int)m_amount);
		g.setColor(Color.BLACK);
		g.drawRect((bar_X - 1), (bar_Y - 1), (ICON_W + 1), (ICON_H + 1));
		g.drawImage(Assets.HungerIcon, bar_X, bar_Y, ICON_W, ICON_H, null);
	}

}
