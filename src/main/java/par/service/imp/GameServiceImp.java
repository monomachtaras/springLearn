package par.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import par.Dao.GameDao;
import par.dtos.GameDto;
import par.entity.Game;
import par.service.GameService;

@Service
public class GameServiceImp implements GameService {

	@Autowired
	GameDao gameDao;

	@Transactional
	public void addGame(String p1sets, String p2sets) {
		gameDao.addGame(new Game(p1sets, p2sets));

	}

	public Game getGameByID(int id) {
		return gameDao.getGameByID(id);
	}

	public List<Game> getAllGames() {
		return gameDao.getAllGames();
	}

	@Transactional
	public void update(Game game) {
		gameDao.update(game);

	}

	public List<GameDto> gamesDto() {
		List<GameDto> dtos = new ArrayList<GameDto>();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}

}
