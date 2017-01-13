package com.project.Doeville.dialogs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import com.project.Doeville.Handler;
import com.project.Doeville.dialogs.list.AlertDialog;
import com.project.Doeville.dialogs.list.BookDialog;
import com.project.Doeville.dialogs.list.InformationDialog;
import com.project.Doeville.dialogs.list.ItemDialog;
import com.project.Doeville.dialogs.list.MessageDialog;
import com.project.Doeville.dialogs.list.NPCDialog;
import com.project.Doeville.dialogs.list.PausedDialog;
import com.project.Doeville.dialogs.list.QuestionDialog;
import com.project.Doeville.dialogs.list.VendingMachineDialog;
import com.project.Doeville.dialogs.list.NotificationDialog;
import com.project.Doeville.dialogs.list.NumericDialog;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Transition;
import com.project.Doeville.hud.HUD;

public class DisplayDialog {
	
	private AlertDialog aBox;
	private BookDialog bBox;
	private InformationDialog dBox;
	private ItemDialog iBox;
	private MessageDialog mBox;
	private NotificationDialog nBox;
	private NPCDialog npcBox;
	private NumericDialog numBox;
	private PausedDialog pBox;
	private QuestionDialog qBox;
	private VendingMachineDialog vmBox;
	
	public DisplayDialog(Handler handler, HUD hud, Transition tran) {
		aBox = new AlertDialog(handler);
		bBox = new BookDialog(handler);
		dBox = new InformationDialog(handler);
		iBox = new ItemDialog(handler);
		mBox = new MessageDialog(handler);
		nBox = new NotificationDialog(handler);
		npcBox = new NPCDialog(handler);
		numBox = new NumericDialog(handler);
		pBox = new PausedDialog(handler, hud, tran);
		qBox = new QuestionDialog(handler);
		vmBox = new VendingMachineDialog(handler, hud);
	}
	
	public void tick() {
		if(Player.displayDialog) {
			if(Player.dID == DialogID.alert) { aBox.tick(); }
			else if(Player.dID == DialogID.book) { bBox.tick(); }
			else if(Player.dID == DialogID.information) { dBox.tick(); }
			else if(Player.dID == DialogID.item) { iBox.tick(); }
			else if(Player.dID == DialogID.message) { mBox.tick(); }
			else if(Player.dID == DialogID.notification) { nBox.tick(); }
			else if(Player.dID == DialogID.npc) { npcBox.tick(); }
			else if(Player.dID == DialogID.numeric) { numBox.tick(); }
			else if(Player.dID == DialogID.question) { qBox.tick(); }
			else if(Player.dID == DialogID.vending_machine) { vmBox.tick(); }
		}
		else { 
			bBox.content = ""; bBox.index = 0; bBox.z_delay = true;
			dBox.content = ""; dBox.index = 0; dBox.z_delay = true;
			iBox.content = ""; iBox.index = 0; iBox.z_delay = true;
			mBox.content = ""; mBox.index = 0; mBox.z_delay = true;
			nBox.content = ""; nBox.index  = 0; nBox.z_delay = true;
			npcBox.content = ""; npcBox.index = 0; npcBox.z_delay = true;
			numBox.z_delay = true;
			qBox.content = ""; qBox.index = 0; qBox.clearOptions(); 
			vmBox.index = 0; vmBox.z_delay = true;
		}
		if(Player.paused) {
			pBox.tick();
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(Player.displayDialog) {
			if(Player.dID == DialogID.alert) { aBox.render(g); }
			else if(Player.dID == DialogID.book) { bBox.render(g); }
			else if(Player.dID == DialogID.information) { dBox.render(g); }
			else if(Player.dID == DialogID.item) { iBox.render(g); }
			else if(Player.dID == DialogID.message) { mBox.render(g); }
			else if(Player.dID == DialogID.notification) { nBox.render(g); }
			else if(Player.dID == DialogID.npc) { npcBox.render(g); }
			else if(Player.dID == DialogID.numeric) { numBox.render(g); }
			else if(Player.dID == DialogID.question) { qBox.render(g); }
			else if(Player.dID == DialogID.vending_machine) { vmBox.render(g);; }
		}
		if(Player.paused) {
			if(Player.paused) pBox.render(g);
			else g.dispose();
		}
	}

	public AlertDialog getaBox() {
		return aBox;
	}
	
	public BookDialog getbBox() {
		return bBox;
	}

	public InformationDialog getdBox() {
		return dBox;
	}

	public ItemDialog getiBox() {
		return iBox;
	}

	public MessageDialog getmBox() {
		return mBox;
	}

	public NotificationDialog getnBox() {
		return nBox;
	}

	public NPCDialog getNpcBox() {
		return npcBox;
	}
	
	public NumericDialog getNumBox() {
		return numBox;
	}

	public PausedDialog getpBox() {
		return pBox;
	}

	public QuestionDialog getqBox() {
		return qBox;
	}
	
	public VendingMachineDialog getvmBox() {
		return vmBox;
	}
}
