package by.rebel.footleague.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.rebel.footleague.dao.UserDao;
import by.rebel.footleague.dao.util.DBConnectionHelper;
import by.rebel.footleague.domain.User;

/**
 * @author Vydra_Sergei Class UserDaoImpl realizes the methods(create, read,
 *         readAll, update, delete).
 */
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LogManager.getLogger();
	private final String SQL_CREATE_DO_INSERT_INTO_FROM_USERS = "INSERT INTO users (login, password) VALUE (?,?);";
	private final String SQL_READ_DO_SELECT_NEEDS_FROM_USERS = "SELECT user_id, name, login, password, email, role FROM users WHERE user_id=?";
	private final String SQL_READALL_DO_SELECT_ALL_FROM_USERS = "SELECT user_id, name, login, password, email, role FROM users;";
	private final String SQL_UPDATE_DO_UPDATE_NEEDS_FROM_USERS = "UPDATE users SET login=?, password=? WHERE user_id=?;";
	private final String SQL_DELETE_DO_DELETE_ID_FROM_USERS = "DELETE FROM users WHERE user_id=?;";

	public UserDaoImpl() {
	}

	@Override
	public void create(User user) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_CREATE_DO_INSERT_INTO_FROM_USERS,
						Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			int rowsCount = ps.executeUpdate();
			if (rowsCount == 1) {
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int userId = result.getInt("user_id");
				user.setId(userId);
			}
		} catch (SQLException e) {
			logger.error("Error is in UserDaoImpl.create(): ", e);
		}
	}

	@Override
	public User read(int userId) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_READ_DO_SELECT_NEEDS_FROM_USERS)) {
			ps.setInt(1, userId);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				User user = new User(userId);
				setUserFields(user, result);
				return user;
			}
		} catch (SQLException e) {
			logger.error("Error is in UserDaoImpl.read(): ", e);
		}
		return null;
	}

	@Override
	public List<User> readAll() {
		List<User> users = new ArrayList<>();
		try (Connection connection = DBConnectionHelper.connect(); Statement statement = connection.createStatement()) {
			ResultSet result = statement.executeQuery(SQL_READALL_DO_SELECT_ALL_FROM_USERS);
			while (result.next()) {
				User user = new User();
				setUserFields(user, result);
				users.add(user);
			}
		} catch (SQLException e) {
			logger.error("Error is in UserDaoImpl.readAll(): ", e);
		}
		return null;
	}

	@Override
	public void update(User user) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_DO_UPDATE_NEEDS_FROM_USERS)) {
			prepareUserFields(ps, user);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error is in UserDaoImpl.update(): ", e);
		}
	}

	@Override
	public void delete(int userId) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_DELETE_DO_DELETE_ID_FROM_USERS)) {
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error is in UserDaoImpl.delete(): ", e);
		}
	}

	private void prepareUserFields(PreparedStatement ps, User user) throws SQLException {
		ps.setString(1, user.getLogin());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getId());
	}

	private void setUserFields(User user, ResultSet result) throws SQLException {
		user.setName(result.getString("name"));
		user.setLogin(result.getString("login"));
		user.setPassword(result.getString("password"));
		user.setEmail(result.getString("email"));
		user.setRole(result.getInt("role"));
	}
}
