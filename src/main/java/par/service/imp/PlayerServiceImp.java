package par.service.imp;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import par.Dao.PlayerDao;
import par.entity.Player;
import par.service.PlayerService;

@Service
public class PlayerServiceImp  implements PlayerService{
    
	@Autowired
	private PlayerDao playerDao;
	
	@Transactional
	public void addPlayer(String name, String surname, String yearOfBirth) {
		playerDao.addPlayer(new Player(name, surname, yearOfBirth));		
	}

	public Player getPlayerById(int id) {
		return playerDao.getPlayerById(id);
	}

	public List<Player> getAllPlayers() {
		return playerDao.getAllPlayers();
	}

}
