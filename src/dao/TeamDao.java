package dao;

import java.util.List;

import model.Player;
import model.Team;

public interface TeamDao {
	
	public List<Team> getData();
	public int insert(Team team);

}
