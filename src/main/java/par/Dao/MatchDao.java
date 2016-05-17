package par.Dao;

import java.util.List;

import par.entity.Match;

public interface MatchDao {
	
	void addMatch(Match match);
	Match getMatchByID(int id);
	List<Match> getAllMatches();
	

}
