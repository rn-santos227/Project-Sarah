package com.project.Doeville.profile;

import java.awt.Color;
import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.hud.HUD;

public class Profile {
	public static boolean onProfile;
	private Handler handler;
	private HUD hud;
	private long lastTime, timer;
	
	public Profile(Handler handler, HUD hud) {
		this.handler = handler; this.hud = hud;
		onProfile = false;
		timer = 0; lastTime = System.currentTimeMillis();
	}
	
	public void tick() {
		if(onProfile) {
			
		}
	}
	
	public void render(Graphics g) {
		if(onProfile) {
			g.setColor(new Color(27, 2, 218));
			g.fillRect(0, 0, handler.getWidth(), handler.getHeight());	
		}
	}
}
