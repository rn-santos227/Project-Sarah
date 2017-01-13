package com.project.Doeville.hud;

import java.awt.Color;
import java.awt.Graphics;

import com.project.Doeville.Handler;

public abstract class NeedMeter {
	protected Handler handler;
	protected Color color;
	protected int bar_X, bar_Y;
	protected double b_amount, m_amount;
	protected final int ICON_W = 32, ICON_H = 32;
	protected final double F_POSITION = 375, F_HEIGHT = 49;

	public NeedMeter(Handler handler, int bar_X, int bar_Y, Color color) {
		this.handler = handler;
		this.bar_X = bar_X;
		this.bar_Y = bar_Y;
		this.color = color;
		b_amount = F_POSITION; m_amount = F_HEIGHT;		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}


	public void setColor(Color color) {
		this.color = color;
	}
	
	public double getB_amount() {
		return b_amount;
	}

	public double getM_amount() {
		return m_amount;
	}

	public void setB_amount(double b_amount) {
		this.b_amount = b_amount;
	}

	public void setM_amount(double m_amount) {
		this.m_amount = m_amount;
	}

}
