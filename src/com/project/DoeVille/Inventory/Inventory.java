package com.project.Doeville.Inventory;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.list.PausedDialog;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.Item;
import com.project.Doeville.items.ItemCategory;
import com.project.Doeville.sounds.SoundEffect;

public class Inventory {
	protected ArrayList<String> tempItemStorage;
	protected Color setColorUse, setColorEquip, setColorCheck, setColorDrop, setColorCancel;
	protected Handler handler;
	protected HUD hud;
	public static boolean onInventory;
	public static String Hold;
	private int con, med, tol, key, tab_control, item_index, action_index, total_items;
	private int yCurPos = 0, fontHeight;
	private int x_ITEM = (32 * 7), y_ITEM = 145;
	private int x_ACTION = (32 * 2) - 4, y_ACTION = (32 * 4) - 2;
	private boolean u_flag, d_flag, l_flag, r_flag, x_flag, z_flag, esc_flag, equip_flag;
	private boolean itemSelection, actionSelection, hasItem, updateItemCount, soundOff;
	private boolean usable, equippable, droppable, checkable;
	private int itemPosY;
	private int first, last;
	private long lastTime, timer;

	public Inventory(Handler handler, HUD hud) {
		this.handler = handler; this.hud = hud;
		tempItemStorage = new ArrayList<String>();
		Hold = "Hold";
		timer = 0; lastTime = System.currentTimeMillis();
		con = 1; med = 0; tol = 0; key = 0; action_index = 0;
		setColorUse = Color.DARK_GRAY; setColorEquip = Color.DARK_GRAY; setColorCheck = Color.DARK_GRAY; setColorDrop = Color.DARK_GRAY; setColorCancel = Color.DARK_GRAY;
		usable = false; equippable = false; droppable = false; checkable = false;
		updateItemCount = true; 
		onInventory = false; itemPosY = 160;
		u_flag = false; d_flag = false; l_flag = false; r_flag = false; x_flag = false; z_flag = false; esc_flag = false; equip_flag = false;
		tab_control = 0; itemPosY = 0; itemSelection = false; actionSelection = false; hasItem = false;
		first = 0; last = 5;
	}
	
	public void tick() {
		if(onInventory) {
			
			if(updateItemCount) total_items = handler.getWorld().getItemManager().getTotalInventoryCount();
			updateItemCount = false;
			
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			if(timer > 100) {
				if(itemSelection) x_ITEM++;
				else if(actionSelection) x_ACTION++;
				
				if(x_ITEM > (32 * 7) + 4) x_ITEM = (32 * 7); 
				if(x_ACTION > ((32 * 2) - 4) + 4) x_ACTION = ((32 * 2) - 4);
				timer = 0;
			}
						
			if(!handler.getKeyManager().up) u_flag = false;
			if(!handler.getKeyManager().down) d_flag = false;
			if(!handler.getKeyManager().right) r_flag = false;
			if(!handler.getKeyManager().left) l_flag = false;
			if(!handler.getKeyManager().button_X) x_flag = false;
			if(!handler.getKeyManager().button_Z) z_flag = false;
			if(!handler.getKeyManager().button_ESC) esc_flag = false;
			
			if(u_flag || d_flag || r_flag || l_flag || x_flag || z_flag || esc_flag) return;
			
			if(handler.getKeyManager().button_ESC) { Player.ESC_delay = false; SoundEffect.Cancel.play(); closeInventory(); hud.getHunMeter().eatingTime = 0; esc_flag = true; return; }
			
			if(itemSelection) selectItem();
			else if(actionSelection) selectItemAction(); 
			else controlTab();
		}
	}
	
	private void controlTab() {		
		if(handler.getKeyManager().button_X) {
			SoundEffect.Cancel.play();
			hud.getHunMeter().eatingTime = 0; onInventory = false;
			Player.menu = false; PausedDialog.menu_flag = false; hasItem = false;
			tab_control = 0; changeTab(); x_flag = true; updateItemCount = true; 
			first = 0; last = 5; 
			return;
		}
		
		if(handler.getKeyManager().button_Z) { 
			if(hasItem) { 
				SoundEffect.Confirm.play();
				itemSelection = true;
				switch(tab_control) {
				case 0: con = 2; tempItemStorage.clear(); controlItemsToTempStorage(ItemCategory.Consumable); break; 
				case 1: med = 2; tempItemStorage.clear(); controlItemsToTempStorage(ItemCategory.Medicine); break; 
				case 2: tol = 2; tempItemStorage.clear(); controlItemsToTempStorage(ItemCategory.Equipment); break; 					
				case 3: key = 2; tempItemStorage.clear(); controlItemsToTempStorage(ItemCategory.KeyItem); break; 
				}
				item_index = 0;
			}
			z_flag = true; return;
		}
		
		if(handler.getKeyManager().right) { 
			SoundEffect.CursorMove.play();
			tab_control++; if(tab_control > 3) tab_control = 0; 
			hasItem = false; changeTab(); r_flag = true; return; } 
			
		else if(handler.getKeyManager().left) { 
			SoundEffect.CursorMove.play();
			tab_control--; if(tab_control < 0) tab_control = 3; 
			hasItem = false; changeTab(); l_flag = true; return; }	
	}
	
	private void selectItem() {
		if(handler.getKeyManager().button_X) {
			SoundEffect.Cancel.play();
			returnToTab();
			x_flag = true; 
			return;
		}
		
		if(handler.getKeyManager().button_Z) {
			SoundEffect.Confirm.play();
			actionSelection = true; itemSelection = false;
			changeActionState();
			z_flag = true; return;
		}
		
		if(handler.getKeyManager().up) {
			yCurPos--; item_index--;
			if(yCurPos <= 0) yCurPos = 0;
			if(item_index < 0) { item_index = 0; soundOff = true; }
			if(item_index < first) {
				first--; last--;
				if(first <= 0) first = 0;
				if(last <= 5) last = 5;
			}
			changeCurPos();
			if(!soundOff) SoundEffect.CursorMove.play(); 
			soundOff = false; u_flag = true; return;
		}
		else if(handler.getKeyManager().down) {
			int cap = 0;
			if(tempItemStorage.size() <= 5)  cap = tempItemStorage.size() - 1; 
			else cap = 5;
			yCurPos++; item_index++;
			if(yCurPos >= cap) yCurPos = cap;
			if(item_index >= tempItemStorage.size()) { item_index = tempItemStorage.size() - 1; soundOff = true; }
			if(yCurPos < item_index) { 
				++last; 
				if(last >= tempItemStorage.size()) last = tempItemStorage.size() - 1;
				first = last - 5;
			}
			changeCurPos();
			if(!soundOff) SoundEffect.CursorMove.play();
			soundOff = false; d_flag = true; return; 
		}		
	}
	
	private void changeCurPos() {
		switch(yCurPos) {
		case 0: y_ITEM = 145; break;
		case 1: y_ITEM = 145 + 23; break;
		case 2: y_ITEM = 145 + (23 * 2); break;
		case 3: y_ITEM = 145 + (23 * 3); break;
		case 4: y_ITEM = 145 + (23 * 4); break;
		case 5: y_ITEM = 145 + (23 * 5); break;
		}
	}
	
	private void selectItemAction() {
		setColorCancel = Color.BLACK;
		
		if(handler.getKeyManager().button_Z) {
			switch(action_index) {
				case 0: if(usable) { SoundEffect.PickUp.play(); useItem(); } else { SoundEffect.Cancel.play(); } break;
				case 1: if(equippable) { SoundEffect.PickUp.play(); useItem(); } else { SoundEffect.Cancel.play(); } break;
				case 2: if(checkable) { SoundEffect.PickUp.play(); useItem(); } else { SoundEffect.Cancel.play(); } break;
				case 3: if(droppable) { SoundEffect.PickUp.play(); useItem(); } else { SoundEffect.Cancel.play(); } break;
				case 4:
					SoundEffect.Cancel.play();
					setColorUse = Color.DARK_GRAY; setColorEquip = Color.DARK_GRAY; setColorCheck = Color.DARK_GRAY; setColorDrop = Color.DARK_GRAY; setColorCancel = Color.DARK_GRAY;
					usable = false; checkable = false; droppable = false;
					y_ACTION = (32 * 4) - 2; action_index = 0;
					actionSelection = false; itemSelection = true;
					break;
			}
			z_flag = true; return;
		}
		
		if(handler.getKeyManager().up) {
			action_index--;
			if(action_index < 0) { action_index = 0; d_flag = true; return; }
			SoundEffect.CursorMove.play();
			changeAction();
			u_flag = true; return;
		}
		
		else if(handler.getKeyManager().down) {
			action_index++;
			if(action_index > 4) { action_index = 4; d_flag = true; return; }
			SoundEffect.CursorMove.play();
			changeAction();
			d_flag = true; return;
		}
	}
	private void changeTab() {
		switch(tab_control) {
		case 0: con = 1; med = 0; tol = 0; key = 0; tempItemStorage.clear(); controlItemsToTempStorage(ItemCategory.Consumable); break;
		case 1: con = 0; med = 1; tol = 0; key = 0; tempItemStorage.clear(); controlItemsToTempStorage(ItemCategory.Medicine); break;
		case 2: con = 0; med = 0; tol = 1; key = 0; tempItemStorage.clear(); controlItemsToTempStorage(ItemCategory.Equipment); break;
		case 3: con = 0; med = 0; tol = 0; key = 1; tempItemStorage.clear(); controlItemsToTempStorage(ItemCategory.KeyItem); break;
		}
	}	
	private void changeAction() {
		switch(action_index) { case 0: y_ACTION = (32 * 4) - 1; break; case 1: y_ACTION = (32 * 5) - 1; break; case 2: y_ACTION = (32 * 6) - 1; break; case 3: y_ACTION = (32 * 7) - 1; break; case 4: y_ACTION = (32 * 8) - 1; break; }
	}	
	private void controlItemsToTempStorage(ItemCategory category) {
		if(!handler.getWorld().getItemManager().inventory.isEmpty()) {
			for(Item i : handler.getWorld().getItemManager().inventory) {
				if(i.getCategory() == category) {
					if(!tempItemStorage.contains(i.getItem_name())) tempItemStorage.add(i.getItem_name());
				}
			}
		}
	}
	
	private void changeActionState() {
		if(!handler.getWorld().getItemManager().inventory.isEmpty()) {
			for(Item i: handler.getWorld().getItemManager().inventory) {
				if(i.getItem_name().equals(tempItemStorage.get(item_index))) {
					usable = i.isCanUse();
					equippable = i.isCanEquip();
					checkable = i.isCanCheck();
					droppable = i.isCanDrop();
					Hold = !i.isEquipped() ? "Hold" : "Unhold";
				}
			}
			
			if(usable) setColorUse = Color.BLACK;
			if(equippable) setColorEquip = Color.BLACK;
			if(checkable) setColorCheck = Color.BLACK;
			if(droppable) setColorDrop = Color.BLACK;
		}
	}
	
	private void useItem() {
		if(!handler.getWorld().getItemManager().inventory.isEmpty()) {
			for(Item i: handler.getWorld().getItemManager().inventory) {
				if(i.getItem_name().equals(tempItemStorage.get(item_index))) {
					if(action_index != 1) handler.getWorld().getItemManager().removeItemFromInventory(i);
					for(Item i2 : handler.getWorld().getItemManager().uniqueItemID) {
						if(i.getItem_name().equals(i2.getItem_name())) {
							switch(action_index) {
							case 0: if(i2.isCanUse()) i2.use(); break; 
							case 1: if(i2.isCanEquip()) i2.hold(handler, hud); equip_flag = true; break;
							case 2: if(i2.isCanCheck()) i2.check(); break;
							case 3: if(i2.isCanDrop()) i2.drop(handler); break;
							}
							if(equip_flag) { equip_flag = false; break; }
							for(Iterator<Item> it = handler.getWorld().getItemManager().uniqueItemID.iterator(); it.hasNext(); ) {
								Item i1 = it.next(); if(i1.getCount() >= 1 && i1.getItem_name().equals(i.getItem_name())) { it.remove();  break; }
							}
							break;
						}	
					}					
					if(!PausedDialog.interior_flag) closeInventory();
					else returnToTab();					
					break;
				}
			}
		}
	}
	
	public void closeInventory() {
		onInventory = false;
		Player.menu = false; Player.paused = false; PausedDialog.menu_flag = false; action_index = 0; 
		tempItemStorage.clear(); y_ITEM = 145; y_ACTION = (32 * 4) - 2; yCurPos = 0;
		itemSelection = false; actionSelection = false; hasItem = false; 
		tab_control = 0; changeTab();
		setColorUse = Color.DARK_GRAY; setColorEquip = Color.DARK_GRAY; setColorCheck = Color.DARK_GRAY; setColorDrop = Color.DARK_GRAY; setColorCancel = Color.DARK_GRAY;
		usable = false; checkable = false; droppable = false;
		item_index = 0; updateItemCount = true; Hold = "Hold";
		first = 0; last = 5;
	}
	
	public void returnToTab() {
		itemSelection = false; actionSelection = false; changeTab(); yCurPos = 0; hasItem = false; y_ITEM = 145;
		setColorUse = Color.DARK_GRAY; setColorEquip = Color.DARK_GRAY; setColorCheck = Color.DARK_GRAY; setColorDrop = Color.DARK_GRAY; setColorCancel = Color.DARK_GRAY;
		usable = false; checkable = false; droppable = false; Hold = "Hold"; 
		first = 0; last = 5;
	}
	
	public void render(Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		if(onInventory) {
			itemPosY = 160;
			//Background
			g.setColor(new Color(27, 2, 218));
			g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
			
			//Item Main Panel
			g.drawImage(Assets.dialogBox1[0], 15, 15, 32, 32, null);
			g.drawImage(Assets.dialogBox1[2], (32 * 18) + 15, 15, 32, 32, null);
			constructWindow(g, Assets.dialogBox1, 1, 13, 1, 18, 15, 15, (32 * 18) + 15);		
			g.drawImage(Assets.dialogBox1[6], 15, (32 * 13) + 15, 32, 32, null);
			g.drawImage(Assets.dialogBox1[8], (32 * 18) + 15, (32 * 13) + 15 , 32, 32, null);
			//End Item Main Panel
			
			//Item Option Panel
			g.drawImage(Assets.dialogBox2[0], 32 + 15, (32 * 4) - 37, 32, 32, null);
			g.drawImage(Assets.dialogBox2[2], (32 * 5) + 15, (32 * 4) - 37, 32, 32, null);
			constructWindow(g,  Assets.dialogBox2, 5, 10, 2, 5, (-1) * 37, 32 + 15, (32 * 5) + 15);
			g.drawImage(Assets.dialogBox2[6], 32 + 15, (32 * 10) - 37, 32, 32, null);
			g.drawImage(Assets.dialogBox2[8], (32 * 5) + 15, (32 * 10) - 37, 32, 32, null);
			//End Item Option Panel
			
			//Panel Title Box
			g.drawImage(Assets.TdialogBox[0], 32 + 15, (32 * 2) - 20, 32, 32, null);
			g.drawImage(Assets.TdialogBox[2], (32 * 5) + 15, (32 * 2) - 20, 32, 32, null);
			for(int i = 2; i < 5; i++) {
				g.drawImage(Assets.TdialogBox[1], (32 * i) + 15, (32 * 2) - 20, 32, 32, null);
				g.drawImage(Assets.TdialogBox[7], (32 * i) + 15, (32 * 3) - 20, 32, 32, null);
			}
			g.drawImage(Assets.TdialogBox[6], 32 + 15, (32 * 3) - 20, 32, 32, null);
			g.drawImage(Assets.TdialogBox[8], (32 * 5) + 15, (32 * 3) - 20, 32, 32, null);
			//End Panel Title Box
			
			//Item List Panel
			g.drawImage(Assets.dialogBox2[9], (32 * 6) + 15, (32 * 3) - 5, 32, 32, null);
			g.drawImage(Assets.dialogBox2[10], (32 * 17) + 15, (32 * 3) - 5, 32, 32, null);
			constructWindow(g,  Assets.dialogBox2, 4, 9, 7, 17, (-1) * 5, (32 * 6) + 15, (32 * 17) + 15);
			g.drawImage(Assets.dialogBox2[6], (32 * 6) + 15, (32 * 9) - 5, 32, 32, null);
			g.drawImage(Assets.dialogBox2[8], (32 * 17) + 15, (32 * 9) - 5 , 32, 32, null);
			//End Item List Panel
			
			//Item Panel Tabs
			g.drawImage(Assets.ConsumableTab[con], (32 * 6) + 21, (32 * 2) - 14, (46 * 2) + 1, 47, null);
			g.drawImage(Assets.MedicineTab[med], (32 * 9) + 18, (32 * 2) - 14, (46 * 2) + 1, 47, null);
			g.drawImage(Assets.ToolTab[tol], (32 * 12) + 15, (32 * 2) - 14, (46 * 2) + 1, 47, null);
			g.drawImage(Assets.KeyTab[key], (32 * 15) + 12, (32 * 2) - 14, (46 * 2) + 1, 47, null);
			
			//Inventory Status Panel
			g.drawImage(Assets.TdialogBox[0], 32 + 15, (32 * 10) - 5, 32, 32, null);
			g.drawImage(Assets.TdialogBox[2], (32 * 5) + 15, (32 * 10) - 5, 32, 32, null);
			constructWindow(g, Assets.TdialogBox, 11, 13, 2, 5, (-1) * 5, 32 + 15, (32 * 5) + 15);
			g.drawImage(Assets.TdialogBox[6], 32 + 15, (32 * 13) - 5, 32, 32, null);
			g.drawImage(Assets.TdialogBox[8], (32 * 5) + 15, (32 * 13) - 5 , 32, 32, null);
			//End Inventory Status Panel
			
			//Item Description Panel
			g.drawImage(Assets.TdialogBox[0], (32 * 6) + 15, (32 * 10) - 5, 32, 32, null);
			g.drawImage(Assets.TdialogBox[2], (32 * 17) + 15, (32 * 10) - 5, 32, 32, null);
			constructWindow(g, Assets.TdialogBox, 11, 13, 7, 17, (-1) * 5, (32 * 6) + 15, (32 * 17) + 15);
			g.drawImage(Assets.TdialogBox[6], (32 * 6) + 15, (32 * 13) - 5, 32, 32, null);
			g.drawImage(Assets.TdialogBox[8], (32 * 17) + 15, (32 * 13) - 5 , 32, 32, null);
			//End Item Description Panel
			
			//Item Picture Box
			g.drawImage(Assets.dialogBox2[0], (32 * 6) + 30, (32 * 10) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[1], (32 * 7) + 30, (32 * 10) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[2], (32 * 8) + 30, (32 * 10) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[3], (32 * 6) + 30, (32 * 11) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[4], (32 * 7) + 30, (32 * 11) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[5], (32 * 8) + 30, (32 * 11) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[6], (32 * 6) + 30, (32 * 12) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[7], (32 * 7) + 30, (32 * 12) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[8], (32 * 8) + 30, (32 * 12) + 10, 32, 32, null);
			//End Item Picture Box
			
			//Item Description Box
			g.drawImage(Assets.dialogBox2[0], (32 * 9) + 30, (32 * 10) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[3], (32 * 9) + 30, (32 * 11) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[6], (32 * 9) + 30, (32 * 12) + 10, 32, 32, null);
			for(int i = 10; i < 16; i++) {
				g.drawImage(Assets.dialogBox2[1], (32 * i) + 30, (32 * 10) + 10, 32, 32, null);
				g.drawImage(Assets.dialogBox2[4], (32 * i) + 30, (32 * 11) + 10, 32, 32, null);
				g.drawImage(Assets.dialogBox2[7], (32 * i) + 30, (32 * 12) + 10, 32, 32, null);
			}
			g.drawImage(Assets.dialogBox2[2], (32 * 16) + 30, (32 * 10) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[5], (32 * 16) + 30, (32 * 11) + 10, 32, 32, null);
			g.drawImage(Assets.dialogBox2[8], (32 * 16) + 30, (32 * 12) + 10, 32, 32, null);
			//End Description Box
	
			g.setColor(Color.BLACK);
			g.setFont(handler.getFF().itemFont);
			g.drawString("Inventory", 32 * 2, (32 * 3) - 12);
			
			g.setFont(handler.getFF().itemFont1);
			g.setColor(setColorUse);
			g.drawString("Use", (32 * 2) + 20, (32 * 4) + 15);
			g.setColor(setColorEquip);
			g.drawString(Hold, (32 * 2) + 20, (32 * 5) + 15);
			g.setColor(setColorCheck);
			g.drawString("Check", (32 * 2) + 20, (32 * 6) + 15);
			g.setColor(setColorDrop);
			g.drawString("Drop", (32 * 2) + 20, (32 * 7) + 15);
			g.setColor(setColorCancel);
			g.drawString("Cancel", (32 * 2) + 20, (32 * 8) + 15);
			
			g.setColor(new Color(109, 41, 1));
			g.drawString("Item Name", (32 * 6) + 35, 32 * 4);
			g.drawString("Qty.", (32 * 15) + 35, 32 * 4);
			
			g.setColor(Color.BLACK);
			g.setFont(handler.getFF().itemFont2);
			
			switch(tab_control) {
			case 0: showInventory(g, ItemCategory.Consumable, fm); break;
			case 1: showInventory(g, ItemCategory.Medicine, fm); break;		
			case 2: showInventory(g, ItemCategory.Equipment, fm); break;			
			case 3: showInventory(g, ItemCategory.KeyItem, fm); break;
			}
			
			if(itemSelection) {
				g.drawImage(Assets.hCursor, x_ITEM, y_ITEM, 16, 16, null);
				showItemDescription(g);
			}
			
			if(actionSelection) {
				showItemDescription(g);
				g.drawImage(Assets.hCursor, x_ACTION, y_ACTION, 16, 16, null);
			}
			
			g.setColor(new Color(20, 0, 180));
			g.setFont(handler.getFF().itemFont3);
			g.drawString("Inventory", (32 * 2) + 5, (32 * 11) - 5);
			g.drawString("Status", (32 * 2) + 5, ((32 * 11) - 5) + (fm.getHeight() - 7));
			
			g.setColor(Color.BLACK);
			g.drawImage(Assets.inventoryIcon, (32 * 2) - 5, (32 * 11) + 15, 32, 32, null);
			g.drawString("LVL:",  32 * 3, (32 * 12) + 5);
			g.drawString("1",  (32 * 5) - 20, (32 * 12) + 5);
			
			g.drawImage(Assets.capacityIcon, (32 * 2) - 5, (32 * 12) + 10, 32, 32, null);
			g.drawString("CAP:",  32 * 3, 32 * 13);
			g.drawString(String.valueOf(total_items) + "/30",  (32 * 5) - 20, 32 * 13);
			
			g.setColor(new Color(109, 41, 1));
			g.setFont(handler.getFF().itemFont5);
			g.drawString("Description:", (32 * 10) + 16, (32 * 11) + 6);
			
		}
	}
	
	private void showInventory(Graphics g, ItemCategory category, FontMetrics fm) {
		int quantity = 0; String quantityVal; int pos = 0;
		if(!handler.getWorld().getItemManager().uniqueItemID.isEmpty()) {
			for(Item i: handler.getWorld().getItemManager().inventory) {
				if(i.getCategory() == category) {
					pos++;
					if(pos <= first) continue;
					quantity = i.getCount();
					if(quantity > 9) quantityVal = String.valueOf(quantity);
					else quantityVal = "0" + quantity;
					
					Color setColor = i.isEquipped() ? Color.RED : Color.BLACK;
					g.setColor(setColor);
					g.drawString(i.getItem_name(), (32 * 6) + 60, itemPosY);
					g.drawString(quantityVal, (32 * 15) + 45, itemPosY);
					g.setColor(Color.BLACK);
					fontHeight = fm.getHeight();
					itemPosY += fontHeight;
					hasItem = true;
					if(pos > last) break;
				}
			}
		}
		itemPosY = 160;
	}
	
	private void showItemDescription(Graphics g) {
		if(!handler.getWorld().getItemManager().uniqueItemID.isEmpty()) {
			for(Item i : handler.getWorld().getItemManager().inventory) {
				if(i.getItem_name().equals(tempItemStorage.get(item_index))) {
					g.drawImage(i.getTexture(), (32 * 6) + 45, (32 * 10) + 26, 64, 64, null);
					g.setFont(handler.getFF().itemFont4);
					drawString(g, i.getDescription(), (32 * 9) + 50, (32 * 11) + 23, 230);
					break;
				}
			}
		}
	}
	
	private void constructWindow(Graphics g, BufferedImage[] frame, int x1, int y1, int x2, int y2, int h, int a, int b) {
		for(int i = x1; i < y1; i++) {
			g.drawImage(frame[3], a, (32 * i) + h, 32, 32, null);
			g.drawImage(frame[5], b, (32 * i) + h, 32, 32, null);
		}
		for(int i = x2; i < y2; i++){
			g.drawImage(frame[1],(32 * i) + 15, (32 * (x1 - 1)) + h, 32, 32, null);
			g.drawImage(frame[7],(32 * i) + 15, (32 * y1) + h, 32, 32, null);
			for(int j = x1; j < y1; j++) { g.drawImage(frame[4],(32 * i) + 15, (32 * j) + h, 32, 32, null); }
		}
	}
	
	public void drawString(Graphics g, String s, int x, int y, int width) {
		FontMetrics fm = g.getFontMetrics();
		int lineHeight = fm.getHeight() - 9;
		int curX = x;
		int curY = y;
		String[] words = s.split(" ");
		for (String word : words) {
			int wordWidth = fm.stringWidth(word + " ");
			if (curX + wordWidth >= x + width) {
				curY += lineHeight;
				curX = x;
			}

			g.drawString(word, curX, curY);		
			curX += wordWidth;
		}
	}
}
