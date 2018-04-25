package by.rebel.footleague.domain;

/**
 * @author Vydra_Sergei
 * Class Role is with private fields: id and typeRole. This class is needed to define user role("administrator" or "user") 
 */
public class Role extends Entity {

	private static final long serialVersionUID = -3559330111259643629L;
	
	private String typeRole;

	public Role() {
	}

	public Role(int id) {
		super(id);
	}

	public Role(String typeRole) {
		super();
		this.typeRole = typeRole;
	}

	public Role(int id, String typeRole) {
		super(id);
		this.typeRole = typeRole;
	}

	public String getTypeRole() {
		return typeRole;
	}

	public void setTypeRole(String typeRole) {
		this.typeRole = typeRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * getId();
		result = prime * result + ((typeRole == null) ? 0 : typeRole.hashCode());
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
		Role other = (Role) obj;
		if (typeRole == null) {
			if (other.typeRole != null)
				return false;
		} else if (!typeRole.equals(other.typeRole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "idRole: " + getId() + "; " + "typeRole: " + typeRole + "; ";
	}

}
