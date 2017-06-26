package fr.univ.evry.util.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import fr.univ.evry.factory.Compte;
import fr.univ.evry.util.panes.SignupPane;
import fr.univ.evry.util.panes.Window;

public class SignupListener implements ActionListener{

	private Window window;
	private String action;
	private SignupPane pane;
	
	public SignupListener(Window window, SignupPane signupPane, String action) {
		this.window = window;
		this.pane = signupPane;
		this.action = action;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Compte compte = new Compte(
							pane.getNomField().getText(), 
							pane.getPrenomField().getText(), 
							pane.getEmailField().getText(), 
							pane.getPassField().getText(), 
							pane.getUserTypeCombo().getSelectedItem().toString()
						);
		window.performAction(action, compte);		
	}

}
