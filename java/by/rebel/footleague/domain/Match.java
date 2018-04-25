/**
 * 
 */
package by.rebel.footleague.domain;

import java.io.Serializable;

/**
 * @author Vydra_Sergei
 * Class Match is with private fields: id, nameTheFirstTeam, nameTheSecondTeam,
 * countOfGoalsTheFirstTeam, countOfGoalsTheSecondTeam. Getters/setters and
 * constructors were implemented.
 * Disappear pointsHome and pointsGuest in equals, hashcode, toString!!!!!!!!!!!!!!
 */
public class Match extends Entity implements Serializable {

	private static final long serialVersionUID = 3279318837356131888L;
	
	private String nameHomeTeam;
	private String nameGuestTeam;
	private int countOfGoalsHomeTeam;
	private int countOfGoalsGuestTeam;
	private int pointsHomeTeam;
	private int pointsGuestTeam;

	public Match() {
	}

	public Match(int id) {
		super(id);
	}

	public Match(String nameTheFirstTeam, String nameTheSecondTeam, int countOfGoalsTheFirstTeam,
			int countOfGoalsTheSecondTeam) {
		super();
		this.nameHomeTeam = nameTheFirstTeam;
		this.nameGuestTeam = nameTheSecondTeam;
		this.countOfGoalsHomeTeam = countOfGoalsTheFirstTeam;
		this.countOfGoalsGuestTeam = countOfGoalsTheSecondTeam;
	}

	public Match(int id, String nameTheFirstTeam, String nameTheSecondTeam, int countOfGoalsTheFirstTeam,
			int countOfGoalsTheSecondTeam) {
		super(id);
		this.nameHomeTeam = nameTheFirstTeam;
		this.nameGuestTeam = nameTheSecondTeam;
		this.countOfGoalsHomeTeam = countOfGoalsTheFirstTeam;
		this.countOfGoalsGuestTeam = countOfGoalsTheSecondTeam;
	}

	public String getNameTheFirstTeam() {
		return nameHomeTeam;
	}

	public void setNameTheFirstTeam(String nameTheFirstTeam) {
		this.nameHomeTeam = nameTheFirstTeam;
	}

	public String getNameTheSecondTeam() {
		return nameGuestTeam;
	}

	public void setNameTheSecondTeam(String nameTheSecondTeam) {
		this.nameGuestTeam = nameTheSecondTeam;
	}

	public int getCountOfGoalsTheFirstTeam() {
		return countOfGoalsHomeTeam;
	}

	public void setCountOfGoalsTheFirstTeam(int countOfGoalsTheFirstTeam) {
		this.countOfGoalsHomeTeam = countOfGoalsTheFirstTeam;
	}

	public int getCountOfGoalsTheSecondTeam() {
		return countOfGoalsGuestTeam;
	}

	public void setCountOfGoalsTheSecondTeam(int countOfGoalsTheSecondTeam) {
		this.countOfGoalsGuestTeam = countOfGoalsTheSecondTeam;
	}
	
	public int getPointsHomeTeam() {
		return pointsHomeTeam;
	}

	public void setPointsHomeTeam(int pointsHomeTeam) {
		this.pointsHomeTeam = pointsHomeTeam;
	}

	public int getPointsGuestTeam() {
		return pointsGuestTeam;
	}

	public void setPointsGuestTeam(int pointsGuestTeam) {
		this.pointsGuestTeam = pointsGuestTeam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * getId();
		result = prime * result + countOfGoalsHomeTeam;
		result = prime * result + countOfGoalsGuestTeam;
		result = prime * result + ((nameHomeTeam == null) ? 0 : nameHomeTeam.hashCode());
		result = prime * result + ((nameGuestTeam == null) ? 0 : nameGuestTeam.hashCode());
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
		Match other = (Match) obj;
		if (countOfGoalsHomeTeam != other.countOfGoalsHomeTeam)
			return false;
		if (countOfGoalsGuestTeam != other.countOfGoalsGuestTeam)
			return false;
		if (nameHomeTeam == null) {
			if (other.nameHomeTeam != null)
				return false;
		} else if (!nameHomeTeam.equals(other.nameHomeTeam))
			return false;
		if (nameGuestTeam == null) {
			if (other.nameGuestTeam != null)
				return false;
		} else if (!nameGuestTeam.equals(other.nameGuestTeam))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "nameTheFirstTeam:" + nameHomeTeam + ";  " + "nameTheSecondTeam:" + nameGuestTeam + ";  "
				+ "countOfGoalsTheFirstTeam:" + countOfGoalsHomeTeam + ";  " + "countOfGoalsTheSecondTeam:"
				+ countOfGoalsGuestTeam + ";  ";
	}
}
