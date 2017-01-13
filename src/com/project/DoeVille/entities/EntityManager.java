package com.project.Doeville.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import com.project.Doeville.Handler;
import com.project.Doeville.entities.dynamics.Player;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	
	public CopyOnWriteArrayList<Entity> entities;
	public CopyOnWriteArrayList<Entity> walls;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) return -1;
			else return 1;
		}
	};
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new CopyOnWriteArrayList<Entity>();
		walls = new CopyOnWriteArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick() {
		for(Entity w: walls) {
			w.tick();
			if(!w.isActive()) walls.remove(w);
		}
		for(Entity e : entities) {
			e.tick();
			if(!e.isActive()) entities.remove(e);
		}
		Collections.sort(entities, renderSorter);	
	}
	
	public void render(Graphics g) {
		for(Entity w : walls) w.render(g);
		for(Entity e : entities) e.render(g); 
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void addWall(Entity e) {
		walls.add(e);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public CopyOnWriteArrayList<Entity> getEntities() {
		return entities;
	}
	
	public CopyOnWriteArrayList<Entity> getWalls() {
		return walls;
	}

	public void setEntities(CopyOnWriteArrayList<Entity> entities) {
		this.entities = entities;
	}
}
