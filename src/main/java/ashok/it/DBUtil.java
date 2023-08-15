package ashok.it;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static Driver driver;
	static Connection con;
	private static final String URL="jdbc:mysql://localhost:3306/foodie";
	private static final String USERNAME="root";
	private static final String PASSWORD="tiger";
	
	static {
	try {
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		con= DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public static Connection getConnection() {
		return con;
		
	}

}
