package com.project.Doeville.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	private boolean stop;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		stop = false;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick(){
		if(!stop) {
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			
			if(timer > speed) {
				index++;
				timer = 0;
				if(index >= frames.length) index = 0;
			}	
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public boolean isStop() {
		return stop;
	}
}
