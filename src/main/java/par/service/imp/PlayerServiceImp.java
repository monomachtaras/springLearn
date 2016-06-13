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
	public void addPlayer(String name, String surname, String yearOfBirth, String statisticOfPlayer) {
		playerDao.save(new Player(name, surname, yearOfBirth, statisticOfPlayer));		
	}

	public Player getPlayerById(int id) {
		return playerDao.findOne(id);
	}

	public List<Player> getAllPlayers() {
		return playerDao.findAll();
	}
    @Transactional
	public void update(Player player) {
		playerDao.save(player);		
	}


}
