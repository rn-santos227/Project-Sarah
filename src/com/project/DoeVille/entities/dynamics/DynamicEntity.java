package com.project.Doeville.entities.dynamics;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.tiles.Tile;

public abstract class DynamicEntity extends Entity {	
	public static final int DEFAULT_P = 100;
	public static final float DEFAULT_S = 2.5f;
	public static final int DEFAULT_W = 64, DEFAULT_H = 64;
	
	protected float speed, xVel, yVel;
	protected boolean NPCfacing;
	public DynamicEntity(Handler handler, float x, float y, int width, int height, EntityID ID, MapAssignment mapAssignment) {
		super(handler, x, y, width, height, ID, mapAssignment);
		speed = DEFAULT_S;
		xVel = 0; yVel = 0;
	}
		
	public void move() { 
		if(!checkEntityCollisions(xVel, 0f)) moveX(); 
		if(!checkEntityCollisions(0f, yVel)) moveY(); 
	}
	
	public void moveX() {
		if(xVel > 0) {
			int tx = (int) (x + xVel + bounds.x + bounds.width) / Tile.t_Width;
			if(collisionWithTile(tx, (int)(y + bounds.y) / Tile.t_Height) && collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.t_Height)) x += xVel;
			else x = tx * Tile.t_Width - bounds.x - bounds.width - 1;
		}else if(xVel < 0) {
			int tx = (int) (x + xVel + bounds.x) / Tile.t_Width;
			if(collisionWithTile(tx, (int)(y + bounds.y) / Tile.t_Height) && collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.t_Height)) x += xVel;
			else x = tx * Tile.t_Width + Tile.t_Width - bounds.x;	
		}
	}
	
	public void moveY() { 
		if(yVel < 0) {
			int ty = (int)(y + yVel + bounds.y) / Tile.t_Height;
			if(collisionWithTile((int)(x + bounds.x) / Tile.t_Width, ty) && collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.t_Width, ty)) y += yVel;
			else y = ty * Tile.t_Height + Tile.t_Height - bounds.y;
		}else if(yVel > 0){
			int ty = (int)(y + yVel + bounds.y + bounds.height) / Tile.t_Height;
			if(collisionWithTile((int)(x + bounds.x) / Tile.t_Width, ty) && collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.t_Width, ty)) y += yVel;
			else y = ty * Tile.t_Height - bounds.y - bounds.height - 1;
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isWalkable();
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxVel() {
		return xVel;
	}

	public void setxVel(float xVel) {
		this.xVel = xVel;
	}

	public float getyVel() {
		return yVel;
	}

	public void setyVel(float yVel) {
		this.yVel = yVel;
	}
}
