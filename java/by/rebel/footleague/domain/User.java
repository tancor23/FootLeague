package by.rebel.footleague.domain;

import java.io.Serializable;

/**
 * @author Vydra_Sergei
 * Class User is with private fields: id, name, login, password, email.
 * Getters/setters and constructors were implemented.
 */
public class User extends Entity implements Serializable {

	private static final long serialVersionUID = -260159617111769589L;
	private String name;
	private String login;
	private String password;
	private String email;


	public User() {
	}

	public User(int id) {
		super(id);
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public User(int id, String login, String password) {
		super(id);
		this.login = login;
		this.password = password;
	}

	public User(String name, String login, String password, String email) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
	
	}

	public User(int id, String name, String login, String password, String email) {
		super(id);
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * getId();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "name:" + name + ";  " + "login:" + login + ";  " + "password:" + password + ";  " + "email:" + email
				+ ";  ";
	}

}
