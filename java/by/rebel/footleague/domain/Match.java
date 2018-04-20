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
 */
public class Match extends Entity implements Serializable {

	private static final long serialVersionUID = 3279318837356131888L;
	private String nameTheFirstTeam;
	private String nameTheSecondTeam;
	private int countOfGoalsTheFirstTeam;
	private int countOfGoalsTheSecondTeam;

	public Match() {
	}

	public Match(int id) {
		super(id);
	}

	public Match(String nameTheFirstTeam, String nameTheSecondTeam, int countOfGoalsTheFirstTeam,
			int countOfGoalsTheSecondTeam) {
		super();
		this.nameTheFirstTeam = nameTheFirstTeam;
		this.nameTheSecondTeam = nameTheSecondTeam;
		this.countOfGoalsTheFirstTeam = countOfGoalsTheFirstTeam;
		this.countOfGoalsTheSecondTeam = countOfGoalsTheSecondTeam;
	}

	public Match(int id, String nameTheFirstTeam, String nameTheSecondTeam, int countOfGoalsTheFirstTeam,
			int countOfGoalsTheSecondTeam) {
		super(id);
		this.nameTheFirstTeam = nameTheFirstTeam;
		this.nameTheSecondTeam = nameTheSecondTeam;
		this.countOfGoalsTheFirstTeam = countOfGoalsTheFirstTeam;
		this.countOfGoalsTheSecondTeam = countOfGoalsTheSecondTeam;
	}

	public String getNameTheFirstTeam() {
		return nameTheFirstTeam;
	}

	public void setNameTheFirstTeam(String nameTheFirstTeam) {
		this.nameTheFirstTeam = nameTheFirstTeam;
	}

	public String getNameTheSecondTeam() {
		return nameTheSecondTeam;
	}

	public void setNameTheSecondTeam(String nameTheSecondTeam) {
		this.nameTheSecondTeam = nameTheSecondTeam;
	}

	public int getCountOfGoalsTheFirstTeam() {
		return countOfGoalsTheFirstTeam;
	}

	public void setCountOfGoalsTheFirstTeam(int countOfGoalsTheFirstTeam) {
		this.countOfGoalsTheFirstTeam = countOfGoalsTheFirstTeam;
	}

	public int getCountOfGoalsTheSecondTeam() {
		return countOfGoalsTheSecondTeam;
	}

	public void setCountOfGoalsTheSecondTeam(int countOfGoalsTheSecondTeam) {
		this.countOfGoalsTheSecondTeam = countOfGoalsTheSecondTeam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * getId();
		result = prime * result + countOfGoalsTheFirstTeam;
		result = prime * result + countOfGoalsTheSecondTeam;
		result = prime * result + ((nameTheFirstTeam == null) ? 0 : nameTheFirstTeam.hashCode());
		result = prime * result + ((nameTheSecondTeam == null) ? 0 : nameTheSecondTeam.hashCode());
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
		if (countOfGoalsTheFirstTeam != other.countOfGoalsTheFirstTeam)
			return false;
		if (countOfGoalsTheSecondTeam != other.countOfGoalsTheSecondTeam)
			return false;
		if (nameTheFirstTeam == null) {
			if (other.nameTheFirstTeam != null)
				return false;
		} else if (!nameTheFirstTeam.equals(other.nameTheFirstTeam))
			return false;
		if (nameTheSecondTeam == null) {
			if (other.nameTheSecondTeam != null)
				return false;
		} else if (!nameTheSecondTeam.equals(other.nameTheSecondTeam))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "nameTheFirstTeam:" + nameTheFirstTeam + ";  " + "nameTheSecondTeam:" + nameTheSecondTeam + ";  "
				+ "countOfGoalsTheFirstTeam:" + countOfGoalsTheFirstTeam + ";  " + "countOfGoalsTheSecondTeam:"
				+ countOfGoalsTheSecondTeam + ";  ";
	}
}
