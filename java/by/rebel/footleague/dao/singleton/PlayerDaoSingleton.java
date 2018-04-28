package by.rebel.footleague.dao.singleton;

import by.rebel.footleague.dao.impl.PlayerDaoImpl;

/**
 * @author Vydra_Sergei 
 * Class PlayerDaoSingleton realizes the type Singleton for class PlayerDaoImpl.
 */
public class PlayerDaoSingleton {

	private static PlayerDaoSingleton instance;
	public final PlayerDaoImpl playerDao = new PlayerDaoImpl();

	private PlayerDaoSingleton() {
	}

	public PlayerDaoSingleton getDao() {
		if (instance == null) {
			synchronized (PlayerDaoSingleton.class) {
				if (instance == null) {
					instance = new PlayerDaoSingleton();
				}
			}
		}
		return instance;
	}
}
