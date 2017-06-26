package fr.univ.evry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import fr.univ.evry.database.util.DBConnect;
import fr.univ.evry.factory.Compte;
import fr.univ.evry.factory.Offre;

public class StageDAO implements DAOUtil {
	private DBConnect dbConnect;
	
	public StageDAO(DBConnect dbConnect) {
		this.dbConnect = dbConnect;
	}
	
	@Override
	public void add(Object o) throws SQLException {
		Connection connect= dbConnect.getConnection();
		System.out.println("[StageDAO#add] object : " + o);
		
		PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO stage VALUES (null, ?, ?, ?, ?, ?, ?, 1, ?)");

		preparedStatement.setString(1, ((Offre) o).getDomaine());
		preparedStatement.setString(2, ((Offre) o).getLibelle());
		preparedStatement.setString(3, ((Offre) o).getDateDebut());
		preparedStatement.setString(4, ((Offre) o).getDuree());
		preparedStatement.setString(5, ((Offre) o).getChemin());
		preparedStatement.setString(6, ((Offre) o).getDescriptif());
		preparedStatement.setString(7, ((Offre) o).getEntEmail());
		
		preparedStatement.executeUpdate();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object find(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object find(int position) {
		Connection connect= dbConnect.getConnection();
		Offre stage = null;  
		
		try {
			System.out.println("position : " + position);
			position = (position < 0 ) ? 0 : position;
			PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM stage LIMIT "+ position +", 1");
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.next()) {
				
				PreparedStatement preparedStatementEnt = connect.prepareStatement("SELECT ent_nom FROM entreprise WHERE ent_id = "+ result.getString("stage_ent_id") +";");
				ResultSet resultEnt = preparedStatementEnt.executeQuery();
				if (resultEnt.next()) {
					System.out.println(resultEnt.getString("ent_nom") + "  id : " + result.getString("stage_ent_id"));
					return new Offre(result.getString("stage_id"), 
									resultEnt.getString("ent_nom"), 
									result.getString("stage_libelle"), 
									result.getString("stage_description"), 
									result.getString("stage_domaine"), 
									result.getString("stage_debut"), 
									result.getString("stage_duree"), 
									result.getString("stage_path"),
									"",
									result.getString("stage_email")
						); 
				} else {
					JOptionPane.showMessageDialog(null, "[@StageDAO] Erreur inconnue");
					return stage;
				}
			} else {
				JOptionPane.showMessageDialog(null, "[@StageDAO] Erreur inconnue");
				return stage;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return stage;
	}
		
	
	
	public boolean deleteOffre(Object o) {
		Connection connect= dbConnect.getConnection();
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connect.prepareStatement("DELETE FROM `stage` WHERE `stage`.`stage_id` =  " + o.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Override
	public ArrayList<HashMap<String, String>> findAll() {
		return null;
	}

}
