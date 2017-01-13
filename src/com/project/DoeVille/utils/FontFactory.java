package com.project.Doeville.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FontFactory {
	public Font customFont, customFont1, customFont2, hudFont, clockFont, calendarFont, hudFont1, menuFont, menuFont1,
	itemFont, itemFont1, itemFont2, itemFont3, itemFont4, itemFont5, interiorFont, bookFont;
	public FontFactory() {
		    try {
		    	clockFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(50f);
		    	calendarFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(24f);
		    	customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(25f);
		    	customFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(Font.ITALIC, 25f);
		    	customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(31f);
		    	hudFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(24f);
		    	hudFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(15f);
		    	menuFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(50f);
		    	menuFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(30f);
		    	itemFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(38f);
		    	itemFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(36f);
		    	itemFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(34f);
		    	itemFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(28f);
		    	itemFont4 = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(23f);
		    	itemFont5 = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(Font.BOLD, 23f);
		    	interiorFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(45f);
		    	bookFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")).deriveFont(20f);
		    	
		    	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/SGK001.ttf")));
			} catch (FontFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
