package par.service;

import java.util.List;

import par.entity.Player;

public interface PlayerService {
	void addPlayer(String name, String surname, String yearOfBirth, String statisticOfPlayer);
	Player getPlayerById(int id);
	List<Player> getAllPlayers();
	void update(Player player);
}
