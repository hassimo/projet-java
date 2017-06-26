package fr.univ.evry.util.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.univ.evry.factory.Entreprise;
import fr.univ.evry.util.panes.CreationEntreprisePane;
import fr.univ.evry.util.panes.Window;

public class CreateEnterpriseListener implements ActionListener {
	private Window window;
	private String action;
	private CreationEntreprisePane pane;
	
	public CreateEnterpriseListener(Window window, CreationEntreprisePane pane, String action) {
		this.window = window;
		this.pane = pane;
		this.action = action;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Entreprise entreprise = new Entreprise("", pane.getNameField().getText(), pane.getCountryField().getText(), pane.getAdressField().getText(), pane.getPostalField().getText(), pane.getTelField().getText(), pane.getSecteurField().getText(), pane.getEmailField().getText());
		window.performAction(action, entreprise);
	}
}
