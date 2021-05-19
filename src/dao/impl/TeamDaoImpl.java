package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import dao.TeamDao;
import model.Player;
import model.Team;
import utility.CloseConnection;
import utility.DbConnection;

public class TeamDaoImpl implements TeamDao {

	PreparedStatement ps = null;
	Statement stmt =null;
	ResultSet rs = null;
	int result  = 0;
	DbConnection con = new DbConnection();
	CloseConnection cs = new CloseConnection();


	public List<Team> getData() {
		
		List<Team> tList = new LinkedList<Team>();
		
		try {
			System.out.println("Creating query");
			String query = "SELECT * FROM team_player.teams;";
					
					stmt = DbConnection.getConnection().createStatement();
					rs = stmt.executeQuery(query);
					
					while(rs.next())
					{
						int id = rs.getInt("team_id");
						String name = rs.getString("team_name");
						 
						 
						Team current = new Team(id, name);
						 
						 tList.add(current);
					}
		}catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}finally {
			cs.closeRes(rs);
			cs.closeStmt(stmt);
			cs.closeCon(con);
		}
		
		return tList;
	}
	
	public int insert(Team team) {
		try {
			System.out.println("Creating query");
			String query = "insert into  team_player.teams(team_id,team_name) \r\n" + 
					"values(?,?);";
					
			ps = con.getConnection().prepareStatement(query);
			ps.setInt(1, team.getTeamId());
			ps.setString(2, team.getTeamname());

			result = ps.executeUpdate();
			System.out.println("Query run successful");
		}catch(Exception de)
		{
			System.out.println("Query running fails");
		}finally {
			cs.closePs(ps);
			cs.closeCon(con);
		}
		
		return result;
	}

}
