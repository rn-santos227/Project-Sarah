package com.project.Doeville.hud;

import java.awt.Color;
import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;

public class StaminaMeter extends NeedMeter {
	protected Player player;

	public StaminaMeter(Handler handler, int bar_X, int bar_Y, Color color) {
		super(handler, bar_X, bar_Y, color);
	}

	public void tick() {
		if(this.m_amount <= 0) Player.isTired = true;
		else if((int)m_amount == F_HEIGHT - 1) Player.isTired = false;

		if(Player.running) { this.b_amount += 0.50; this.m_amount -= 0.50; }
		else if((Player.isHungry && Player.moving && !Player.isTired)) { this.b_amount += 0.20; this.m_amount -= 0.20; }
		else { if(this.b_amount != F_POSITION && (int)this.m_amount != F_HEIGHT - 1) { this.b_amount -= 0.30; this.m_amount += 0.30; } }
		
		if(this.b_amount != F_POSITION && (int)this.m_amount != F_HEIGHT - 1) { this.b_amount -= 0.10; this.m_amount += 0.10; } 
		handler.clamp((int)this.m_amount, (int)this.b_amount, (int)this.m_amount);
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
		g.drawImage(Assets.StaminaIcon, bar_X, bar_Y, ICON_W, ICON_H, null);
	}

}
