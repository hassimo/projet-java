package fr.univ.evry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import fr.univ.evry.database.util.DBConnect;
import fr.univ.evry.factory.Entreprise;

public class EntrepriseDAO implements DAOUtil {
	private DBConnect dbConnect;
	
	public EntrepriseDAO(DBConnect dbConnect) {
		this.dbConnect = dbConnect;
	}

	@Override
	public void add(Object o) throws SQLException {
		Connection connect= dbConnect.getConnection();
		System.out.println("[EntrepriseDAO#add] object : " + o);

		PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO entreprise VALUES (null, ?, ?, ?, ?, ?, ?)");
		
		preparedStatement.setString(1, ((Entreprise) o).getReseau());
		preparedStatement.setString(2, ((Entreprise) o).getRue());
		preparedStatement.setString(3, ((Entreprise) o).getVille());
		preparedStatement.setString(4, ((Entreprise) o).getMail());
		preparedStatement.setString(5, ((Entreprise) o).getTel());
		preparedStatement.setString(6, ((Entreprise) o).getSecteur());
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

	
	@Override
	public ArrayList<HashMap<String, String>> findAll() {
		return null;
	}
	

	public String[] findAllEnt() {
		String[] results = null;
		int i = 0;
		Connection connect= dbConnect.getConnection();
		
		try {
			PreparedStatement preparedStatement = connect.prepareStatement("SELECT COUNT(*) AS total FROM entreprise LIMIT 20");
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			results = new String[result.getInt("total")];
			
			preparedStatement = connect.prepareStatement("SELECT ent_nom FROM entreprise LIMIT 20");
			result = preparedStatement.executeQuery();
			
			while (result.next()) {
				results[i++] = result.getString("ent_nom");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	public String[] findAllDom() {
		String[] results = null;
		int i = 0;
		Connection connect= dbConnect.getConnection();
		
		try {
			PreparedStatement preparedStatement = connect.prepareStatement("SELECT COUNT(*) AS total FROM entreprise LIMIT 40");
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			results = new String[result.getInt("total")];
			
			preparedStatement = connect.prepareStatement("SELECT DISTINCT ent_secteur FROM entreprise LIMIT 40");
			result = preparedStatement.executeQuery();
			
			while (result.next()) {
				results[i++] = result.getString("ent_secteur");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
}
