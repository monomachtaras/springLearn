package par.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import par.Dao.GameDao;
import par.entity.Game;
import par.entity.Player;
import par.entity.Point;
import par.service.GameService;

@Service
public class GameServiceImp implements GameService {

	@Autowired
	GameDao gameDao;

	@Transactional
	public void addGame(String p1sets, String p2sets) {
		gameDao.save(new Game(p1sets, p2sets, "0", "0", "0", "0", "0", "0", "0", "0"));
	}

	@Transactional
	public void update(Game game) {
		gameDao.save(game);
	}

	public Game getGameByID(int id) {
		return gameDao.findOne(id);
	}

	public List<Game> getAllGames() {
		return gameDao.findAll();
	}

	

	public List<Game> gamesWithPoints() {
		return gameDao.gamesWithPoints();
	}

	public int getQuantity() {
		return (int) gameDao.count();
	}



	


}
