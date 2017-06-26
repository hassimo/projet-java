package fr.univ.evry.util.actions;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.rmi.UnexpectedException;

import fr.univ.evry.dao.StageDAO;
import fr.univ.evry.database.util.DBConnect;
import fr.univ.evry.util.panes.ConsultationOffresStagePane;
import fr.univ.evry.util.panes.Window;

public class ConsultOfferListener implements ActionListener {

	private Window window;
	private String action;
	private StageDAO stageDao;
	private ConsultationOffresStagePane offresPane;
	private int targetPage;
	
	public ConsultOfferListener(Window window, ConsultationOffresStagePane offresPane, String action) {
		this.window = window;
		this.action = action;
		this.stageDao = new StageDAO(new DBConnect());
		this.offresPane = offresPane;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = null;
		if (action.equals("offreStagePrecedent")) {
			this.offresPane.lastPage();
			o = this.stageDao.find( this.offresPane.getActualPage() );
			
			if (o == null) 
				this.offresPane.nextPage();
				
		} else if (action.equals("offreStageSuivant")) {
			this.offresPane.nextPage();
			o = this.stageDao.find( this.offresPane.getActualPage() );
			
			if (o == null) 
				this.offresPane.lastPage();
		} else if (action.equals("postuler")) {
			try {
				Desktop.getDesktop().mail( new URI( "mailto:" + this.offresPane.getEmailField().getText()  ) );
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} else if (action.equals("supprimerOffre")) {
			window.performAction("supprimerOffre", this.offresPane.getOfferId().getText());
		} else {
			try {
				throw new UnexpectedException("Paramètre incorrecte. Comportement inattendu !");
			} catch (UnexpectedException e) {
				e.printStackTrace();
			}
		}
		
		this.offresPane.updateData(o);
	}
}
