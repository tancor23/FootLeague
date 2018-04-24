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

import by.rebel.footleague.dao.PlayerDao;
import by.rebel.footleague.dao.util.DBConnectionHelper;
import by.rebel.footleague.domain.Player;

/**
 * @author Vydra_Sergei Class PlayerDaoImpl realizes the methods(create, read,
 *         readAll, update, delete).
 */
public class PlayerDaoImpl implements PlayerDao {

	private static final Logger logger = LogManager.getLogger();
	private final String SQL_CREATE_DO_INSERT_INTO_FROM_PLAYERS = "INSERT INTO players (first_name, second_name) VALUE (?,?);";
	private final String SQL_READ_DO_SELECT_NEEDS_FROM_PLAYERS = "SELECT player_id, first_name, second_name, count_of_games, count_of_goals, count_of_yellow_cards, count_of_red_cards FROM players WHERE player_id=?";
	private final String SQL_READALL_DO_SELECT_ALL_FROM_PLAYERS = "SELECT player_id, first_name, second_name, count_of_games, count_of_goals, count_of_yellow_cards, count_of_red_cards FROM players;";
	private final String SQL_UPDATE_DO_UPDATE_NEEDS_FROM_PLAYERS = "UPDATE players SET first_name=?, second_name=? WHERE player_id=?;";
	private final String SQL_DELETE_DO_DELETE_ID_FROM_PLAYERS = "DELETE FROM players WHERE player_id=?;";

	@Override
	public void create(Player player) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_CREATE_DO_INSERT_INTO_FROM_PLAYERS,
						Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, player.getFirstName());
			ps.setString(2, player.getSecondName());
			int rowsCount = ps.executeUpdate();
			if (rowsCount == 1) {
				ResultSet result = ps.getGeneratedKeys();
				result.next();
				int playerId = result.getInt("player_id");
				player.setId(playerId);
			}
		} catch (SQLException e) {
			logger.error("Error is in PlayerDaoImpl.creare(); ", e);
		}
	}

	@Override
	public Player read(int playerId) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_READ_DO_SELECT_NEEDS_FROM_PLAYERS)) {
			ps.setInt(1, playerId);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				Player player = new Player(playerId);
				setPlayerFields(player, result);
				return player;
			}
		} catch (SQLException e) {
			logger.error("Error is in PlayerDaoImpl.read(); ", e);
		}
		return null;
	}

	@Override
	public List<Player> readAll() {
		List<Player> players = new ArrayList<>();
		try (Connection connection = DBConnectionHelper.connect(); Statement statement = connection.createStatement()) {
			ResultSet result = statement.executeQuery(SQL_READALL_DO_SELECT_ALL_FROM_PLAYERS);
			while (result.next()) {
				Player player = new Player();
				setPlayerFields(player, result);
				players.add(player);
			}
		} catch (SQLException e) {
			logger.error("Error is in PlayerDaoImpl.readAll(): ", e);
		}
		return null;
	}

	@Override
	public void update(Player player) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_DO_UPDATE_NEEDS_FROM_PLAYERS)) {
			preparePlayerFields(ps, player);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error is in PlayerDaoImpl.update(): ", e);
		}
	}

	@Override
	public void delete(int playerId) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(SQL_DELETE_DO_DELETE_ID_FROM_PLAYERS)) {
			ps.setInt(1, playerId);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error is in PlayerDaoImpl.delete(): ", e);
		}
	}

	private void setPlayerFields(Player player, ResultSet result) throws SQLException {
		player.setFirstName(result.getString("first_name"));
		player.setSecondName(result.getString("second_name"));
		player.setCountOfGames(result.getInt("count_of_games"));
		player.setCountOfGoals(result.getInt("count_of_goals"));
		player.setCountOfYellowCards(result.getInt("count_of_yellow_cards"));
		player.setCountOfRedCards(result.getInt("count_of_red_cards"));
	}

	private void preparePlayerFields(PreparedStatement ps, Player player) throws SQLException {
		ps.setString(1, player.getFirstName());
		ps.setString(2, player.getSecondName());
		ps.setInt(3, player.getId());
	}
}
