package com.project.Doeville.entities.statics;


import com.project.Doeville.Handler;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height, EntityID ID, MapAssignment mapAssignment) {
		super(handler, x, y, width, height, ID, mapAssignment);
	}
}
