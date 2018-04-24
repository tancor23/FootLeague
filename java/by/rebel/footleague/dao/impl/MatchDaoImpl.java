package by.rebel.footleague.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.rebel.footleague.dao.MatchDao;
import by.rebel.footleague.dao.util.DBConnectionHelper;
import by.rebel.footleague.domain.Match;

/**
 * @author Vydra_Sergei 
 * Class MatchDaoImpl realizes the methods(create, read, readAll, update, delete).
 */
public class MatchDaoImpl implements MatchDao {
	
	private static final Logger logger = LogManager.getLogger();
	private final String SQL_CREATE_DO_INSERT_INTO_FROM_MATCHES = "INSERT INTO matches (home_team, guest_team) VALUE (?,?);";
	private final String SQL_READ_DO_SELECT_NEEDS_FROM_MATCHES = "SELECT match_id, name, login, password, email, role FROM matches WHERE match_id=?";
	private final String SQL_READALL_DO_SELECT_ALL_FROM_MATCHES = "SELECT match_id, name, login, password, email, role FROM matches;";
	private final String SQL_UPDATE_DO_UPDATE_NEEDS_FROM_MATCHES = "UPDATE matches SET login=?, password=? WHERE match_id=?;";
	private final String SQL_DELETE_DO_DELETE_ID_FROM_MATCHES = "DELETE FROM matches WHERE match_id=?;";

	@Override
	public void create(Match match) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_CREATE_DO_INSERT_INTO_FROM_MATCHES,
						Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, match.getNameTheFirstTeam());
			ps.setString(2, match.getNameTheSecondTeam());
			int rowsCount = ps.executeUpdate();
			if (rowsCount == 1) {
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int matchId = result.getInt("match_id");
				match.setId(matchId);
			}
		} catch (SQLException e) {
			logger.error("Error is in MatchDaoImpl.creare(); ", e);
		}
	}

	@Override
	public Match read(int matchId) {
		return null;
	}

	@Override
	public List<Match> readAll() {
		return null;
	}

	@Override
	public void update(Match match) {
	}

	@Override
	public void delete(int matchId) {
	}

}
