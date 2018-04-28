package by.rebel.footleague.dao.singleton;

import by.rebel.footleague.dao.impl.TeamDaoImpl;

/**
 * @author Vydra_Sergei 
 * Class TeamDaoSingleton realizes the type Singleton for class TeamDaoImpl.
 */
public class TeamDaoSingleton {

	private static TeamDaoSingleton instance;
	public final TeamDaoImpl teamDao = new TeamDaoImpl();

	private TeamDaoSingleton() {
	}

	public TeamDaoSingleton getDao() {
		if (instance == null) {
			synchronized (TeamDaoSingleton.class) {
				if (instance == null) {
					instance = new TeamDaoSingleton();
				}
			}
		}
		return instance;
	}
}
