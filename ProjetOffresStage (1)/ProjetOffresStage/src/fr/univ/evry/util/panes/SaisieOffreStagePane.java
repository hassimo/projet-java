package fr.univ.evry.util.panes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.univ.evry.dao.EntrepriseDAO;
import fr.univ.evry.database.util.DBConnect;
import fr.univ.evry.util.actions.BackButtonListener;
import fr.univ.evry.util.actions.SaisieOffreStageListener;

public class SaisieOffreStagePane extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3863454425945913534L;
	private EntrepriseDAO entrepriseDAO;
	private Window window;
	String[] tabNom;	
	String[] tabDomaine;
	
	private JLabel topLabel = new JLabel("Saisie d'une offre de stage");
	
	private JLabel nomLabel = new JLabel("Nom de l'entreprise  ");
    private JComboBox<String> nomBox;
	
	private JLabel domaineLabel = new JLabel("Domaine de l'offer  ");
	private JComboBox<String> domaineBox;
	
	private JLabel libelleLabel = new JLabel("Libellé de l'offre  ");
	private JTextField libelleField = new JTextField("", 15);
	
	private JLabel dateDebLabel = new JLabel("Date de début du stage  ");
	private JTextField dateDebField = new JTextField("", 15);

	private JLabel dureeLabel = new JLabel("Durée  ");
	private JTextField dureeField = new JTextField("", 15);
	
	private JLabel emailLabel = new JLabel("Email  ");
	private JTextField emailField = new JTextField("", 15);
	
	private JLabel pathLabel = new JLabel("Chemin de stockage de l'offre du stage  ");
	private JTextField pathField = new JTextField("", 15);
	
	private JButton envoyer = new JButton("Envoyer");
	private JButton annuler = new JButton("Annuler");
	
	public SaisieOffreStagePane(Window window) {
		this.window = window;
		this.entrepriseDAO = new EntrepriseDAO(new DBConnect());
		this.tabNom = this.entrepriseDAO.findAllEnt();
		this.tabDomaine = this.entrepriseDAO.findAllDom();
		this.nomBox = new JComboBox<String>(tabNom);
		this.domaineBox = new JComboBox<String>(tabDomaine);
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
	    container.add(nomBox, gbc);
		
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    container.add(domaineLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 2;
	    container.add(domaineBox, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    container.add(libelleLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 3;
	    container.add(libelleField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    container.add(dateDebLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 4;
	    container.add(dateDebField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    container.add(dureeLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 5;
	    container.add(dureeField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    container.add(pathLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 6;
	    container.add(pathField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    container.add(emailLabel, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 7;
	    container.add(emailField, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 8;
	    container.add(envoyer, gbc);
	    gbc.gridx = 2;
	    gbc.gridy = 8;
	    container.add(annuler, gbc);
	    
		return container;
	}
	
	public void addActionListeners() {
		envoyer.addActionListener(new SaisieOffreStageListener(window, this, "createNewOffer"));
		annuler.addActionListener(new BackButtonListener(window, "backToHomeScreen"));
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


	public JComboBox<String> getNomBox() {
		return nomBox;
	}


	public JLabel getDomaineLabel() {
		return domaineLabel;
	}


	public JComboBox<String> getDomaineBox() {
		return domaineBox;
	}


	public JLabel getLibelleLabel() {
		return libelleLabel;
	}


	public JTextField getLibelleField() {
		return libelleField;
	}


	public JLabel getDateDebLabel() {
		return dateDebLabel;
	}


	public JTextField getDateDebField() {
		return dateDebField;
	}


	public JLabel getDureeLabel() {
		return dureeLabel;
	}


	public JTextField getDureeField() {
		return dureeField;
	}


	public JLabel getPathLabel() {
		return pathLabel;
	}


	public JTextField getPathField() {
		return pathField;
	}


	public JButton getEnvoyer() {
		return envoyer;
	}


	public JButton getAnnuler() {
		return annuler;
	}


	public JTextField getEmailField() {
		return emailField;
	}
	
	
}
