package by.rebel.footleague.dao.hbn;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class SessionFactoryManager {

	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration();
		config.configure("config/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		return config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}

}
