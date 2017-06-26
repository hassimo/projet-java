package fr.univ.evry.util.panes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.univ.evry.util.actions.GestionOffreStageListener;

public class GestionOffreStagePane extends JPanel{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 3751348004246732780L;
	
	private Window window;
	
	private JLabel topLabel = new JLabel("Gestion des offres de stages");
	private JButton creerEntreprise = new JButton("Créer une entreprise");
	private JButton saisirOffre = new JButton("Saisir une offre");
	private JButton consulterOffres = new JButton("Consulter les offres");
	private JButton deconnect = new JButton("Déconnexion");

	public GestionOffreStagePane(Window window) {
		this.window = window;
		this.addActionListeners();
	}
	
	public JPanel execute(String type) {
		JPanel container = new JPanel();
		//container.setPreferredSize(new Dimension(800, 450));
		container.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    
	    topLabel.setFont(topLabel.getFont().deriveFont (25.0f));
	    container.add(topLabel, gbc);
	    
	    if (type.equals("admin")) {
	    	gbc.gridx = 0;
	 	    gbc.gridy = 3;
	 	    container.add(creerEntreprise, gbc);
	 		    
	 	    gbc.gridx = 1;
	 	    gbc.gridy = 3;
	 	    container.add(saisirOffre, gbc);
	    }

	    gbc.gridx = 2;
	    gbc.gridy = 3;
	    container.add(consulterOffres, gbc);

	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    container.add(deconnect, gbc);
	    
	    return container;
	}
	
	
	public JPanel execute() {
		JPanel container = new JPanel();
		//container.setPreferredSize(new Dimension(800, 450));
		container.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    
	    topLabel.setFont(topLabel.getFont().deriveFont (25.0f));
	    container.add(topLabel, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    container.add(creerEntreprise, gbc);
		    
	    gbc.gridx = 1;
	    gbc.gridy = 3;
	    container.add(saisirOffre, gbc);

	    gbc.gridx = 2;
	    gbc.gridy = 3;
	    container.add(consulterOffres, gbc);

	    gbc.gridx = 1;
	    gbc.gridy = 5;
	    container.add(deconnect, gbc);
	    
	    return container;
	}
	
	
	public void addActionListeners() {
		creerEntreprise.addActionListener(new GestionOffreStageListener(window, "CreateEnterpriseScreen"));
		saisirOffre.addActionListener(new GestionOffreStageListener(window, "GrabOfferScreen"));
		consulterOffres.addActionListener(new GestionOffreStageListener(window, "ConsultofferScreen"));
		deconnect.addActionListener(new GestionOffreStageListener(window, "deconnect"));
	}
	
}
