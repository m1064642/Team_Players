package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL= "jdbc:mysql://localhost:3306/quarantine_pateint";
	static final String USER = "root";
	static final String PASS = "mindtree@1";
	
	public static Connection getConnection() throws ClassNotFoundException {
		
		Connection con = null;
		try {
			System.out.println("connection establishing....");
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL,USER, PASS);
			
		}catch(SQLException se)
		{
			System.err.println("Connection failed...");
		}
		
		
		return con;
		
	}
	
	

}
