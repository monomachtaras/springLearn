package par.Dao;

import java.util.List;

import par.entity.Game;


public interface GameDao {
	
	void addGame(Game match);
	Game getGameByID(int id);
	List<Game> getAllGames();
	void update(Game game);

}
