package fr.univ.evry.util.panes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.univ.evry.util.actions.GestionOffreStageListener;
import fr.univ.evry.util.actions.LoginListener;

public class LoginPane {
	/**
	 * 
	 */
	
	private Window window;
	
	private JLabel topLabel = new JLabel("Connectez-vous");
	
	private JLabel nomLabel = new JLabel("Nom  ");
	private JTextField nomField = new JTextField("", 15);
	
	private JLabel prenomLabel = new JLabel("Prenom  ");
	private JTextField prenomField = new JTextField("", 15);
	
	private JLabel emailLabel = new JLabel("Email  ");
	private JTextField emailField = new JTextField("", 15);
	
	private JLabel passLabel = new JLabel("Mot de passe  ");
	private JPasswordField passField = new JPasswordField("", 15);
	
	private JButton connecter = new JButton("Se connecter");
	private JButton signup = new JButton("Inscription");
	private JButton annuler = new JButton("Fermer");
	
	public LoginPane(Window window) {
		this.window = window;
		this.addActionListeners();
	}
	
	
	public JPanel execute() {
		JPanel container = new JPanel();
		container.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 1;
	    gbc.gridy = 0;
	    topLabel.setFont (topLabel.getFont().deriveFont (25.0f));
		container.add(topLabel, gbc);

		gbc.gridx = 0;
	    gbc.gridy = 3;
	    container.add(emailLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 3;
	    container.add(emailField, gbc);
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    container.add(passLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 4;
	    container.add(passField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    container.add(connecter, gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    container.add(signup, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 5;
	    container.add(annuler, gbc);
	    
		return container;
	}
	
	
	public JTextField getNomField() {
		return nomField;
	}


	public JTextField getPrenomField() {
		return prenomField;
	}


	public JTextField getEmailField() {
		return emailField;
	}


	public JTextField getPassField() {
		return passField;
	}


	public void addActionListeners() {
		connecter.addActionListener(new LoginListener(window, this, "login"));
		signup.addActionListener(new GestionOffreStageListener(window, "showSignupPane"));
		annuler.addActionListener(new GestionOffreStageListener(window, "exit"));
	}
	
}
