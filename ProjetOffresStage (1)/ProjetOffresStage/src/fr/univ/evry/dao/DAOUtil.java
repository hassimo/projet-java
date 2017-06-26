package fr.univ.evry.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface DAOUtil {

	public void add(Object o) throws SQLException;
	public boolean remove(Object o);
	public Object find(Object o);
	public ArrayList<HashMap<String, String>> findAll();
	
}
