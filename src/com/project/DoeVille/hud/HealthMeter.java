package com.project.Doeville.hud;

import java.awt.Color;
import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;

public class HealthMeter extends NeedMeter {
	private EnergyMeter eng;
	public double amount, stacked;
	public boolean isHealing;
	public int healingTime, finishHealing;
	
	public HealthMeter(Handler handler, EnergyMeter eng, int bar_X, int bar_Y, Color color) {
		super(handler, bar_X, bar_Y, color);
		amount = 0.00; this.eng = eng;
	}

	public void tick() {	
		if(!isHealing) {	
			if(!Player.isStinky || !Player.isHungry || eng.m_amount <= (this.F_HEIGHT * 0.25)) amount = 0.00;
			else {
				if(Player.isStinky && amount < 0.001) amount += 0.001;
				else if (!Player.isStinky && amount >= 0.001) amount -= 0.001;
				
				if(Player.isHungry && amount < 0.005) amount += 0.005;
				else if (!Player.isHungry && amount >= 0.005) amount -= 0.005;
				
				if(eng.m_amount <= (48 * 0.25) && amount < 0.008) amount += 0.008;
				else if(eng.m_amount >= (48 * 0.25) && amount >= 0.008) amount -= 0.008;
			}
			
			this.b_amount += this.amount;
			this.m_amount -= this.amount;	
			healingTime = 0;
		}
		
		else {
			if(Player.moving) amount = 0.001;
			else if(Player.running) amount = 0;
			else amount = stacked;
			
			if(this.b_amount != F_POSITION && (int)this.m_amount != F_HEIGHT - 1) { this.b_amount -= amount; this.m_amount += amount; } 
			else isHealing = false;
			healingTime++;
			if(healingTime >= finishHealing) isHealing = false;			
		}
		
		handler.clamp((int)m_amount, (int)b_amount, (int)m_amount);
		Player.isSick = this.m_amount <= (F_HEIGHT * 0.25) ? true : false;
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
		g.drawImage(Assets.HealthIcon, bar_X, bar_Y, ICON_W, ICON_H, null);
	}
	

}
