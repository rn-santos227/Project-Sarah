package com.project.Doeville.hud;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.project.Doeville.Handler;
import com.project.Doeville.clock.GameClock;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;

public class HUD {
	float alpha = 0.80f;
	public BufferedImage onHandItem;
	protected Handler handler;
	protected Assets asset;
	protected BufferedImage moodSwitcher;
	protected final double F_HEIGHT, F_POSITION;
	protected EnergyMeter engMeter; protected HealthMeter heaMeter;
	protected HungerMeter hunMeter; protected HygieneMeter hygMeter;
	protected MoodMeter mooMeter; protected StaminaMeter staMeter;
	private GameClock clock;
	private double doellar;

	public HUD(Handler handler) {
		this.handler = handler;
		int y_pos = 424;
		doellar = 100;
		moodSwitcher = Assets.emotions[0];
		onHandItem = null;
		clock = new GameClock((32 * 16) + 7, 15 + 32);
		engMeter = new EnergyMeter(handler, clock, 170, y_pos, new Color(24, 196, 65));
		heaMeter = new HealthMeter(handler, engMeter, 215, y_pos, new Color(24, 196, 65));
		hunMeter = new HungerMeter(handler, 260, y_pos, new Color(24, 196, 65));
		hygMeter = new HygieneMeter(handler, 305, y_pos, new Color(24, 196, 65));
		mooMeter = new MoodMeter(handler, engMeter, 350, y_pos, new Color(24, 196, 65));
		staMeter = new StaminaMeter(handler, 395, y_pos, Color.WHITE);	
		F_HEIGHT = engMeter.F_HEIGHT; F_POSITION = engMeter.F_POSITION;
	}
	
	public void tick() {
		if(!Player.paused) {
			if(engMeter.m_amount >= (48 * 0.25)) moodSwitcher = Assets.emotions[0];
			
			clock.tick();
			heaMeter.tick();
			staMeter.tick();
			engMeter.tick();
			hunMeter.tick();
			hygMeter.tick();
			mooMeter.tick();
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));

		g.drawImage(Assets.windows[0], 16, 345, 64 * 2, 64 * 2, null);
		g.drawImage(Assets.windows[1], (32 * 4) + 15, 345, 64 * 5, 64 * 2, null);

		g.drawImage(Assets.dialogBox[0], (32 * 14) + 20, 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[3], (32 * 14) + 20, 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[6], (32 * 14) + 20, (32 * 2) + 5, 32, 32, null);
		
		for(int x = 15; x < 18; x++) repeatFrame2(g, x);
		
		g.drawImage(Assets.dialogBox[2], (32 * 18) + 20, 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[5], (32 * 18) + 20, 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[8], (32 * 18) + 20, (32 * 2) + 5, 32, 32, null);
		
		g.drawImage(Assets.dialogBox_small[0], (32 * 4) + 17, 320, 16, 32, null);
		for(int x = 10; x < 22; x++) g.drawImage(Assets.dialogBox_small[1], (16 * x) + 1, 320, 16, 32, null);
		g.drawImage(Assets.dialogBox_small[2], (22 * 16) + 1, 320, 16, 32, null);
		
		
		g.drawImage(Assets.windows[0], (32 * 16) - 16, 345, 64 * 2, 64 * 2, null);
		
		
		g2d.setComposite(makeTransparent(1));
		
		g.setColor(Color.BLACK);
		g.drawRect(38, 374, 83, 83);
		g.drawImage(moodSwitcher, 39, 375, 82, 82, null);
		g.setFont(handler.getFF().hudFont);
		g.setColor(Color.WHITE);
		g.drawString("Status", 55, 370);
		g.setFont(handler.getFF().hudFont1);
		g.drawString("Energy", 168, 370);
		g.drawString("Health", 213, 370);
		g.drawString("Hunger", 258, 370);
		g.drawString("Hygiene", 300, 370);
		g.drawString("Mood", 354, 370);
		g.drawString("Stamina", 390, 370);
		
		g.setFont(handler.getFF().hudFont);
		g.drawString("DOELLAR:", 32 * 5, 341);
		g.drawString(String.valueOf(doellar), (32 * 11) - (10 * String.valueOf(doellar).length()), 341);
		g.drawString("On Hand:", (32 * 16), 370);
		if(!(onHandItem == null)) {
			g.setColor(Color.BLACK);
			g.drawImage(onHandItem, (32 * 17) - 15, 385, 64, 64, null);
			g.drawRect((32 * 16) + 7, 374, 83, 83);
			g.drawImage(Assets.brownFrame, (32 * 16) + 8, 375, 82, 82, null);
		}
		engMeter.render(g);
		heaMeter.render(g);
		hunMeter.render(g);
		hygMeter.render(g);
		mooMeter.render(g);
		staMeter.render(g);
		clock.render(g);
	}
	
	private void repeatFrame2(Graphics g, int x) {
		g.drawImage(Assets.dialogBox[1], (32 * x) + 20, 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[4], (32 * x) + 20, 32 + 5, 32, 32, null);
		g.drawImage(Assets.dialogBox[7], (32 * x) + 20, (32 * 2) + 5, 32, 32, null);
	}
	
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	public double getF_HEIGHT() {
		return F_HEIGHT;
	}

	public double getF_POSITION() {
		return F_POSITION;
	}

	public BufferedImage getMoodSwitcher() {
		return moodSwitcher;
	}

	public void setMoodSwitcher(BufferedImage moodSwitcher) {
		this.moodSwitcher = moodSwitcher;
	}

	public EnergyMeter getEngMeter() {
		return engMeter;
	}

	public HealthMeter getHeaMeter() {
		return heaMeter;
	}

	public HungerMeter getHunMeter() {
		return hunMeter;
	}

	public HygieneMeter getHygMeter() {
		return hygMeter;
	}

	public MoodMeter getMooMeter() {
		return mooMeter;
	}

	public StaminaMeter getStaMeter() {
		return staMeter;
	}
	
	public GameClock getGameClock() {
		return clock;
	}

	public double getDoellar() {
		return doellar;
	}

	public void setDoellar(double d) {
		this.doellar = d;
	}

}
