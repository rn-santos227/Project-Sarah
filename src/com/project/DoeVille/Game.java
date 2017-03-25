package com.project.Doeville;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.project.Doeville.display.Display;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.gfx.Backgrounds;
import com.project.Doeville.gfx.Components;
import com.project.Doeville.gfx.GameCamera;
import com.project.Doeville.gfx.ItemAssets;
import com.project.Doeville.gfx.LoadingScreen;
import com.project.Doeville.gfx.NPCSprites;
import com.project.Doeville.gfx.PlayerSprites;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.input.KeyManager;
import com.project.Doeville.music.BGM;
import com.project.Doeville.music.Playlist;
import com.project.Doeville.saves.Save;
import com.project.Doeville.sounds.SoundEffect;
import com.project.Doeville.states.GameState;
import com.project.Doeville.states.LoadState;
import com.project.Doeville.states.MenuState;
import com.project.Doeville.states.SaveState;
import com.project.Doeville.states.SettingState;
import com.project.Doeville.states.State;
import com.project.Doeville.utils.FontFactory;

public class Game implements Runnable {
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	private State saveState;
	private State loadState;
	private State settingState;
	
	private Handler handler;
	private KeyManager keyManager;
	private GameCamera gameCamera;
	private Transition tran;
	private LoadingScreen loadingScreen;
	private Save save;
	
	private int normal;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;	
		keyManager = new KeyManager();
	}
	
	private void init() {
		handler = new Handler(this);
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);;		
		Assets.init();
		Backgrounds.init();
		Components.init();
		PlayerSprites.init();
		NPCSprites.init();
		ItemAssets.init();
		Playlist.init();
		
		
		SoundEffect.init();		
		SoundEffect.volume = SoundEffect.Volume.MEDIUM;
		tran = new Transition(handler);
		loadingScreen = new LoadingScreen(handler);
		handler.setFF(new FontFactory());
		
		gameCamera = new GameCamera(handler, 0, 0);	
		
		saveState = new SaveState(handler, loadingScreen, tran);
		loadState = new LoadState(handler, loadingScreen, tran);
		settingState = new SettingState(handler, tran);
		gameState = new GameState(handler, loadingScreen, tran, save);
		menuState = new MenuState(handler, loadingScreen, tran, saveState, save);


		State.setState(menuState);
	}
	
	private void tick() {
		keyManager.tick();
		if(State.getState() != null) State.getState().tick(); 
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null) State.getState().render(g); 
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int frames = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) { 
				tick(); 
				render();
				frames++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("FPS: " + frames);
				normal = frames;
				frames = 0;
				timer = 0;
			}
		}		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public synchronized void start() {
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public State getGameState() {
		return gameState;
	}

	public State getMenuState() {
		return menuState;
	}

	public State getSaveState() {
		return saveState;
	}

	public State getLoadState() {
		return loadState;
	}

	public State getSettingState() {
		return settingState;
	}
	
	public int getNormal() {
		return normal;
	}

}
