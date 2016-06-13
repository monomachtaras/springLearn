package par.service;

import java.util.List;


import par.entity.Game;
public interface GameService {
	
	void addGame(String p1sets, String p2sets);
	Game getGameByID(int id);
	List<Game> getAllGames();
	void update(Game game);
	int getQuantity();
	

}
