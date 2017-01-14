package com.project.Doeville.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import com.project.Doeville.Handler;

public class ItemManager {
	private Handler handler;
	public ArrayList<Item> items;
	public ArrayList<Item> inventory;
	public ArrayList<Item> uniqueItemID;
	
	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
		inventory = new ArrayList<Item>();
		uniqueItemID = new ArrayList<Item>();
	}
	
	public void tick() {
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			if(i.isPicked_up()) it.remove();
		}
	}
	
	public void render(Graphics g){
		for(Item i : items) i.render(g);
	}
	
	public void addItem(Item i){
		i.setHandler(handler);
		items.add(i);
	}
	
	public void addItemToInventory(Item item){
		uniqueItemID.add(item);
		for(Item i : inventory) {
			if(i.getId() == item.getId()) { i.setCount(i.getCount() + 1); return; }
		}
		inventory.add(item);
	}
	
	public void removeItemFromInventory(Item item) {
		for(Item i : inventory) {
			if(i.getId() == item.getId()) {	 i.setCount(i.getCount() - 1); }	
		}
		
		Iterator<Item> it = inventory.iterator();
		while(it.hasNext()) {
			Item i1 = it.next();
			if(i1.getCount() <= 0) { i1.setCount(1); it.remove(); }
		}
		
	}
	
	public int getTotalInventoryCount() {
		int total = 0;
		for(Item i : inventory) {
			total += i.getCount();
		}
		return total;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
