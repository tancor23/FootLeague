package by.rebel.footleague.dao;

import java.util.List;
import by.rebel.footleague.domain.Entity;

/**
 * @author Vydra_Sergei
 * Basic interface BaseDao is with five methods.
 */
public interface BaseDao<T extends Entity> {

	void create(T entity);
	T read(int id);
	List<T> readAll();
	void update(T entity);
	void delete(int id);

}
