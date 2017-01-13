package com.project.Doeville.gfx;

import java.awt.image.BufferedImage;

public class Backgrounds {
	public static BufferedImage Sky0, Logo;
	public static void init() {
		Sky0 = ImageLoader.loadImage("/backgrounds/Sky0.png");
		Logo = ImageLoader.loadImage("/backgrounds/Logo.png");
	}
}
