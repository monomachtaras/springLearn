package par.Dao;

import java.util.List;

import par.entity.Player;

public interface PlayerDao {
	
	void addPlayer(Player player);
	Player getPlayerById(int id);
	List<Player> getAllPlayers();

}
