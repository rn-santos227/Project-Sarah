package com.project.Doeville.entities.statics;


import java.awt.Graphics;
import java.util.Random;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class Tree extends StaticEntity {
	private Random ran;
	protected String message;
	protected int select;
	private float x, y;

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.t_Width * 2, (Tile.t_Height + 10) * 2, EntityID.Tree, MapAssignment.Map000);
		int width = Tile.t_Width * 2 , height = (Tile.t_Height + 10) * 2;
		this.x = x; this.y = y;
		loadScript = new LoadScript("Dialogues.lua");
		
		bounds.x = 40;
		bounds.y = (int) (height / 1.5f);
		bounds.width = (width - 20) - 60;
		bounds.height = (int) (height - height / 1.5f);	

	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	
	}
	
	public void examine() {
		Player.dID = DialogID.information;
		ran = new Random();
		this.select = ran.nextInt(4);
		loadScript.runScript("getMessage00", this);
		Player.messages = message;
		Player.mID = 0;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	@Override
	public void resetOriginalState() {
		// TODO Auto-generated method stub
		
	}

	public Entity clone() {
		Entity e = new Tree(handler, x, y);
		return e;
	}

}
