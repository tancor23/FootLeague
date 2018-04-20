package by.rebel.footleague.domain;

import java.io.Serializable;

public abstract class Entity implements Serializable {

	/**
	 * @author Vydra_Sergei
	 * It is the abstract class with id-number and
	 */
	private static final long serialVersionUID = 9025038836818949350L;
	private int id;

	public Entity() {
	}

	public Entity(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
