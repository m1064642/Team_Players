package model;

public class Player implements Comparable<Player> {
	private long playerId;
	private String playerName;
	private byte playerAge;
	private String playerGender;
	private Team team;
	
	public Player(long playerId, String playerName, byte playerAge, String playerGender, Team team) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerAge = playerAge;
		this.playerGender = playerGender;
		this.team = team;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public byte getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(byte playerAge) {
		this.playerAge = playerAge;
	}

	public String getPlayerGender() {
		return playerGender;
	}

	public void setPlayerGender(String playerGender) {
		this.playerGender = playerGender;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	@Override
	public int compareTo(Player p) {
		
		if(playerAge == p.playerAge)
		{
			return 0;
		}else if(playerAge > p.playerAge)
			return 1;
		else
			return -1;
	}
	
	

}
