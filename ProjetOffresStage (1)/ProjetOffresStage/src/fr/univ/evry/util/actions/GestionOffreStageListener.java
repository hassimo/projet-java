package fr.univ.evry.util.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.univ.evry.util.panes.Window;

public class GestionOffreStageListener implements ActionListener {
	private Window window;
	private String action;
	
	public GestionOffreStageListener(Window window, String action) {
		this.window = window;
		this.action = action;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		window.performAction(action, null);
	}
}
