package fr.univ.evry.util.panes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.univ.evry.util.actions.GestionOffreStageListener;
import fr.univ.evry.util.actions.SignupListener;

public class SignupPane {

	private Window window;
	
	private JLabel topLabel = new JLabel("Inscription");
	
	private JLabel nomLabel = new JLabel("Nom  ");
	private JTextField nomField = new JTextField("", 15);
	
	private JLabel prenomLabel = new JLabel("Prenom  ");
	private JTextField prenomField = new JTextField("", 15);
	
	private JLabel emailLabel = new JLabel("Email  ");
	private JTextField emailField = new JTextField("", 15);
	
	private JLabel passLabel = new JLabel("Mot de passe  ");
	private JTextField passField = new JTextField("", 15);
	
	String[] options = {"utilisateur", "admin"};
	private JLabel userTypeLabel = new JLabel("Privilège  ");
	private JComboBox<String> userTypeCombo = new JComboBox(options);
	
	
	private JButton signup = new JButton("valider");
	private JButton annuler = new JButton("Annuler");
	
	
	public SignupPane(Window window) {
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
	    gbc.gridy = 1;
	    container.add(nomLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 1;
	    container.add(nomField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    container.add(prenomLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 2;
	    container.add(prenomField, gbc);
	    
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
	    container.add(userTypeLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 5;
	    container.add(userTypeCombo, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    container.add(signup, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 6;
	    container.add(annuler, gbc);
	    
		return container;
	}
	
	
	public Window getWindow() {
		return window;
	}

	public JLabel getTopLabel() {
		return topLabel;
	}

	public JLabel getNomLabel() {
		return nomLabel;
	}

	public JLabel getPrenomLabel() {
		return prenomLabel;
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public JLabel getPassLabel() {
		return passLabel;
	}

	public String[] getOptions() {
		return options;
	}

	public JLabel getUserTypeLabel() {
		return userTypeLabel;
	}

	public JComboBox<String> getUserTypeCombo() {
		return userTypeCombo;
	}

	public JButton getSignup() {
		return signup;
	}

	public JButton getAnnuler() {
		return annuler;
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
		signup.addActionListener(new SignupListener(window, this, "signup"));
		annuler.addActionListener(new GestionOffreStageListener(window, "backToLoginScreen"));
	}
	
}
