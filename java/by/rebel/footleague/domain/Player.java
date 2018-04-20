package by.rebel.footleague.domain;

import java.io.Serializable;

/**
 * @author Vydra_Sergei
 * This class extends Entity. This class "User" is with private fields: id,
 * firstName, secondName, countOfGames, countOfGoals, countOfGoals,
 * countOfYellowCards and countOfRedCards. Getters/setters and constructors were
 * implemented.
 */
public class Player extends Entity implements Serializable {

	private static final long serialVersionUID = -8438137893368975128L;
	private String firstName;
	private String secondName;
	private int countOfGames;
	private int countOfGoals;
	private int countOfYellowCards;
	private int countOfRedCards;

	public Player() {
	}

	public Player(int id) {
		super(id);
	}

	public Player(int id, String firstName, String secondName, int countOfGames, int countOfGoals,
			int countOfYellowCards, int countOfRedCards) {
		super(id);
		this.firstName = firstName;
		this.secondName = secondName;
		this.countOfGames = countOfGames;
		this.countOfGoals = countOfGoals;
		this.countOfYellowCards = countOfYellowCards;
		this.countOfRedCards = countOfRedCards;
	}

	public Player(String firstName, String secondName, int countOfGames, int countOfGoals, int countOfYellowCards,
			int countOfRedCards) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.countOfGames = countOfGames;
		this.countOfGoals = countOfGoals;
		this.countOfYellowCards = countOfYellowCards;
		this.countOfRedCards = countOfRedCards;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getCountOfGames() {
		return countOfGames;
	}

	public void setCountOfGames(int countOfGames) {
		this.countOfGames = countOfGames;
	}

	public int getCountOfGoals() {
		return countOfGoals;
	}

	public void setCountOfGoals(int countOfGoals) {
		this.countOfGoals = countOfGoals;
	}

	public int getCountOfYellowCards() {
		return countOfYellowCards;
	}

	public void setCountOfYellowCards(int countOfYellowCards) {
		this.countOfYellowCards = countOfYellowCards;
	}

	public int getCountOfRedCards() {
		return countOfRedCards;
	}

	public void setCountOfRedCards(int countOfRedCards) {
		this.countOfRedCards = countOfRedCards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * getId();
		result = prime * result + countOfGames;
		result = prime * result + countOfGoals;
		result = prime * result + countOfRedCards;
		result = prime * result + countOfYellowCards;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
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
		Player other = (Player) obj;
		if (countOfGames != other.countOfGames)
			return false;
		if (countOfGoals != other.countOfGoals)
			return false;
		if (countOfRedCards != other.countOfRedCards)
			return false;
		if (countOfYellowCards != other.countOfYellowCards)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "firstName: " + firstName + ";  " + "secondName: " + secondName + ";  " + "countOfGames: " + countOfGames
				+ ";  " + "countOfGoals: " + countOfGoals + ";  " + "countOfYellowCards: " + countOfYellowCards + ";  "
				+ "countOfRedCards: " + countOfRedCards + ";  ";
	}
}
