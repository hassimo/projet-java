package fr.univ.evry.util.panes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.univ.evry.factory.Offre;
import fr.univ.evry.util.actions.BackButtonListener;
import fr.univ.evry.util.actions.ConsultOfferListener;

public class ConsultationOffresStagePane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8924479167507341550L;
	
	private Window window;
	private int actualPage;
	
	private JTextField offerId = new JTextField("", 15);
	
	private JLabel topLabel = new JLabel("Consultation des offres de stage");

	private JLabel nameLabel = new JLabel("Nom de l'entreprise  ");
	private JTextField nameField = new JTextField("", 15);

	private JLabel countryLabel = new JLabel("Adresse (Ville)  ");
	private JTextField countryField = new JTextField("", 15);

	private JLabel emailLabel = new JLabel("Mail de contact");
	private JTextField emailField = new JTextField("", 15);

	private JLabel domaineLabel = new JLabel("Domaine offre");
	private JTextField domaineField = new JTextField("", 15);

	private JLabel libelleLabel = new JLabel("Libellé de l'offre  ");
	private JTextField libelleField = new JTextField("", 15);

	private JLabel dateDebLabel = new JLabel("Date de début du stage  ");
	private JTextField dateDebField = new JTextField("", 15);

	private JLabel dureeLabel = new JLabel("Durée  ");
	private JTextField dureeField = new JTextField("", 15);	

	private JLabel descriptifbLabel = new JLabel("Date de début du stage  ");
	private JTextArea descriptifField = new JTextArea(5, 20);
	
	private JButton precedent = new JButton("Précédent");
	private JButton suivant = new JButton("Suivant");
	private JButton postuler = new JButton("Postuler");
	private JButton fermer = new JButton("Retour");
	private JButton supprimer = new JButton("Supprimer offre");

	
	public ConsultationOffresStagePane(Window window) {
		this.window = window;
		this.actualPage = 0;
		this.addActionListeners();
	}
	
	public JPanel execute(String type) {
		JPanel container = new JPanel();
		container.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 2;
	    gbc.gridy = 0;
	    topLabel.setFont (topLabel.getFont().deriveFont (25.0f));
		container.add(topLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		container.add(nameLabel, gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		container.add(nameField, gbc);

		/*gbc.gridx = 1;
		gbc.gridy = 2;
		container.add(countryLabel, gbc); 
		gbc.gridx = 3;
		gbc.gridy = 2;
		container.add(countryField, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		container.add(emailLabel, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3;
		container.add(emailField, gbc);*/

		gbc.gridx = 1;
		gbc.gridy = 4;
		container.add(domaineLabel, gbc);
		gbc.gridx = 3;
		gbc.gridy = 4;
		container.add(domaineField, gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		container.add(libelleLabel, gbc);
		gbc.gridx = 3;
		gbc.gridy = 5;
		container.add(libelleField, gbc);  

		gbc.gridx = 1;
		gbc.gridy = 6;
		container.add(dateDebLabel, gbc);
		gbc.gridx = 3;
		gbc.gridy = 6;
		container.add(dateDebField, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		container.add(dureeLabel, gbc);
		gbc.gridx = 3;
		gbc.gridy = 7;
		container.add(dureeField, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		container.add(emailLabel, gbc);
		gbc.gridx = 3;
		gbc.gridy = 8;
		container.add(emailField, gbc);
		

		/*gbc.gridx = 1;
		gbc.gridy = 9;
		container.add(descriptifbLabel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 9;
		container.add(descriptifField, gbc);*/

		gbc.gridx = 1;
		gbc.gridy = 10;
		container.add(precedent, gbc);
		gbc.gridx = 2;
		gbc.gridy = 10;
		container.add(suivant, gbc);
		gbc.gridx = 1;
		gbc.gridy = 11;
		container.add(postuler, gbc);
		gbc.gridx = 2;
		gbc.gridy = 11;
		container.add(fermer, gbc);
		
		if (type.equals("admin")) {
			gbc.gridx = 3;
			gbc.gridy = 10;
			container.add(supprimer, gbc);
		}
		
		return container;
	}
	
	public void addActionListeners() {
		fermer.addActionListener(new BackButtonListener(window, "gestionOffreStagePane"));
		precedent.addActionListener(new ConsultOfferListener(window, this, "offreStagePrecedent"));
		suivant.addActionListener(new ConsultOfferListener(window, this, "offreStageSuivant"));
		postuler.addActionListener(new ConsultOfferListener(window, this, "postuler"));
		supprimer.addActionListener(new ConsultOfferListener(window, this, "supprimerOffre"));
	}
	
	public void updateData (Object o)
	{
		Offre offre = (Offre) o;
		if (o != null) {
			offerId.setText(offre.getIdOffre());
			nameField.setText(offre.getEntreprise());  
			domaineField.setText(offre.getDomaine());   
			libelleField.setText(offre.getLibelle());  
			descriptifField.setText(offre.getDescriptif());
			dateDebField.setText(offre.getDateDebut());
			dureeField.setText(offre.getDuree());
			emailField.setText(offre.getEntEmail());
		} 
	}
	
	
	public void nextPage() {
		this.actualPage += 1;
		System.out.println("next , val : " + this.actualPage);
	}
	
	public void lastPage() {
	
			this.actualPage -= 1;
		
	}
	
	/**
	 * @return the actualPage
	 */
	public int getActualPage() {
		return actualPage;
	}

	public JTextField getEmailField() {
		return emailField;
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

	public JLabel getCountryLabel() {
		return countryLabel;
	}

	public JTextField getCountryField() {
		return countryField;
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public JLabel getDomaineLabel() {
		return domaineLabel;
	}

	public JTextField getDomaineField() {
		return domaineField;
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

	public JLabel getDescriptifbLabel() {
		return descriptifbLabel;
	}

	public JTextArea getDescriptifField() {
		return descriptifField;
	}

	public JButton getPrecedent() {
		return precedent;
	}

	public JButton getSuivant() {
		return suivant;
	}

	public JButton getPostuler() {
		return postuler;
	}

	public JButton getFermer() {
		return fermer;
	}

	public JTextField getOfferId() {
		return offerId;
	}

	public void setOfferId(JTextField offerId) {
		this.offerId = offerId;
	}
}
