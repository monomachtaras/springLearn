package par.service.imp;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import par.Dao.MatchDao;
import par.entity.Match;
import par.service.MatchService;

@Service
public class MatchServiceImp implements MatchService {
	
	@Autowired
	MatchDao matchDao;

	@Transactional
	public void addMatch(int p1set, int p2set) {
		matchDao.addMatch(new Match(p1set, p2set));
		
	}

	public Match getMatchByID(int id) {
		return matchDao.getMatchByID(id);
	}

	public List<Match> getAllMatches() {
		return matchDao.getAllMatches();
	}

}
