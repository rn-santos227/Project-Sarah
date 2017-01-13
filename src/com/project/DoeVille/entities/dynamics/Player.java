package com.project.Doeville.entities.dynamics;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.DialogID;
import com.project.Doeville.dialogs.DisplayDialog;
import com.project.Doeville.entities.Entity;
import com.project.Doeville.entities.EntityID;
import com.project.Doeville.entities.MapAssignment;
import com.project.Doeville.gfx.Animation;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.hud.HUD;
import com.project.Doeville.items.Item;
import com.project.Doeville.sounds.SoundEffect;
import com.project.Doeville.tiles.Tile;

public class Player extends DynamicEntity {
	public static boolean tu, td, tl, tr;
	public static boolean canMove, isTired, Examining, pickingItem;
	public static boolean eating, running, moving, asleep;
	public static boolean displayDialog, condition;
	public static boolean paused, menu;
	public static Rectangle examineBox;
	public static String messages, itemName, onHand;
	public static DialogID dID;
	public static int mID, oID;
	public static boolean flag_Z, flag_X, flag_ESC, z_delay, ESC_delay;
	public static boolean isSleepy, isHungry, isStinky, isSick, isUnhappy;
	public static boolean isStop = false;
	public HUD hud;
	public DisplayDialog dd;

	//Player's last position in World Map
	public static float last_Xpos, last_Ypos;
	
	//Player's Attribute Points
	public int strength, intelligence, agility, vitality, stamina, luck, goodwill;
	public char gender;
	
	private int seconds;
	private Animation animUp, animDown, animLeft, animRight, resting, sleeping;
	
	public Player(Handler handler, HUD hud, DisplayDialog dd, float x, float y) {
		super(handler, x, y, DynamicEntity.DEFAULT_W, DynamicEntity.DEFAULT_H, EntityID.Player, MapAssignment.NotRemovable);
		this.hud = hud; this.dd = dd;
		bounds.x = 16;
		bounds.y = 40;
		bounds.width = 32;
		bounds.height = 21;
		condition = false;
		onHand = "Nothing"; //Player does not hold anything.
		
		//Player facing flag
		td = true; tu = false; tl = false; tr = false;
			
		/*Player action flags*/ canMove = true; asleep = false; isTired = false; Examining = false; pickingItem = false; moving = false; eating = false;
		/*Player status flags*/ isSleepy = false; isHungry = false; isStinky = false; isSick = false; isUnhappy = false;
		/*button flags*/ flag_Z = false; flag_X = false; flag_ESC = false; 
		/*button delays*/ z_delay = false; ESC_delay = true;
		/*state flags*/ paused = false; menu = false; seconds = 225; 
		/*dialog flags*/ messages = ""; displayDialog = false; mID = 0; oID = 0;
		walkingAnimation();
		resting = new Animation(300, Assets.player_M_tired); 
		sleeping = new Animation(300, Assets.player_M_sleeping);
	}
	
	public static void resetAll() {
		mID = 0; oID = 0; condition = false;
	}
	
	private void walkingAnimation() {
		animUp = new Animation(seconds, Assets.player_M_up);
		animDown = new Animation(seconds, Assets.player_M_down);
		animLeft = new Animation(seconds, Assets.player_M_left);
		animRight = new Animation(seconds, Assets.player_M_right);
	}
	
	private void pauseTheGame() {
		if(!handler.getKeyManager().button_ESC) flag_ESC = false;
		if(flag_ESC) return;
		if(handler.getKeyManager().button_ESC) {
			if(!paused) { if(ESC_delay) SoundEffect.Pause.play(); paused = true; displayDialog = true; ESC_delay = true; }
			else { paused = false; SoundEffect.Cancel.play(); }
			flag_ESC = true; return;
		}
	}
		
	private void checkExamine() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle er = new Rectangle();
		int erSize = 20;
		er.width = erSize; er.height = erSize;
			
		if(dd.getqBox().isEndPrint()) dd.getqBox().tick();
		if(!handler.getKeyManager().button_Z) flag_Z = false;
		if(flag_Z) return;
		
		if(handler.getKeyManager().button_Z) {
			if(z_delay) { z_delay = false; return; }
			flag_Z = true;
			pickingItem = false;
			
			if(tu){ er.x = cb.x + cb.width / 2 - erSize / 2; er.y = cb.y - erSize; }
			else if(td){ er.x = cb.x + cb.width / 2 - erSize / 2; er.y = cb.y + cb.height; }
			else if(tl){ er.x = cb.x - erSize; er.y = cb.y + cb.height / 2 - erSize / 2 ; }
			else if(tr){ er.x = cb.x + cb.width; er.y = cb.y + cb.height / 2 - erSize / 2 ; }
			else { flag_Z = false; return; }
			
			if(Examining && dID != DialogID.question) {
				if(!dd.getdBox().isEndPrint() && !dd.getiBox().isEndPrint() && !dd.getmBox().isEndPrint() && !dd.getNpcBox().isEndPrint() && !dd.getnBox().isEndPrint() && !dd.getqBox().isEndPrint()) return;
				dd.getdBox().setEndPrint(false); dd.getiBox().setEndPrint(false); dd.getmBox().setEndPrint(false);  
				dd.getnBox().setEndPrint(false); dd.getNpcBox().setEndPrint(false); dd.getqBox().setEndPrint(false);
				for(Entity e: handler.getWorld().getEntityManager().entities) if(e.getCollisionBounds(0, 0).intersects(er)) e.resetOriginalState();
				Examining = false; canMove = true; displayDialog = false; messages = ""; Player.dID = DialogID.empty;
				return;
			}	
			
			if(!z_delay) pickItem();
			z_delay = false;
			
			if(pickingItem) return;
		} else { flag_Z = false; return; }
		
		examineBox = er;
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) continue;
			if(e.getCollisionBounds(0, 0).intersects(er)) {
				e.examine();
				if(e.getID() == EntityID.Wall) continue;
				displayDialog = true;
				Examining = true;
				if(e.getID() == EntityID.Barrier)  Examining = false; 
				if(dID == DialogID.empty) Examining = false;
				if(!handler.getKeyManager().button_Z) flag_Z = false;
			}
		}
	}
	
	private void pickItem() {
		if(Item.checkItemCollisions(handler, 0, 0, this)) {
			String article;
			int index = Item.getIndexFromCollisions(handler,0, 0, this);
			if(handler.getWorld().getItemManager().uniqueItemID.size() <= 30) {
				for(Item i : handler.getWorld().getItemManager().items) {
					if(handler.getWorld().getItemManager().items.indexOf(i) == index) {
						SoundEffect.PickUp.play();
						handler.getWorld().getItemManager().addItemToInventory(i);
						i.setPicked_up(true); itemName = i.getItem_name();										
						for(Item i2 : handler.getWorld().getItemManager().uniqueItemID) {
							System.out.println(i2 + " " + i2.getItem_name() + " " + i2.getCount());
						}
					}
				}
				switch(itemName.charAt(0)) {
				case 'A': case 'a': case 'E': case 'e': case 'I': case 'i': case 'O': case 'o': case 'U': case 'u':
					article = "an"; break;
				default: article = "a";
				}
				messages = "You picked up " + article + " " + itemName;
				dID = DialogID.item;
				displayDialog = true;
				Examining = true; pickingItem = true;
				flag_Z = true; 
			}
			else {
				messages = "You cannot carry anymore.";
				dID = DialogID.item;
				displayDialog = true;
				Examining = true; pickingItem = true;
				flag_Z = true; 
			}
		}
	}
	
	
	public void tick() {
		if (!menu) pauseTheGame();
		if(!paused) {
			if(!isStop) {
				if(isTired || Examining || eating) canMove = false;
				else canMove = true;
					
				//Animations
				animUp.tick();
				animDown.tick();
				animLeft.tick();
				animRight.tick();
				resting.tick();
				sleeping.tick();
					
				//Movements
				getInput();
				move();
				handler.getGameCamera().centerOnEntity(this);
				checkExamine();
				this.x = handler.clamp((int)this.x, -15, (handler.getWorld().getWidth() * Tile.t_Width) - 45);
				this.y = handler.clamp((int)this.y, -15, (handler.getWorld().getHeight() * Tile.t_Height) - 45);
			}
		}
	}
	
	private void getInput() {
		xVel = 0; yVel = 0;
		if(isTired) { running = false; }
		if(dd.getqBox().isEndPrint()) return;
		
		if(handler.getKeyManager().up && canMove && !eating && !asleep) { isRunning(); yVel = -speed; tu = true; td = false; tl = false; tr = false; moving = true;}
		else if(handler.getKeyManager().down && canMove && !eating && !asleep) { isRunning(); yVel = speed; td = true; tu = false; tl = false; tr = false; moving = true;}
		else if(handler.getKeyManager().left && canMove && !eating && !asleep) { isRunning(); xVel = -speed; tl = true; td = false; tu = false; tr = false; moving = true;}
		else if(handler.getKeyManager().right && canMove && !eating && !asleep) { isRunning(); xVel = speed; tr = true; td = false; tl = false; tu = false; moving = true;}
		else if(canMove) running = false;
			
		if(!handler.getKeyManager().up && !handler.getKeyManager().down && !handler.getKeyManager().left && !handler.getKeyManager().right) moving = false;
		
	}
	
	private void isRunning() {
		speed = DEFAULT_S; seconds = 225; running = false; changeAnimationSpeed();
		if(isSick || isHungry) return;
		
		seconds = 0;
		if(handler.getKeyManager().button_X) { this.speed = 5.5f; seconds = 100; running = true;  changeAnimationSpeed(); }
		else { speed = DEFAULT_S; seconds = 225; running = false; changeAnimationSpeed(); }
	}
	
	private void changeAnimationSpeed() {
		animUp.setSpeed(seconds); animDown.setSpeed(seconds); animLeft.setSpeed(seconds); animRight.setSpeed(seconds);
	}

	public void render(Graphics g) {
		if(isHungry || isSleepy || isStinky || isSick || isUnhappy) {
			if(isSick) g.drawImage(Assets.stat_bubble[2], (int)((x - handler.getGameCamera().getxOffset()) + 40), (int)((y - handler.getGameCamera().getyOffset()) - 10), DEFAULT_W/2, DEFAULT_H/2, null);
			else if(isSleepy && !asleep) g.drawImage(Assets.stat_bubble[1], (int)((x - handler.getGameCamera().getxOffset()) + 40), (int)((y - handler.getGameCamera().getyOffset()) - 10), DEFAULT_W/2, DEFAULT_H/2, null);
			else if(isHungry) g.drawImage(Assets.stat_bubble[0], (int)((x - handler.getGameCamera().getxOffset()) + 40), (int)((y - handler.getGameCamera().getyOffset()) - 10), DEFAULT_W/2, DEFAULT_H/2, null);
			else if(isStinky) g.drawImage(Assets.stat_bubble[3], (int)((x - handler.getGameCamera().getxOffset()) + 40), (int)((y - handler.getGameCamera().getyOffset()) - 10), DEFAULT_W/2, DEFAULT_H/2, null);
			else if(isUnhappy) g.drawImage(Assets.stat_bubble[4], (int)((x - handler.getGameCamera().getxOffset()) + 40), (int)((y - handler.getGameCamera().getyOffset()) - 10), DEFAULT_W/2, DEFAULT_H/2, null);
		}
		if(asleep) g.drawImage(sleeping.getCurrentFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), DEFAULT_W, DEFAULT_H, null);
		else if(isTired) g.drawImage(resting.getCurrentFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), DEFAULT_W, DEFAULT_H, null);
		else {
			if(tu) g.drawImage(upAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), DEFAULT_W, DEFAULT_H, null);
			if(tl) g.drawImage(leftAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), DEFAULT_W, DEFAULT_H, null);
			if(tr) g.drawImage(rightAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), DEFAULT_W, DEFAULT_H, null);
			if(td) g.drawImage(downAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), DEFAULT_W, DEFAULT_H, null);
		}
	}
	
	public void examine() {
		
	}
	
	private BufferedImage upAnimationFrame() {
		if(yVel < 0) return animUp.getCurrentFrame();
		else {
			if(isSick) return resting.getCurrentFrame();
			else return Assets.player_M_faceUp;
		}
	}
	
	private BufferedImage downAnimationFrame() {
		if(yVel > 0) return animDown.getCurrentFrame();
		else {
			if(isSick) return resting.getCurrentFrame();
			else return Assets.player_M_faceDown;
		}
	}
	
	private BufferedImage leftAnimationFrame() {
		if(xVel < 0) return animLeft.getCurrentFrame();
		else {
			if(isSick) return resting.getCurrentFrame();
			else return Assets.player_M_left[0];
		}
	}
	
	private BufferedImage rightAnimationFrame() {
		if(xVel > 0) return animRight.getCurrentFrame();
		else {
			if(isSick) return resting.getCurrentFrame();
			else return Assets.player_M_right[0];
		}
	}

	public void resetOriginalState() {
		
	}

	public Entity clone() {
		return null;
	}

}
