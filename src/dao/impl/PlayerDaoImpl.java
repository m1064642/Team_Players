package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import dao.PlayerDao;
import model.Player;
import model.Team;
import utility.CloseConnection;
import utility.DbConnection;

public class PlayerDaoImpl implements PlayerDao {

	PreparedStatement ps = null;
	Statement stmt =null;
	ResultSet rs = null;
	int result  = 0;
	DbConnection con = new DbConnection();
	CloseConnection cs = new CloseConnection();
	
	public int insert(Player p) {
		try {
			System.out.println("Creating query");
			String query = "insert into team_player.players (player_id,player_name, player_age, player_gender, player_team) \r\n" + 
					"values(?,?, ?, ?, ?);";
					
			ps = con.getConnection().prepareStatement(query);
			ps.setInt(1, (int) p.getPlayerId());
			ps.setString(2, p.getPlayerName());
			ps.setByte(3, p.getPlayerAge());
			ps.setString(4, p.getPlayerGender());
			ps.setInt(5,  p.getTeam().getTeamId());
			
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
	
public List<Player> getData() {
		
		List<Player> pList = new LinkedList<Player>();
		
		try {
			System.out.println("Creating query");
			String query = "SELECT team_player.players.player_id,team_player.players.player_name, team_player.players.player_age, team_player.players.player_gender, team_player.teams.team_id, team_player.teams.team_name\r\n" + 
					"from team_player.players\r\n" + 
					"inner join team_player.teams\r\n" + 
					"on team_player.players.player_team =  team_player.teams.team_id;";
					
					stmt = DbConnection.getConnection().createStatement();
					rs = stmt.executeQuery(query);
					
					while(rs.next())
					{
						int id = rs.getInt("player_id");
						String name = rs.getString("player_name");
						byte age = rs.getByte("player_age");
						String gender =rs.getString("player_gender");
						int tId = rs.getInt("team_id");
						String tname = rs.getString("team_name");
						
						Team team = new Team(tId, tname);
						
						Player current = new Player(id, name, age, gender, team);
						 
						 pList.add(current);
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
		
		return pList;
	}

}
