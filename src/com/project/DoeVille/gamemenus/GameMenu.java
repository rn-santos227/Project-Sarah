package com.project.Doeville.gamemenus;

import java.awt.FontMetrics;
import java.awt.Graphics;

import com.project.Doeville.utils.FontFactory;

public abstract class GameMenu {
	protected FontFactory ff;
	protected long lastTime, timer;
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
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
}
