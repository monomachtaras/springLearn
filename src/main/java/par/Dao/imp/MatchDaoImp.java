package par.Dao.imp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.cfg.CreateKeySecondPass;
import org.springframework.stereotype.Repository;
import par.Dao.MatchDao;
import par.entity.Match;

@Repository
public class MatchDaoImp implements MatchDao {
	
	@PersistenceContext
	EntityManager manager;
	
	public void addMatch(Match match) {
		manager.persist(match);		
	}

	public Match getMatchByID(int id) {		
		return  manager.find(Match.class, id);
	}

	public List<Match> getAllMatches() {		
		return  manager.createQuery("from MATCHH", Match.class).getResultList();
	}

}
