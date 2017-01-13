package com.project.Doeville;

import com.project.Doeville.gfx.GameCamera;
import com.project.Doeville.input.KeyManager;
import com.project.Doeville.states.State;
import com.project.Doeville.utils.FontFactory;
import com.project.Doeville.world.World;

public class Handler {
	private Game game;
	private World world;
	private FontFactory ff;
	private State state;
	
	public Handler(Game game) { 
		this.game = game; 
	}
	
	public GameCamera getGameCamera() { 
		return game.getGameCamera(); 
	}
	
	public KeyManager getKeyManager() { 
		return game.getKeyManager(); 
	}
	
	public int getWidth() { 
		return game.getWidth(); 
	}	
	
	public int getHeight() { 
		return game.getHeight(); 
	}
	
	public Game getGame() { 
		return game; 
	}
	
	public void setGame(Game game) { 
		this.game = game; 
	}
	
	public World getWorld() { 
		return world; 
	}
	
	public void setWorld(World world) { 
		this.world = world; 
	}
	
	public FontFactory getFF() { 
		return ff; 
	}
	
	public void setFF(FontFactory ff) { 
		this.ff = ff; 
	}

	public State getState() {
		return state;
	}

	public int clamp(int val, int min, int max) {
		if(val >= max) return val = max;
		else if(val <= min) return val = min;
		else return val;
	}
}
