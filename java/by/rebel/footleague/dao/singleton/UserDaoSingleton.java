package by.rebel.footleague.dao.singleton;

import by.rebel.footleague.dao.impl.UserDaoImpl;

/**
 * @author Vydra_Sergei 
 * Class UserDaoSingleton realizes the type Singleton for class UserDaoImpl.
 */
public class UserDaoSingleton {

	private static UserDaoSingleton instance;
	public final UserDaoImpl userDao = new UserDaoImpl();

	private UserDaoSingleton() {
	}

	public UserDaoSingleton getDao() {
		if (instance == null) {
			synchronized (UserDaoSingleton.class) {
				if (instance == null) {
					instance = new UserDaoSingleton();
				}
			}
		}
		return instance;
	}
}
