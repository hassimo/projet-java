package fr.univ.evry.util.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.univ.evry.factory.Offre;
import fr.univ.evry.util.panes.SaisieOffreStagePane;
import fr.univ.evry.util.panes.Window;

public class SaisieOffreStageListener implements ActionListener {

	private Window window;
	private String action;
	private SaisieOffreStagePane pane;
	
	public SaisieOffreStageListener(Window window, SaisieOffreStagePane saisieOffreStagePane, String action) {
		this.window = window;
		this.pane = saisieOffreStagePane;
		this.action = action;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Offre offer = new Offre(null, pane.getNomBox().getSelectedItem().toString(), pane.getLibelleField().getText(), "Description", pane.getDomaineBox().getSelectedItem().toString(), pane.getDateDebField().getText(), pane.getDureeField().getText(), pane.getPathField().getText(), "oui", pane.getEmailField().getText());
		window.performAction(action, offer);
	}
}
