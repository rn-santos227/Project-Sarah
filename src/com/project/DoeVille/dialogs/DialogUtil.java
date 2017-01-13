package com.project.Doeville.dialogs;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;


public abstract class DialogUtil {
	protected final float alpha = 0.75f;
	protected long lastTime, timer;
	protected boolean endPrint;
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
	
	public void drawString(Graphics g, String s, int x, int y, int width) {
		FontMetrics fm = g.getFontMetrics();
		int lineHeight = fm.getHeight() - 9;
		int curX = x;
		int curY = y;
		String[] words = s.split(" ");
		for (String word : words) {
			int wordWidth = fm.stringWidth(word + " ");
			if (curX + wordWidth >= x + width) {
				curY += lineHeight;
				curX = x;
			}

			g.drawString(word, curX, curY);		
			curX += wordWidth;
		}
	}
	
	public void centerString(Graphics g, Rectangle r, String s, Font font) {
	    FontRenderContext frc =  new FontRenderContext(null, true, true);
	
	    Rectangle2D r2D = font.getStringBounds(s, frc);
	    int rWidth = (int) Math.round(r2D.getWidth());
	    int rHeight = (int) Math.round(r2D.getHeight());
	    int rX = (int) Math.round(r2D.getX());
	    int rY = (int) Math.round(r2D.getY());
	
	    int a = (r.width / 2) - (rWidth / 2) - rX;
	    int b = (r.height / 2) - (rHeight / 2) - rY;
	
	    g.setFont(font);
	    g.drawString(s, r.x + a, r.y + b);
	}
	
	public boolean isEndPrint() {
		return endPrint;
	}
	public void setEndPrint(boolean endPrint) {
		this.endPrint = endPrint;
	}
	public long getTimer() {
		return timer;
	}
	public void setTimer(long timer) {
		this.timer = timer;
	}
}
