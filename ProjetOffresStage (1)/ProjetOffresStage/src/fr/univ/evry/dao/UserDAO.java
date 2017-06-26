package fr.univ.evry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

import fr.univ.evry.database.util.DBConnect;
import fr.univ.evry.factory.Compte;

public class UserDAO {
	private DBConnect dbConnect;
	
	public UserDAO(DBConnect dbConnect) {
		this.dbConnect = dbConnect;
	}
	
	public String connect(Object o) {
		Connection connect= dbConnect.getConnection();
		System.out.println("[UserDAO#connect] trying to connect : " + o);
		
		try {
			PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM utilisateurs WHERE email LIKE ? AND pass LIKE ?;");
			
			preparedStatement.setString(1, ((Compte) o).getUser());
			preparedStatement.setString(2, ((Compte) o).getMdp());
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.next()) 
				return result.getString("type");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public boolean signup(String name, String lastName, String email, String pass, String userType) {
		
		if (this.checkUserEmail(email)) {
			Connection connect= dbConnect.getConnection();
			
			try {
				PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO `offre_stage`.`utilisateurs` (`id`, `nom`, `prenom`, `email`, `pass`, `type`) VALUES (null, ?, ?, ?, ?, ?);");
				
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, lastName);
				preparedStatement.setString(3, email);
				preparedStatement.setString(4, pass);
				preparedStatement.setString(5, userType);
				
				preparedStatement.executeUpdate();
				
				System.out.println("preparedStatement :: " + preparedStatement);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			return true;
		}

		return false;
	}
	
	public boolean checkUserEmail(String email) {
		Connection connect= dbConnect.getConnection();
		
		try {
			PreparedStatement preparedStatement = connect.prepareStatement("SELECT COUNT(1) AS count FROM  utilisateurs WHERE EMAIL LIKE ?;");
			
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			return result.getString("count").equals("0");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
