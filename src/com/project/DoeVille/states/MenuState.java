package com.project.Doeville.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.project.Doeville.Handler;
import com.project.Doeville.gfx.Backgrounds;
import com.project.Doeville.gfx.Buttons;
import com.project.Doeville.gfx.Transition;

public class MenuState extends State {
	private BufferedImage newGame, loadGame, setting, quit;
	private long lastTime, timer;
	private float cameraPosX, resetPos;
	private int x;
	private boolean u_flag, d_flag, z_flag;
	
	public MenuState(Handler handler, Transition tran) {
		super(handler, tran);
		timer = 0; resetPos = 640;
		lastTime = System.currentTimeMillis();
		x = handler.getWidth();
		newGame = Buttons.NewGame[1];
		loadGame = Buttons.LoadGame[0];
		setting = Buttons.Setting[0];
		quit  =Buttons.Quit[0];
		u_flag = false; d_flag = false; z_flag = false;
	}

	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if(timer > 50) {
			cameraPosX++;
			if(cameraPosX >= 330) resetPos--;
			if(resetPos <= 0) {
				cameraPosX = 0;
				resetPos = 640;
			}
			timer = 0;
		}	
		
		if(!handler.getKeyManager().up) u_flag = false;
		if(!handler.getKeyManager().down) d_flag = false;
		if(!handler.getKeyManager().button_Z) z_flag = false;
		if(d_flag || u_flag || z_flag) return;
		
	}

	public void render(Graphics g) {
		g.setFont(handler.getFF().customFont);
		g.drawImage(Backgrounds.Sky0, (int)-cameraPosX, 0, Backgrounds.Sky0.getWidth(), handler.getHeight(), null);
		if(cameraPosX >= 340) g.drawImage(Backgrounds.Sky0, (int)resetPos, 0, Backgrounds.Sky0.getWidth(), handler.getHeight(), null);
		
		g.drawImage(Backgrounds.Logo, 70, 40, null);
		
		int def_x = (x / 2) - 64;
		g.drawImage(newGame, def_x, 280, null);
		g.drawImage(loadGame, def_x, 320, null);
		g.drawImage(setting, def_x, 360, null);
		g.drawImage(quit, def_x, 400, null);
		
		g.setColor(Color.BLACK);
		g.drawString("Developed by Team Yorozuya", 10, handler.getHeight() - 10);
	}

}
