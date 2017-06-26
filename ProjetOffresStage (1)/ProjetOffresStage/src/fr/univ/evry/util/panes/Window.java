package fr.univ.evry.util.panes;

import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.univ.evry.dao.EntrepriseDAO;
import fr.univ.evry.dao.StageDAO;
import fr.univ.evry.dao.UserDAO;
import fr.univ.evry.factory.Compte;


public class Window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	/**
	 * Les références des panes
	 */
	private LoginPane loginPane;
	private GestionOffreStagePane gestionOffreStagePane;
	private CreationEntreprisePane creationEntreprisePane;
	private SaisieOffreStagePane saisieOffreStagePane;
	private ConsultationOffresStagePane consultationOffresStagePane;
	private SignupPane signupPane;
	private String userTypeTmp;
	/**
	 * Les références du DAO
	 */
	private EntrepriseDAO entrepriseDao;
	private StageDAO stageDao;
	private UserDAO userDAO;
	
	public Window(EntrepriseDAO entrepriseDao, StageDAO stageDao, UserDAO userDAO) {
		this.initPanes();
		this.initDao(entrepriseDao, stageDao, userDAO);
		
		this.setTitle("Gestion offre de stage");
		this.setSize(760, 370);
		this.setLocationRelativeTo(null);               
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.add(gestionOffreStagePane.execute());
		this.add(loginPane.execute());
	    
		this.setVisible(true);
	}
	
	public void performAction(String action, Object o) {
		System.out.println("[Window#performAction] triggered ! -- action : " + action);

		if (action.equals("exit")) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (action.equals("backToHomeScreen")) {
			this.setContentPane(this.gestionOffreStagePane.execute());
			this.invalidate();
			this.validate();
		} else if (action.equals("CreateEnterpriseScreen")) {
			this.setContentPane(this.creationEntreprisePane.execute());
			this.invalidate();
			this.validate();
		} else if (action.equals("GrabOfferScreen")) {
			this.setContentPane(this.saisieOffreStagePane.execute());
			this.invalidate();
			this.validate();			
		} else if (action.equals("ConsultofferScreen")) {
			this.setContentPane(this.consultationOffresStagePane.execute(this.userTypeTmp));
			this.consultationOffresStagePane.updateData(this.stageDao.find( 0 ));
			this.invalidate();
			this.validate();			
		} else if (action.equals("createNewEnterprise")) {
			try {
				entrepriseDao.add(o);
				JOptionPane.showMessageDialog(null, "Entreprise ajouté");
				this.setContentPane(this.gestionOffreStagePane.execute());
				this.invalidate();
				this.validate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (action.equals("createNewOffer")) {
			try {
				stageDao.add(o);
				JOptionPane.showMessageDialog(null, "Offre ajouté");
				
				this.setContentPane(this.gestionOffreStagePane.execute());
				this.invalidate();
				this.validate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (action.equals("login")) {
			String userType = this.userDAO.connect(o);
			if (userType != null) {
				this.userTypeTmp = userType;
				this.setContentPane(this.gestionOffreStagePane.execute(userType));
				this.invalidate();
				this.validate();
			} else {
				JOptionPane.showMessageDialog(null, "Utilisateur et/ou Mot de passe incorrecte");
			}
		} else if (action.equals("deconnect")) {
			this.setContentPane(this.loginPane.execute());
			this.invalidate();
			this.validate();
		} else if (action.equals("showSignupPane")) {
			this.setContentPane(this.signupPane.execute());
			this.invalidate();
			this.validate();
		} else if (action.equals("signup")) {
			Compte tmpCompte = (Compte) o;
			boolean status = this.userDAO.signup(tmpCompte.getNom(), tmpCompte.getPrenom(), tmpCompte.getUser(), tmpCompte.getMdp(), tmpCompte.getType());
			if (status) {
				JOptionPane.showMessageDialog(null, "Inscription réussi ! Vous pouver vous connecter.");
				tmpCompte = null;
				this.setContentPane(loginPane.execute());
				this.invalidate();
				this.validate();
			} else {
				JOptionPane.showMessageDialog(null, "Un utilisateur est déjà inscript avec le même mot de passe");
			}
		} else if (action.equals("backToLoginScreen")) {
			this.setContentPane(this.loginPane.execute());
			this.invalidate();
			this.validate();
		}  else if (action.equals("gestionOffreStagePane")) {
			this.setContentPane(this.gestionOffreStagePane.execute(this.userTypeTmp));
			this.invalidate();
			this.validate();
		} else if (action.equals("supprimerOffre")) {
			this.stageDao.deleteOffre(o);
			if (1 == 1 ) {
			
				JOptionPane.showMessageDialog(null, "Offre supprimée");
			} else {
				JOptionPane.showMessageDialog(null, "Une erreur est sourvenu...");
			}
			
			this.setContentPane(this.consultationOffresStagePane.execute(this.userTypeTmp));
			this.consultationOffresStagePane.updateData(this.stageDao.find( 0 ));
			this.invalidate();
			this.validate();
		}
		
		
		
		
	}
	
	public void initPanes() {
		this.loginPane = new LoginPane(this);
		this.gestionOffreStagePane = new GestionOffreStagePane(this);
		this.creationEntreprisePane = new CreationEntreprisePane(this);
		this.saisieOffreStagePane = new SaisieOffreStagePane(this);
		this.consultationOffresStagePane = new ConsultationOffresStagePane(this);
		this.signupPane = new SignupPane(this);
	}
	
	public void initDao(EntrepriseDAO entrepriseDao, StageDAO stageDao,UserDAO userDAO) {
		this.entrepriseDao = entrepriseDao;
		this.stageDao = stageDao;
		this.userDAO = userDAO;
		
		this.userTypeTmp = new String("");
	}
	
}
