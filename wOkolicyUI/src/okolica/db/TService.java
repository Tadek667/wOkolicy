package okolica.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TService {

	Connection conn;
	
	public TService(Connection connection){
		this.conn = connection;
	}
	
	public boolean isLoginSuccessful(String username, String password){
		try {
			String query = "select UzId from Uzytkownik where Login = '#login' and Haslo = '#haslo'";
			query = query.replace("#login", username);
			query = query.replace("#haslo", password);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if(rs.next()) return true;
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
