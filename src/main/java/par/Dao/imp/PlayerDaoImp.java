package par.Dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import par.Dao.PlayerDao;
import par.entity.Player;

@Repository
public class PlayerDaoImp implements PlayerDao {
	
	@PersistenceContext
	EntityManager manager;

	public void addPlayer(Player player) {
		manager.persist(player);		
	}

	public Player getPlayerById(int id) {
		return manager.find(Player.class, id);
	}

	public List<Player> getAllPlayers() {
		return manager.createQuery("from PLAYER", Player.class).getResultList();
	}

}
