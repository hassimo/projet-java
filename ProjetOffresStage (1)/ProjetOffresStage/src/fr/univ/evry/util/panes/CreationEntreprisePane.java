package fr.univ.evry.util.panes;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.univ.evry.util.actions.BackButtonListener;
import fr.univ.evry.util.actions.CreateEnterpriseListener;

public class CreationEntreprisePane extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3429986541917838499L;
	
	private Window window;
	
	private JLabel topLabel = new JLabel("Création d'une entreprise");
	
	private JLabel nameLabel = new JLabel("Nom de l'entreprise  ");
	private JTextField nameField = new JTextField("", 15);
	
	private JLabel adressLabel = new JLabel("Adresse (Numéro et rue)  ");
	private JTextField adressField = new JTextField("", 15);
	
	private JLabel postalLabel = new JLabel("Adresse (Code postal)  ");
	private JTextField postalField = new JTextField("", 15);

	private JLabel countryLabel = new JLabel("Adresse (Ville)  ");
	private JTextField countryField = new JTextField("", 15);
	
	private JLabel emailLabel = new JLabel("Mail de contact");
	private JTextField emailField = new JTextField("", 15);

	private JLabel telLabel = new JLabel("téléphone de contact");
	private JTextField telField = new JTextField("", 15);
	
	private JLabel secteurLabel = new JLabel("Secteur d'activité");
	private JTextField secteurField = new JTextField("", 15);
	
	private JButton envoyer = new JButton("Envoyer");
	private JButton annuler = new JButton("Annuler");
	
	public CreationEntreprisePane(Window window) {
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
	    container.add(nameLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 1;
	    container.add(nameField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    container.add(adressLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 2;
	    container.add(adressField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    container.add(postalLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 3;
	    container.add(postalField, gbc);
		
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    container.add(countryLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 4;
	    container.add(countryField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    container.add(emailLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 5;
	    container.add(emailField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    container.add(telLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 6;
	    container.add(telField, gbc);		
		
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    container.add(secteurLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 7;
	    container.add(secteurField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 8;
	    container.add(envoyer, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 8;
	    container.add(annuler, gbc);
	    
		return container;
	}
	
	
	public void addActionListeners() {
		envoyer.addActionListener(new CreateEnterpriseListener(window, this, "createNewEnterprise"));
		annuler.addActionListener(new BackButtonListener(window, "backToHomeScreen"));
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Window getWindow() {
		return window;
	}

	public JLabel getTopLabel() {
		return topLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JLabel getAdressLabel() {
		return adressLabel;
	}

	public JTextField getAdressField() {
		return adressField;
	}

	public JLabel getPostalLabel() {
		return postalLabel;
	}

	public JTextField getPostalField() {
		return postalField;
	}

	public JLabel getCountryLabel() {
		return countryLabel;
	}

	public JTextField getCountryField() {
		return countryField;
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public JLabel getTelLabel() {
		return telLabel;
	}

	public JTextField getTelField() {
		return telField;
	}

	public JLabel getSecteurLabel() {
		return secteurLabel;
	}

	public JTextField getSecteurField() {
		return secteurField;
	}

	public JButton getEnvoyer() {
		return envoyer;
	}

	public JButton getAnnuler() {
		return annuler;
	}
	
	
	
}


