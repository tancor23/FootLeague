package by.rebel.footleague.domain;

import java.io.Serializable;

/**
 * @author Vydra_Sergei
 * This class extends Entity. This class "Team" is with private fields: id,
 * teamName and countOfPlayers. Getters/setters and constructors were
 * implemented.
 */
public class Team extends Entity implements Serializable {

	private static final long serialVersionUID = 7033615865120046049L;
	private String teamName;
	private int countOfPlayers;
	private int countOfPoints;

	public Team() {
	}

	public Team(int id) {
		super(id);
	}

	public Team(int id, String teamName) {
		super(id);
		this.teamName = teamName;
	}

	public Team(String teamName) {
		super();
		this.teamName = teamName;
	}

	public Team(String teamName, int countOfPlayers) {
		super();
		this.teamName = teamName;
		this.countOfPlayers = countOfPlayers;
	}

	public Team(int id, String teamName, int countOfPlayers) {
		super(id);
		this.teamName = teamName;
		this.countOfPlayers = countOfPlayers;
	}

	public Team(String teamName, int countOfPlayers, int countOfPoints) {
		super();
		this.teamName = teamName;
		this.countOfPlayers = countOfPlayers;
		this.countOfPoints = countOfPoints;
	}

	public Team(int id, String teamName, int countOfPlayers, int countOfPoints) {
		super(id);
		this.teamName = teamName;
		this.countOfPlayers = countOfPlayers;
		this.countOfPoints = countOfPoints;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getCountOfPlayers() {
		return countOfPlayers;
	}

	public void setCountOfPlayers(int countOfPlayers) {
		this.countOfPlayers = countOfPlayers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * getId();
		result = prime * result + countOfPlayers;
		result = prime * result + countOfPoints;
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (countOfPlayers != other.countOfPlayers)
			return false;
		if (countOfPoints != other.countOfPoints)
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "teamName:" + teamName + ";  " + "countOfPlayers:" + countOfPlayers + ";  " + "countOfPoints:"
				+ countOfPoints + ";  ";
	}

}
