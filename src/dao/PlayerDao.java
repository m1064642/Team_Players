package dao;

import java.util.List;

import model.Player;
import model.Team;

public interface PlayerDao {
	
	public int insert(Player p);
	public List<Player> getData();

}
