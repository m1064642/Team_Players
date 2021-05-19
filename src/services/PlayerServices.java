package services;

import java.util.List;

import dao.PlayerDao;
import dao.impl.PlayerDaoImpl;
import model.Player;
import model.Team;
import myexception.DbException;

public class PlayerServices {
	static PlayerDao dao = new PlayerDaoImpl();
	
	public int addPlayer(Player p) throws DbException
	{
		int result =0;
		result = dao.insert(p); 
		
		if(result == 0) {
			throw new DbException("Player Id Already exist");
		}
		
		return result;
	}
	
    public List<Player> getData() {
 		
		
		 List<Player> list =dao.getData();
		 
		 return list;
	}
    
    

}
