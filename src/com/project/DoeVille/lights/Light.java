package com.project.Doeville.lights;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;

import com.project.Doeville.Handler;
import com.project.Doeville.clock.GameClock;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;

public class Light {
	private Handler handler;
	
	public Light(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(GameClock.isDark) {
			g2d.setComposite(makeTransparent(0.1f));
			for(Entity e : handler.getWorld().getEntityManager().entities){
				if(e.getID() == EntityID.StreetLamp) {
			        g2d.setPaint(new RadialGradientPaint(
			        ((e.getX() + 16) - handler.getGameCamera().getxOffset()) - 0.5f, 
			        ((e.getY() + 34) - handler.getGameCamera().getyOffset()) -0.5f, 250,
			           new float[] {0.1f,0.25f},
			           new Color[] {new Color(255, 255, 0), new Color(255, 255, 255, 0)}
			        ));
			        g2d.fill(new Ellipse2D.Float((int)((e.getX() - 54) - handler.getGameCamera().getxOffset()), (int)((e.getY() + 3) - handler.getGameCamera().getyOffset()), 140, 140));
				}
			}
		}
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
}
