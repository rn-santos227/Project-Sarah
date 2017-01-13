package com.project.Doeville.entities.statics.buildings;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.clock.GameClock;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.entities.statics.StaticEntity;
import com.project.Doeville.entities.triggers.doors.ITWorkplaceDoor;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.scripts.LoadScript;
import com.project.Doeville.tiles.Tile;

public class ITWorkplace extends StaticEntity {
	private HUD hud;
	private DisplayDialog dd;
	private ITWorkplaceDoor door;
	private Transition tran;
	private float x, y;
	
	public ITWorkplace(Handler handler, HUD hud, DisplayDialog dd, Transition tran, float x, float y) {
		super(handler, x, y, (Tile.t_Height / 2) * 8, (Tile.t_Height / 2) * 10, EntityID.Building, MapAssignment.Map000);
		this.hud = hud; this.dd = dd; this.tran = tran; this.x = x; this.y = y;
		bounds.x = 5;
		bounds.y = (int) (this.height / 1.5f) - 30;
		bounds.width = this.width - 10;
		bounds.height = (int) ((this.height - height / 1.5f) + 30);
		loadScript = new LoadScript("Dialogues.lua");	
		door = new ITWorkplaceDoor(handler, hud, dd, 1186, 1446);;
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.IT_Workplace, (int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		door.render(g);
	}

	public void examine() {
		if(door.getCollisionBounds(0f, 0f).intersects(Player.examineBox)) {
			hud.getGameClock();
			if(((hud.getGameClock().getHours() >= 8 && hud.getGameClock().getHours() < 17)) && !GameClock.currentWeekDay.equals("Sunday")) door.examine();
			else {
				Player.displayDialog = true;
				Player.Examining = true;
				Player.dID = DialogID.information;
				Player.messages = "The workplace is close.";
			}
		}
		else Player.dID = DialogID.empty;
	} 

	public void resetOriginalState() {
		
	}

	public Entity clone() {
		Entity e = new ITWorkplace(handler, hud, dd, tran, x, y);
		return e;
	}
}
