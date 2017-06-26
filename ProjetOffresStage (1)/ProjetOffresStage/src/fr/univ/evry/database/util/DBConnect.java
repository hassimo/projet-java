package fr.univ.evry.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private Connection connect = null;
 
	public DBConnect() {
		String host = DBParamEnum.HOST.getValue();
		String db = DBParamEnum.DATABASE.getValue();
		String user = DBParamEnum.USER.getValue();
		String pass = DBParamEnum.PASS.getValue();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://"+ host +"/"+ db +"?user="+ user +"&password=" + pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("[DBConnect] Connected !");
		}
		
	}
	
	
	public Connection getConnection() {
		return this.connect;
	}
	
	public void killConnection() {
		this.connect = null;
	}
}
