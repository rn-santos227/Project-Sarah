package com.project.Doeville.hud;

import java.awt.Color;
import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.clock.GameClock;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;

public class EnergyMeter extends NeedMeter {
	private GameClock clock;
	private double amount;
	public EnergyMeter(Handler handler, GameClock clock, int bar_X, int bar_Y, Color color) {
		super(handler, bar_X, bar_Y, color);
		this.clock = clock;
		amount = 0.00;
	}

	public void tick() {
		if(Player.asleep) {
			this.b_amount -= 0.02; this.m_amount += 0.02;
			if(this.m_amount >= (F_HEIGHT * 0.2)) {
				int minutes = clock.getMinutes();
				if(minutes >= 30) { clock.setMinutes(minutes - 30); clock.setHours(clock.getHours() + 1); }
				else clock.setMinutes(minutes + 30);
				Player.asleep = false;
			}
		}
		else {
			if(Player.moving) this.amount = 0.0008;
			else amount = 0.00095;
			if(Player.isHungry) this.amount = 0.0015;
			this.b_amount += amount;
			this.m_amount -= amount;
		}

		handler.clamp((int)this.m_amount, (int)this.b_amount, (int)this.m_amount);
		Player.isSleepy = this.m_amount <= (F_HEIGHT * 0.15) ? true : false;
		if(this.m_amount <= 0) { this.m_amount = 0; this.b_amount = F_POSITION + F_HEIGHT; Player.asleep = true; }
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
		g.drawImage(Assets.EnergyIcon, bar_X, bar_Y, ICON_W, ICON_H, null);
	}

}
