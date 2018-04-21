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

import by.rebel.footleague.dao.TeamDao;
import by.rebel.footleague.dao.util.DBConnectionHelper;
import by.rebel.footleague.domain.Team;

/**
 * @author Vydra_Sergei Class TeamDaoImpl realizes the methods(create, read,
 *         readAll, update, delete).
 */
public class TeamDaoImpl implements TeamDao {

	private static final Logger logger = LogManager.getLogger();
	private final String SQL_CREATE_DO_INSERT_INTO_FROM_TEAMS = "INSERT INTO teams (team_name) VALUE (?);";
	private final String SQL_READ_DO_SELECT_NEEDS_FROM_TEAMS = "SELECT team_id, team_name FROM teams WHERE team_id=?";
	private final String SQL_READALL_DO_SELECT_ALL_FROM_TEAMS = "SELECT team_id, team_name FROM users;";
	private final String SQL_UPDATE_DO_UPDATE_NEEDS_FROM_TEAMS = "UPDATE teams SET team_name=? WHERE team_id=?;";
	private final String SQL_DELETE_DO_DELETE_ID_FROM_TEAMS = "DELETE FROM teams WHERE team_id=?;";

	@Override
	public void create(Team team) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_CREATE_DO_INSERT_INTO_FROM_TEAMS,
						Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, team.getTeamName());
			int rowsCount = ps.executeUpdate();
			if (rowsCount == 1) {
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int teamId = result.getInt("team_id");
				team.setId(teamId);
			}
		} catch (SQLException e) {
			logger.error("Error is in TeamDaoImpl.create(): ", e);
		}
	}

	@Override
	public Team read(int teamId) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_READ_DO_SELECT_NEEDS_FROM_TEAMS)) {
			ps.setInt(1, teamId);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				Team team = new Team(teamId);
				team.setTeamName(result.getString("team_name"));
				return team;
			}
		} catch (SQLException e) {
			logger.error("Error is in TeamDaoImpl.read(): ", e);
		}
		return null;
	}

	@Override
	public List<Team> readAll() {
		List<Team> teams = new ArrayList<>();
		try (Connection connection = DBConnectionHelper.connect(); Statement statement = connection.createStatement()) {
			ResultSet result = statement.executeQuery(SQL_READALL_DO_SELECT_ALL_FROM_TEAMS);
			while (result.next()) {
				Team team = new Team();
				team.setTeamName(result.getString("team_name"));
				teams.add(team);
			}
		} catch (SQLException e) {
			logger.error("Error is in TeamDaoImpl.readAll(): ", e);
		}
		return null;
	}

	@Override
	public void update(Team team) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_DO_UPDATE_NEEDS_FROM_TEAMS)) {
			ps.setString(1, team.getTeamName());
			ps.setInt(2, team.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error is in TeamDaoImpl.update(): ", e);
		}
	}

	@Override
	public void delete(int teamId) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_DELETE_DO_DELETE_ID_FROM_TEAMS)) {
			ps.setInt(1, teamId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error is in TeamDaoImpl.delete(): ", e);
		}
	}

}
