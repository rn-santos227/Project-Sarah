package com.project.Doeville.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.project.Doeville.Handler;
import com.project.Doeville.scripts.LoadScript;

public abstract class Entity {
	protected Handler handler;
	protected EntityID ID;
	protected MapAssignment mapAssignment;
	protected float x, y;
	protected int width, height;
	protected boolean active = true;
	protected Rectangle bounds;
	protected LoadScript loadScript;
	
	public Entity(Handler handler, float x, float y, int width, int height, EntityID ID,  MapAssignment mapAssignment) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.ID = ID;
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void examine();
	public abstract Entity clone();
	public abstract void resetOriginalState();
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this)) continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) return true;
		}
		for(Entity w : handler.getWorld().getEntityManager().getWalls()) {
			if(w.equals(this)) continue;
			if(w.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public EntityID getID() {
		return ID;
	}

	public void setID(EntityID iD) {
		ID = iD;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public MapAssignment getMapAssignment() {
		return mapAssignment;
	}

	public Rectangle getBounds() {
		return bounds;
	}

}
