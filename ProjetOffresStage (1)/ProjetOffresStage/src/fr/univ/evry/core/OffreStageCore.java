package fr.univ.evry.core;

import fr.univ.evry.dao.EntrepriseDAO;
import fr.univ.evry.dao.StageDAO;
import fr.univ.evry.dao.UserDAO;
import fr.univ.evry.database.util.DBConnect;
import fr.univ.evry.util.panes.Window;

public class OffreStageCore {

	public static void main(String[] args) {
		/**
		 * Connexion initiale � la base de donn�es
		 * Cette variable sera notre r�f�rence de connexion
		 */
		DBConnect dbConnect = new DBConnect();
		
		/**
		 * DAOUtils 
		 */
		EntrepriseDAO entrepriseDao = new EntrepriseDAO(dbConnect);
		StageDAO stageDao = new StageDAO(dbConnect);
		UserDAO userDAO = new UserDAO(dbConnect); 
		
		/**
		 * Build 
		 */
		new Window(entrepriseDao, stageDao, userDAO);
	}

}
