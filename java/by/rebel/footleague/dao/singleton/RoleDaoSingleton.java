package by.rebel.footleague.dao.singleton;

import by.rebel.footleague.dao.impl.RoleDaoImpl;

/**
 * @author Vydra_Sergei Class RoleDaoSingleton realizes the type Singleton for
 *         class RoleDaoImpl.
 */
public class RoleDaoSingleton {
	private static RoleDaoSingleton instance;
	public final RoleDaoImpl matchDao = new RoleDaoImpl();

	private RoleDaoSingleton() {
	}

	public RoleDaoSingleton getDao() {
		if (instance == null) {
			synchronized (RoleDaoSingleton.class) {
				if (instance == null) {
					instance = new RoleDaoSingleton();
				}
			}
		}
		return instance;
	}
}
