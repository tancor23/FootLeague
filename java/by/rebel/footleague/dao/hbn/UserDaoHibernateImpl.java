package by.rebel.footleague.dao.hbn;

import java.util.List;

import org.hibernate.Session;

import by.rebel.footleague.dao.UserDao;
import by.rebel.footleague.domain.User;

public class UserDaoHibernateImpl implements UserDao {

	@Override
	public void create(User user) {
		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public User read(int userId) {

		return null;
	}

	@Override
	public List<User> readAll() {

		return null;
	}

	@Override
	public void update(User user) {
		
	}

	@Override
	public void delete(int userId) {
		
	}

}
