package com.project.Doeville.gfx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.project.Doeville.Handler;

public class Transition {
	private Handler handler;
	private boolean transitioning; 
	private boolean appear;
	private boolean fade;
	private float alpha = 0.0f;
	
	public Transition(Handler handler) {
		this.handler = handler;
		transitioning = false; appear = false; fade = false;
	}
	
	public void tick() {
		if(transitioning) {			
			if(!fade) {
				alpha += 0.08f;
				if(alpha >= 1.0f) {
					fade = true; appear = true;
					alpha = 1.0f;
				}
			}
			else { 
				alpha -= 0.08f;
				if(alpha <= 0.1f) {
					alpha = 0.0f;
					fade = false; transitioning = false;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g2d.setComposite(makeTransparent(1));
		
		if(alpha >= 0.9f) {
			g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		}
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	public boolean isTransitioning() {
		return transitioning;
	}

	public void setTransitioning(boolean transitioning) {
		this.transitioning = transitioning;
	}

	public boolean isAppear() {
		return appear;
	}

	public void setAppear(boolean appear) {
		this.appear = appear;
	}
}
