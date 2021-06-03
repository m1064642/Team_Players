package services;

import java.util.List;

import dao.TeamDao;
import dao.impl.TeamDaoImpl;
import model.Team;
import myexception.DbException;

public class TeamServices {
	static TeamDao dao = new TeamDaoImpl();

	public List<Team> getData() {

		List<Team> list = dao.getData();

		return list;
	}

	public int addTeam(Team team) throws DbException {

		int result =0;
		result = dao.insert(team);

		if (result == 0) {
			throw new DbException("Team Id Already exist");
		}

		return result;
	}

}
