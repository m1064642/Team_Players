package utility;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseConnection {
	
	public void closeCon(DbConnection con) {
		if( con != null)
		{
			try {
				DbConnection.getConnection().close();
				System.out.println("connection closed.....");
			}catch(ClassNotFoundException | SQLException cse)
			{
				System.err.print("connection can not be closed");
			}
		}
	}
	
	public void closeRes(ResultSet rs) {
		if( rs != null)
		{
			try {
				rs.close();
				System.out.println("connection closed.....");
			}catch(SQLException cse)
			{
				System.err.print("connection can not be closed");
			}
		}
	}
	
	public void closePs(PreparedStatement ps) {
		if( ps != null)
		{
			try {
				ps.close();
				System.out.println("connection closed.....");
			}catch(SQLException cse)
			{
				System.err.print("connection can not be closed");
			}
		}
	}
	
	public void closeStmt(Statement stmt) {
		if( stmt != null)
		{
			try {
				stmt.close();
				System.out.println("connection closed.....");
			}catch(SQLException cse)
			{
				System.err.print("connection can not be closed");
			}
		}
	}

}
