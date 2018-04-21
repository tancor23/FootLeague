package by.rebel.footleague.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	@Override
	public void create(Player player) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO players (first_name, second_name) VALUE (?,?);",
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
			logger.error("Error is in PlayerDaoImpl.creare(); ");
		}
	}

	@Override
	public Player read(int playerId) {
		try (Connection connection = DBConnectionHelper.connect();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT player_id, first_name, second_name, count_of_games, count_of_goals, count_of_yellow_cards, count_of_red_cards FROM players WHERE player_id=?")) {
			ps.setInt(1, playerId);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				Player player = new Player(playerId);
				doPlayerSet(player, result);
				return player;
			}
		} catch (SQLException e) {
			logger.error("Error is in PlayerDaoImpl.read(); ");
		}
		return null;
	}

	private void doPlayerSet(Player player, ResultSet result) throws SQLException {
		player.setFirstName(result.getString("first_name"));
		player.setSecondName(result.getString("second_name"));
		player.setCountOfGames(result.getInt("count_of_games"));
		player.setCountOfGoals(result.getInt("count_of_goals"));
		player.setCountOfYellowCards(result.getInt("count_of_yellow_cards"));
		player.setCountOfRedCards(result.getInt("count_of_red_cards"));
	}

	@Override
	public List<Player> readAll() {
		return null;
	}

	@Override
	public void update(Player player) {
	}

	@Override
	public void delete(int id) {
	}

}
