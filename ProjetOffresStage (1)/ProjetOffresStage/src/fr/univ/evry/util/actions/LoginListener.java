package fr.univ.evry.util.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.univ.evry.factory.Compte;
import fr.univ.evry.util.panes.LoginPane;
import fr.univ.evry.util.panes.Window;

public class LoginListener implements ActionListener {

	private Window window;
	private String action;
	private LoginPane pane;
	
	public LoginListener(Window window, LoginPane pane, String action) {
		this.window = window;
		this.pane = pane;
		this.action = action;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Compte compte = new Compte(pane.getNomField().getText(), pane.getPrenomField().getText(), pane.getEmailField().getText(), pane.getPassField().getText());
		window.performAction(action, compte);
	}

}
