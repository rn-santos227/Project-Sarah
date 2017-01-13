package com.project.Doeville.gfx;

import java.awt.image.BufferedImage;

public class Buttons {
	public static BufferedImage[] NewGame, LoadGame, Setting, Quit;
	public static void init() {
		SpriteSheet buttons = new SpriteSheet(ImageLoader.loadImage("/textures/Buttons.png"));
		
		NewGame = new BufferedImage[2];
		LoadGame = new BufferedImage[2];
		Setting = new BufferedImage[2];
		Quit = new BufferedImage[2];
		
		NewGame[0] = buttons.crop(0, 0, 32 * 4, 32);
		LoadGame[0] = buttons.crop(0, 32, 32 * 4, 32);
		Setting[0] = buttons.crop(0, 32 * 2, 32 * 4, 32);
		Quit[0] = buttons.crop(0, 32 * 3, 32 * 4, 32);
		
		NewGame[1] = buttons.crop(32 * 4, 0, 32 * 4, 32);
		LoadGame[1] = buttons.crop(32 * 4, 32, 32 * 4, 32);
		Setting[1] = buttons.crop(32 * 4, 32 * 2, 32 * 4, 32);
		Quit[1] = buttons.crop(32 * 4, 32 * 3, 32 * 4, 32);
	}
}
