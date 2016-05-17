package par.service;

import java.util.List;

import par.entity.Player;

public interface PlayerService {
	void addPlayer(String name, String surname, int yearOfBirth);
	Player getPlayerById(int id);
	List<Player> getAllPlayers();
}
