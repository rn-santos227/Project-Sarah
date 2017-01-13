package com.project.Doeville.gfx;

import java.awt.image.BufferedImage;

public class ItemAssets {
	private static final int WIDTH = 32, HEIGHT = 32;
	
	public static BufferedImage Sandwich_A, EnergyDrink_A, Milk_A, Flower_A, Hotdog, PotatoChips, kopikoUno;
	public static BufferedImage HealthTablet, HealthCapsule, HandSanitizer;
	public static BufferedImage ATMCard, IDCard; 
	public static BufferedImage[] SodaCans, BottledDrinks, Snacks;
	
	public static void init() {
		SpriteSheet items = new SpriteSheet(ImageLoader.loadImage("/textures/Items.png"));
		SodaCans = new BufferedImage[5];
		BottledDrinks = new BufferedImage[3];
		Snacks = new BufferedImage[7];
		
		Sandwich_A = items.crop(0, 0, WIDTH, HEIGHT);
		EnergyDrink_A = items.crop(32, 0, WIDTH, HEIGHT);
		Milk_A = items.crop(32 * 2, 0, WIDTH, HEIGHT);
		Flower_A = items.crop(0, 32, WIDTH, HEIGHT);
		Hotdog = items.crop(32 * 3, 0, WIDTH, HEIGHT);
		PotatoChips = items.crop(32 * 4, 0, WIDTH, HEIGHT);
		kopikoUno = items.crop(32 * 5, 0, WIDTH, HEIGHT);
		ATMCard = items.crop(0, 32 * 2, WIDTH, HEIGHT);
		IDCard = items.crop(32, 32 * 2, WIDTH, HEIGHT);
		HealthTablet = items.crop(0, 32 * 3, WIDTH, HEIGHT);
		HealthCapsule = items.crop(32, 32 * 3, WIDTH, HEIGHT);
		HandSanitizer = items.crop(32 * 2, 32 * 3, WIDTH, HEIGHT);
		
		int index = 0; for(int i = 6; i < 11; i++) { SodaCans[index] = items.crop(32 * i, 0, WIDTH, HEIGHT); index++; }
		index = 0; for(int i = 11; i < 14; i++) { BottledDrinks[index] = items.crop(32 * i, 0, WIDTH, HEIGHT); index++; }
		index = 0; for(int i = 2; i < 9; i++) { Snacks[index] = items.crop(32 * i, 32, WIDTH, HEIGHT); index++;  }
	}
}
