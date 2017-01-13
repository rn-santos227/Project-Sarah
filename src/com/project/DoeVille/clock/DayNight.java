package com.project.Doeville.clock;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;

public class DayNight {
	public static float alpha;
	public static boolean indoors = false;
	
	private Handler handler;
	
	public DayNight(Handler handler) {
		this.handler = handler;
		alpha = 0.0f;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));

		Area a1 = new Area(new Rectangle2D.Double(0, 0, handler.getWidth(), handler.getHeight()));
		if(GameClock.isDark) {
			for(Entity e : handler.getWorld().getEntityManager().entities){
				if(e.getID() == EntityID.StreetLamp) {
			        Area a2 = new Area(new Ellipse2D.Float((int)((e.getX() - 57) - handler.getGameCamera().getxOffset()), (int)((e.getY() + 3) - handler.getGameCamera().getyOffset()), 150, 150));
			        a1.subtract(a2);
				}
			}
		}
		
		g2d.setColor(new Color(54, 12, 98));
		g2d.fill(a1);
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
}
