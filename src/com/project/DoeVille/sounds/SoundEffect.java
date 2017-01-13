package com.project.Doeville.sounds;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public enum SoundEffect {
	Cancel("sounds/cancel.wav"),
	Confirm("sounds/confirm.wav"),
	CursorMove("sounds/cur_mov.wav"),
	PickUp("sounds/pick_up.wav"),
	Pause("sounds/pause.wav");
	
	public static enum Volume {
		MUTE, LOW, MEDIUM, HIGH;
	}
	
	public static Volume volume = Volume.MEDIUM;
	private Clip clip;
	
	SoundEffect(String soundFileName) {

		try {		
			URL url = this.getClass().getClassLoader().getResource(soundFileName);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			
		} 
		catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
		catch (LineUnavailableException e) { e.printStackTrace(); }	
	}
	
	public void play() {
		if(volume != Volume.MUTE) {
			if(clip.isRunning()) clip.stop();
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(+5.0f); 
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public static void init() {
		values();
	}

}
