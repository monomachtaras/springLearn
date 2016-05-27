package par.Dao.imp;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import par.Dao.GameDao;
import par.entity.Game;


@Repository
public class GameDaoImp implements GameDao {
	
	@PersistenceContext
	EntityManager manager;
	
	public void addGame(Game game) {
		manager.persist(game);		
	}

	public Game getGameByID(int id) {		
		return  manager.find(Game.class, id);
	}

	public List<Game> getAllGames() {			
		return  manager.createQuery("from Game", Game.class).getResultList();
	}

	public void update(Game game) {
		manager.merge(game);
		
	}

}
