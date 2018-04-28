package by.rebel.footleague.dao.singleton;

import by.rebel.footleague.dao.impl.MatchDaoImpl;

/**
 * @author Vydra_Sergei 
 * Class MatchDaoSingleton realizes the type Singleton for class MatchDaoImpl.
 */
public class MatchDaoSingleton {

	private static MatchDaoSingleton instance;
	public final MatchDaoImpl matchDao = new MatchDaoImpl();

	private MatchDaoSingleton() {
	}

	public MatchDaoSingleton getDao() {
		if (instance == null) {
			synchronized (MatchDaoSingleton.class) {
				if (instance == null) {
					instance = new MatchDaoSingleton();
				}
			}
		}
		return instance;
	}
}
