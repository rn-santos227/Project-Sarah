package com.project.Doeville.music;

import java.io.IOException;
import java.net.URL;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;


public class BGM {
	public Sequencer midiPlayer;
	public BGM(String midifilename) {
		try {
	      	URL url = this.getClass().getClassLoader().getResource(midifilename);
			Sequence song = MidiSystem.getSequence(url);
	        midiPlayer = MidiSystem.getSequencer();
	        midiPlayer.open();
	        midiPlayer.setSequence(song);
	        midiPlayer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
	        midiPlayer.start();
	        
		} catch (InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} 
	}
}
