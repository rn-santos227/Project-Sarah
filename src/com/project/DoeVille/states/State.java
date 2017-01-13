package com.project.Doeville.states;

import java.awt.Graphics;

import com.project.Doeville.Handler;
import com.project.Doeville.gfx.Transition;

public abstract class State {
	
	public static State currentState = null;
	public boolean isNewGame = true;
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() { return currentState; }
	protected Handler handler;
	protected Transition tran;
	public State(Handler handler, Transition tran){
		this.handler = handler; this.tran = tran;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
