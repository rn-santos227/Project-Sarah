package com.project.Doeville.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {
	
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right;
	public boolean button_X, button_Z;
	public boolean flag_Z = false;
	public boolean button_ESC;
	
	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public void tick() {
		for(int i = 0; i > keys.length; i++) {
			if(cantPress[i] && !keys[i]) cantPress[i] = false;
			else if(justPressed[i]) {
				cantPress[i] = true; justPressed[i] = false;
				if(!cantPress[i]&& keys[i]) justPressed[i] = false;
 			}
		}
				
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		button_Z = keys[KeyEvent.VK_Z];
		button_X = keys[KeyEvent.VK_X];
		button_ESC = keys[KeyEvent.VK_ESCAPE];
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > keys.length) { 
			for(int i = 0; i < keys.length; i++) keys[i] = false;
			return;
		}
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > keys.length) {
			for(int i = 0; i < keys.length; i++) keys[i] = false;
			return;
		}
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length) return false;
		return justPressed[keyCode];
	}

}
