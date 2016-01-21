package okolica.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import okolica.app.THelper;

import com.vaadin.ui.UI;

public class TDatabaseManager {

	private final String URL = "jdbc:mysql://127.0.0.1:3306/";
	private final String DB_NAME = "TEST";
	private final String USER = "root";
	private final String PASSWORD = "i1adamek";
	
	private Connection connection;
	private TService service;
	
	public TDatabaseManager(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
			service = new TService(connection);
			UI.getCurrent().getSession().setAttribute(THelper.DATABASE, this);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Object getSQlSingleResult(String query) throws SQLException{
		Statement stm = connection.createStatement();
		ResultSet rs = stm.executeQuery(query);
		return rs.getObject(0);
	}
	
	public void executeSql(final String sql) throws SQLException{
		Statement stm = connection.createStatement();
		stm.execute(sql);
	}
	
	public boolean testConnection(){
		if(connection != null) {
			System.out.print("Login successful !");
			return true;
		}
		return false;
	}

	public TService getService() {
		return service;
	}

	public void setService(TService service) {
		this.service = service;
	}
	
}
