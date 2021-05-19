package model;

public class Team {
	
	private int teamId;
	private String teamname;
	
	public Team(int teamId, String teamname) {
		super();
		this.teamId = teamId;
		this.teamname = teamname;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

}
