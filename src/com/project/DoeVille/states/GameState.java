package com.project.Doeville.states;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.clock.DayNight;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.world.World;

public class GameState extends State{
	private HUD hud;
	private DayNight dn;
	private DisplayDialog dd;
	private World world;

	public GameState(Handler handler, Transition tran) {
		super(handler, tran);
		this.tran = tran;
		hud = new HUD(handler); 
		dn = new DayNight(handler);
		dd = new DisplayDialog(handler, hud, tran);
		world = new World(handler, hud, dd, tran, "res/maps/map000");
		handler.setWorld(world);
		
		if(isNewGame) setGameClockToDefault();
	}	
	public void setGameClockToDefault() {
		hud.getGameClock().setG_hours(0);
		hud.getGameClock().setG_minutes(0);
		hud.getGameClock().setG_seconds(0);
	}
	
	public void tick() { world.tick(); hud.tick(); dd.tick(); tran.tick(); }
	public void render(Graphics g) { world.render(g); dn.render(g); hud.render(g); dd.render(g); tran.render(g); }

}
